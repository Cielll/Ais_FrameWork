

package com.airport.ais.dao.parameter;

import java.io.Serializable;
import java.util.List;

import com.airport.ais.models.report.AggregationColumnField;
import com.airport.ais.models.report.GroupField;



/**
 * 
 * FileName      QueryConditions.java
 * @Description  TODO  查询条件 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月22日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public class QueryCondition implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 条件表达式
	 */
	private Object[] expression;
	
	/**
	 *  排序字段
	 */
	private QueryOrder[] orders;
	
	
	/**
	 *  分页开始标记
	 */
	private int first;
	
	/**
	 * 分页结束标记
	 */
	private int max;

	/**
	 *  连接一对多的标识符
	 */
	private String fetchOneToMany;
	
	/**
	 *  连接多对一的标识符
	 */
	private String fetchManyToOne;
	
	
	/**
	 *  分组字段
	 */
	private List<GroupField> groupFields;
	
	/**
	 *  聚合字段
	 */
	private List<AggregationColumnField> aggregationFields;

	/**
	 * @return the expression
	 */
	public Object[] getExpression() {
		return expression;
	}

	/**
	 * @param expression the expression to set
	 */
	public void setExpression(Object[] expression) {
		this.expression = expression;
	}

	/**
	 * @return the orders
	 */
	public QueryOrder[] getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(QueryOrder[] orders) {
		this.orders = orders;
	}

	/**
	 * @return the first
	 */
	public int getFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(int first) {
		this.first = first;
	}

	/**
	 * @return the max
	 */
	public int getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		this.max = max;
	}

	/**
	 * @return the fetchOneToMany
	 */
	public String getFetchOneToMany() {
		return fetchOneToMany;
	}

	/**
	 * @param fetchOneToMany the fetchOneToMany to set
	 */
	public void setFetchOneToMany(String fetchOneToMany) {
		this.fetchOneToMany = fetchOneToMany;
	}

	/**
	 * @return the fetchManyToOne
	 */
	public String getFetchManyToOne() {
		return fetchManyToOne;
	}

	/**
	 * @param fetchManyToOne the fetchManyToOne to set
	 */
	public void setFetchManyToOne(String fetchManyToOne) {
		this.fetchManyToOne = fetchManyToOne;
	}

	/**
	 * @return the groupFields
	 */
	public List<GroupField> getGroupFields() {
		return groupFields;
	}

	/**
	 * @param groupFields the groupFields to set
	 */
	public void setGroupFields(List<GroupField> groupFields) {
		this.groupFields = groupFields;
	}

	/**
	 * @return the aggregationFields
	 */
	public List<AggregationColumnField> getAggregationFields() {
		return aggregationFields;
	}

	/**
	 * @param aggregationFields the aggregationFields to set
	 */
	public void setAggregationFields(List<AggregationColumnField> aggregationFields) {
		this.aggregationFields = aggregationFields;
	}
	

	
}
