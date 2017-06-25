package com.airport.ais.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.FetchParent;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import com.airport.ais.dao.IDao;
import com.airport.ais.dao.parameter.ExpressionUtil;
import com.airport.ais.dao.parameter.QueryCondition;
import com.airport.ais.enums.QuerySortMode;
import com.airport.ais.models.report.AggregationColumnField;
import com.airport.ais.models.report.ColumnField;
import com.airport.ais.models.report.GroupField;


/**
 * 
 * 
 * FileName      DaoImpl.java
 * @Description  TODO 通用的DAO层接口抽象类，实现各种通用的操作数据库的方法
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月23日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月23日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Stateless
@SuppressWarnings("unchecked")
public abstract class DaoImpl<K,E> implements IDao<K, E> {
	


	protected EntityManager em;
	
	
	/**
	 * 将实体对象的ManytoOne的对象以LeftJion的方式链接
	 * @param cb     CriteriaBuilder对象
	 * @param fetchParent Fetch的父类对象
	 * @param javaType 需要链接实体对象的类型
	 */
	
	@SuppressWarnings("rawtypes")
	private void fetchJionEntity(CriteriaBuilder cb,FetchParent fetchParent,Class javaType,QueryCondition condition,boolean isRoot){
		CriteriaQuery cq = cb.createQuery(javaType);
		Root  root=  cq.from(javaType);
		//获取元模型及取得元模型所对应的所有属性
		EntityType entityType = root.getModel();
		Set<Attribute> attributes = entityType.getAttributes();
		 for (Attribute attribute:attributes){
			 if (attribute instanceof SingularAttribute) {
					SingularAttribute singularAttribute = (SingularAttribute) attribute;
					if ((attribute.getPersistentAttributeType().equals(Attribute.PersistentAttributeType.MANY_TO_ONE))
						&&(!isRoot ||condition.getFetchManyToOne().equals("ALL")
								||condition.getFetchManyToOne().indexOf(singularAttribute.getName())!=-1))
						
					{
						//如果该属性是ManytoOne，以LeftJion方式链接
						FetchParent fetchChild = fetchParent.fetch(singularAttribute,JoinType.LEFT);
						//以递归方式链接该属性中包含的ManytoOne的属性
						fetchJionEntity(cb, fetchChild, singularAttribute.getJavaType(),condition,false);
					}
			 } else if (attribute instanceof SetAttribute){
				 SetAttribute setAttribute = (SetAttribute) attribute;
				 if ((condition.getFetchOneToMany().indexOf(setAttribute.getName())!= -1||condition.getFetchOneToMany().equals("ALL")) &&
					 (attribute.getPersistentAttributeType().equals(Attribute.PersistentAttributeType.ONE_TO_MANY)))
				 {
					//如果该属性是OneToMany，以LeftJion方式链接
					 fetchParent.fetch(setAttribute,JoinType.LEFT);
					 
				 }
			 }
		 }
		
	}	
	
	
	
	
	
	
	/**
	 * 以给定的条件查询返回TypedQuery的对象，提供给其他方法以获取最后的结果
	 * @param condition 给定的条件 
	 * @return TypedQuery对象
	 */
	
	private TypedQuery<E> findByCondition(QueryCondition condition,Class<E> clazz){
		
		
		List<Order> orders = new ArrayList<Order>();
		if (condition.getFetchManyToOne() == null){
			condition.setFetchManyToOne("ALL");
		}
		
		if (condition.getFetchOneToMany() == null){
			condition.setFetchOneToMany("");
		}
		
		CriteriaBuilder  cb = em.getCriteriaBuilder();
		CriteriaQuery<E> cq = cb.createQuery(clazz);
		Root<E> root=  cq.from(clazz);
		

		EntityType<E> entityType = root.getModel();
		Set<Attribute<? super E, ?>> attributes=entityType.getAttributes();
		for(Attribute<? super E, ?> attribute:attributes){
		//用元模型的属性替换条件表达式中的实体属性的静态字符串
			for (int i=0;(condition.getExpression() != null)&&(i<condition.getExpression().length);i++){
				if (attribute.getName().equals(condition.getExpression()[i])){
					condition.getExpression()[i] = root.get((SingularAttribute<? super E, ?>) attribute);
				}
			}
			
			//用元模型属性替换排序表达式中的实体属性的静态字符串
			for (int i=0;(condition.getOrders() != null)&&(i< condition.getOrders().length);i++){

				if (attribute.getName().equals(condition.getOrders()[i].getName())){
					if (condition.getOrders()[i].getQuerySortMode().equals(QuerySortMode.ASC)) {
						orders.add(cb.asc(root.get((SingularAttribute<? super E, ?>) attribute)));
					}else{
						orders.add(cb.desc(root.get((SingularAttribute<? super E, ?>) attribute)));
					}

				}

				
			}

		}
		
        
		fetchJionEntity(cb, root, clazz,condition,true);

		
		if (condition.getExpression() != null){
			try {
				Predicate predicate = new ExpressionUtil(cb).composeExpression(condition.getExpression());
				cq.where(predicate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		cq.orderBy(orders);
		cq.distinct(true);
		return em.createQuery(cq);
	}
	

	/**
	 * 
	 * @Description: 返回符合条件的记录数量
	 * @param conditions 条件
	 * @return 符合的实体数量
	 */
	private int CountByCondition(QueryCondition conditions,Class<E> clazz){
		
		
		CriteriaBuilder  cb = em.getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		Root<E> root=  cq.from(clazz);
		EntityType<E> entityType = root.getModel();
		Set<Attribute<? super E, ?>> attributes=entityType.getAttributes();
		for(Attribute<? super E, ?> attribute:attributes){
		//用元模型的属性替换条件表达式中的实体属性的静态字符串
			for (int i=0;(conditions.getExpression() != null)&&(i<conditions.getExpression().length);i++){
				if (attribute.getName().equals(conditions.getExpression()[i])){
					conditions.getExpression()[i] = root.get((SingularAttribute<? super E, ?>) attribute);
				}
			}
			

		}
		
		if (conditions.getExpression() != null){
			try {
				Predicate condition = new ExpressionUtil(cb).composeExpression(conditions.getExpression());
				cq.where(condition);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		cq.select(cb.countDistinct(root));
		return  em.createQuery(cq).getSingleResult().intValue();
		
	}
	

	/**
	 * 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param cb
	 * @param javaType
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Expression getsubExpression(CriteriaBuilder cb,Class javaType,Root root,Object attributeName,SetAttribute setAttribute,List<Join> joins){

		try {
			CriteriaQuery cq = cb.createQuery(javaType);
			Root subroot;			
			subroot = cq.from(javaType);
			boolean foundJoin =false;
			Join setJoin = null;
			//获取元模型及取得元模型所对应的所有属性
			EntityType entityType = subroot.getModel();
			Set<Attribute> attributes = entityType.getAttributes();
			for(Attribute attribute:attributes){
				if (attribute.getName().equals(attributeName)){
					for (Join join:joins){
						if (javaType.equals(join.getModel().getBindableJavaType())){
							foundJoin = true;
							setJoin = join;
						}
					}
					if (!foundJoin){ 
						setJoin =root.join(setAttribute,JoinType.INNER);
						joins.add(setJoin);
					}
					return setJoin.get((SingularAttribute) attribute);
				}
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			/**
			 *  如果类型不是实体类，返回空
			 */
			return null;
		}

		return null;
		
	}
	
	
	
	/**
	 * 
	 * @Description: 根据条件进行求和处理
	 * @param condition 条件
	 * @return 最终查询的TypedQuery的对象
	 * @throws Exception 
	 */
	@SuppressWarnings("rawtypes")
	private TypedQuery<Tuple> AggregationByCondition(QueryCondition condition,Class<E> clazz) throws Exception{
		
		List<Order> orders = new ArrayList<Order>();
		CriteriaBuilder  cb = em.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createQuery(Tuple.class);
		Root<E> root=  cq.from(clazz);
		EntityType entityType = root.getModel();
		ExpressionUtil expresstionUtil = new ExpressionUtil(cb);
		List<Join> joins = new ArrayList<Join>();
		
		Set<Attribute> attributes=entityType.getAttributes();
		for(Attribute attribute:attributes){
		//用元模型的属性替换条件表达式中的实体属性的静态字符串
			for (int i=0;(condition.getExpression() != null)&&(i<condition.getExpression().length);i++){
				if (attribute.getName().equals(condition.getExpression()[i])){
					condition.getExpression()[i] = root.get((SingularAttribute) attribute);
				}else if (attribute instanceof SetAttribute){
					Class javaType = ((SetAttribute)attribute).getBindableJavaType();
					Expression expression = getsubExpression(cb, javaType,root,condition.getExpression()[i],(SetAttribute) attribute,joins);
					if (expression != null){
						condition.getExpression()[i] = expression;
					}					
				}
			}
			
			
			//用元模型的属性替代求和字段的静态字符串
			for (AggregationColumnField field:condition.getAggregationFields()){
				for(int i=0;(field.getExpression() != null)&&(i<field.getExpression().length);i++){
					if (attribute.getName().equals(field.getExpression()[i])){
						field.getExpression()[i] = root.get((SingularAttribute) attribute);
					}else if (attribute instanceof SetAttribute){
						Class javaType = ((SetAttribute)attribute).getBindableJavaType();
						Expression expression = getsubExpression(cb, javaType,root,field.getExpression()[i],(SetAttribute) attribute,joins);
						if (expression != null){
							field.getExpression()[i] = expression;
						}
					}
				}
			
				
			for(int i=0;(field.getWhenCondition() != null)&&(i<field.getWhenCondition().length);i++){
					if (attribute.getName().equals(field.getWhenCondition()[i])){
						field.getWhenCondition()[i] = root.get((SingularAttribute) attribute);
					}else if (attribute instanceof SetAttribute){
						Class javaType = ((SetAttribute)attribute).getBindableJavaType();
						Expression expression = getsubExpression(cb, javaType,root,field.getWhenCondition()[i],(SetAttribute) attribute,joins);
						if (expression != null){
							field.getWhenCondition()[i] = expression;
						}
					}
				}
			}
			//用元模型属性替代分组字段的静态字符串
			if (condition.getGroupFields() != null){
				for (GroupField field:condition.getGroupFields()){
					if (attribute.getName().equals(field.getExpression())){

						field.setExpression( root.get((SingularAttribute) attribute));
					}else if (attribute instanceof SetAttribute){
						Class javaType = ((SetAttribute)attribute).getBindableJavaType();
						Expression expression = getsubExpression(cb, javaType,root,field.getExpression(),(SetAttribute) attribute,joins);
						if (expression != null){
							field.setExpression(expression);
						}						
					}
				}
			}
			
			for (int i=0;(condition.getOrders() != null)&&(i< condition.getOrders().length);i++){

				if (attribute.getName().equals(condition.getOrders()[i].getName())){
					if (condition.getOrders()[i].getQuerySortMode().equals(QuerySortMode.ASC)) {
						orders.add(cb.asc(root.get((SingularAttribute<? super E, ?>) attribute)));
					}else{
						orders.add(cb.desc(root.get((SingularAttribute<? super E, ?>) attribute)));
					}

				}
			}
			

		}
		
		
		
		if (condition.getExpression() != null){
			try {
				Predicate predicate = expresstionUtil.composeExpression(condition.getExpression());
				cq.where(predicate);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		List<Selection<?>> selections = new ArrayList<Selection<?>>();
		
		for (AggregationColumnField field:condition.getAggregationFields()){
			
			Expression expression = expresstionUtil.composeExpression(field.getExpression());
			
			if (field.getWhenCondition() != null){
				Predicate predicate = expresstionUtil.composeExpression(field.getWhenCondition());
				expression = cb.selectCase().when(predicate, expression).otherwise(0);
			}
			
			switch (field.getAggregationType()) {
			case Sum:
				selections.add(cb.sum(expression).alias(field.getAlias()));
				break;
			case Avg:
				selections.add(cb.avg(expression).alias(field.getAlias()));
				break;
			case Count:
				selections.add(cb.count(expression).alias(field.getAlias()));
				break;
			case None:
				selections.add(expression.alias(field.getAlias()));
				break;
			}
		}
		
		
		
		List<Expression<?>>  expressions = new ArrayList<Expression<?>>() ;
		if (condition.getGroupFields() != null){
			for (GroupField field:condition.getGroupFields()){

				Expression expression=  (Expression) field.getExpression();
			
				if (field.getQueryGroupDate() != null){
					expression = expresstionUtil.getYMDExpression(field.getQueryGroupDate(), expression);
				}
				expressions.add(expression);
				selections.add(expression.alias(field.getAlias()));
			}
		}
		//分组字段放入cq中
		cq.groupBy(expressions);
		cq.orderBy(orders);
		
		
		cq.multiselect(selections);
		return em.createQuery(cq);
		
	}
		
	
	

	/** 
	* 通过构造方法指定DAO的具体实现类 
	*/

	public DaoImpl() {
	     
		
	}
	

	/**
	 * 传递EntityManager值给操作em
	 */	
	public abstract void setEntityManager();

	@Override
	public E save(E entity) {
		entity = em.merge(entity);
		em.persist(entity);
		return (E) entity;
	
	}


	@Override
	public void delete(E entity) {
		entity = em.merge(entity);
		em.remove(entity);
	}

	@Override
	public E update(E entity) {
		return (E) em.merge(entity);
	}

	@Override
	public E findById(K id,Class<E> clazz) {
		// TODO Auto-generated method stub
		
		return em.find(clazz, id);
		
	}

	@Override
	public List<E> getAll(Class<E> clazz) {
		// TODO Auto-generated method stub
		QueryCondition conditions = new QueryCondition();
		return findByCondition(conditions,clazz).getResultList();
	}


	@Override
	public List<E> findByFieldAll(String field, Object value,Class<E> clazz) {
		
		QueryCondition conditions = new QueryCondition();
		conditions.setExpression(new Object[]{field,"=",value});
		return findByCondition(conditions,clazz).getResultList();
	}

	@Override
	public E findByFieldSingle(String field, Object value,Class<E> clazz) {
		QueryCondition conditions = new QueryCondition();
		conditions.setExpression(new Object[]{field,"=",value});
		try {
			return findByCondition(conditions,clazz).setMaxResults(1).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public E findByConditionSingle(QueryCondition conditions,Class<E> clazz) {

		try {
			return findByCondition(conditions,clazz).setMaxResults(1).getSingleResult();
		} catch (Exception e) {
//			e.printStackTrace();
			return null;
		}
		
	}


	@Override
	public List<E> findByConditionAll(QueryCondition conditions,Class<E> clazz) {
		if (conditions.getMax() != 0){
			return  findByCondition(conditions,clazz).
					setMaxResults(conditions.getMax()).
					setFirstResult(conditions.getFirst()).getResultList();
		}else {
			return findByCondition(conditions,clazz).getResultList();
		}
		
	}



	@Override
	public int findCountByCondition(QueryCondition conditions,Class<E> clazz) {
		
		
		return CountByCondition(conditions,clazz);
	}
	
	@Override
	public List<Map<String,Object>> findAggregationByCondition(QueryCondition conditions,Class<E> clazz) throws Exception{
		List<Tuple> tuples = AggregationByCondition(conditions,clazz).getResultList();
		List<Map<String,Object>> records = new ArrayList<Map<String,Object>>();
		Map<String, Object> record = null;
		for (Integer i=0; i < tuples.size();i++){
			
			record = new HashMap<String, Object>();
			record.put("id", i);
			for(ColumnField field:conditions.getAggregationFields()){
				record.put(field.getAlias(),tuples.get(i).get(field.getAlias()));
			}
			if (conditions.getGroupFields()!=null){
				for(GroupField field:conditions.getGroupFields()){
					
					if (tuples.get(i).get(field.getAlias()) != null){
						record.put(field.getAlias(),tuples.get(i).get(field.getAlias()).toString());	
					}else{
						record.put(field.getAlias(),null);	
					}
					
					
				}
			}
			if (conditions.getGroupFields() != null&&conditions.getGroupFields().size()>0){
				GroupField field = conditions.getGroupFields().get(0);
				Object rowValue = tuples.get(i).get(field.getAlias());
				if (rowValue != null&&!"".equals(rowValue)){
					records.add(record);
				}
			}else{
				records.add(record);
			}
		}
		return records;
	}
	
	
}
