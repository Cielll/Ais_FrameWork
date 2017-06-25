package com.airport.ais.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import com.airport.ais.dao.parameter.QueryCondition;

/**
 * 
 * FileName      IDao.java
 * @Description  TODO 通用DAO层接口
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月22日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Local
public interface IDao <K,E>{
	
	/**
	 * 在数据库保存一个对象
	 * @param E 实体对象
	 * @return 返回保存的ID值
	 */
	public E save(E obj);
	
	
	/**
	 * 在数据库中删除一个给定的对象
	 * @param E 实体对象
	 */
	public void delete(E entity);
	
	/**
	 * 更新一个对象的方法
	 * @param E 实体类
	 */
	public E update(E entity);
	
	
	/**
	 * 从数据库中返回给定一个ID的实体对象
	 * @param id	给定的ID
	 * @return	查询到的实体对象
	 */
	public E findById(K id,Class<E> clazz);
	
	/**
	 * 从数据库返回给一个特定实体对象的所有数据
	 * @return	所有的给定实体对象类型的所有数据
	 */
	public List<E> getAll(Class<E> clazz);
	
	
	
	
	
	
	/**
	 * 根据给定的字段名及数据来获得一个实体对象
	 * @param field 给定的字段名
	 * @param value	指定的数据
	 * @return 符合条件的一个实体对象
	 */
	public E findByFieldSingle(String field,Object value,Class<E> clazz);
	
	
	
	/**
	 * 根据给定的字段名及数据来获得实体对象集合
	 * @param field 给定的字段名
	 * @param value	指定的数据
	 * @return 符合条件的实体对象集合
	 */
	public List<E> findByFieldAll(String field,Object value,Class<E> clazz);

	
	
	/**
	 * 根据给定的条件及数据来获得实体对象集合
	 * @param  conditions 传入的条件
	 * @return 符合条件的一个实体对象
	 */
	public E findByConditionSingle(QueryCondition condition,Class<E> clazz);
	
	/**
	 根据给定的条件及数据来获得实体对象集合
	 * @param  conditions 传入的条件
	 * @return 符合条件的实体对象集合
	 */
	public List<E> findByConditionAll(QueryCondition condition,Class<E> clazz);
	
	/**
	 * 
	 * @Description: TODO 根据给定的条件获取符合条件的数量
	 * @param conditions 传入的条件
	 * @return 获取符合条件对象的数量
	 */
	public int findCountByCondition(QueryCondition condition,Class<E> clazz);



	/**
	 * 
	 * @Description: TODO 根据给定的条件进行聚合处理
	 * @param conditions 传入的条件
	 * @return 聚合的结果
	 */
	public List<Map<String,Object>> findAggregationByCondition(QueryCondition condition,Class<E> clazz) throws Exception;
}
