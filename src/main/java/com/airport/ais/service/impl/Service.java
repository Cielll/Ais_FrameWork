package com.airport.ais.service.impl;

import java.util.List;
import java.util.Map;

import com.airport.ais.dao.IDao;
import com.airport.ais.dao.parameter.QueryCondition;
import com.airport.ais.service.IService;



/**
 * 通用的Service层接口的实现类
 * 处理数据对象的CRUD操作
 * 监听Jms的消息，如果数据对象有变更，则通知注册在自己身上的监听者数据有改变
 * 自己是消息产生者同时也是监听者
 * @author ZhangYu
 * @since JDK1.6
 * @version 0.9a 24/06/2014	
 */


public  class Service<K,E>  implements  IService<K,E>{
	
	protected IDao<K,E> dao;

	@Override
	public void setDao(IDao<K, E> dao) {
		// TODO Auto-generated method stub
		this.dao = dao;
	}



	@Override
	public E add(E obj) {
		obj = dao.save(obj);
		
	
		return (E) obj;
	}


	@Override
	public E update(E obj) {
		obj = dao.update(obj);
		
		
		return (E) obj;
	}

	@Override
	public void remove(E obj) {
		dao.delete(obj);
		
		
	}


	@Override
	public  List <E> getAll(Class<E> clazz) {
		return  dao.getAll(clazz);
	}

	@Override
	public E findByID(K id,Class<E> clazz) {
		// TODO Auto-generated method stub
		return  dao.findById(id,clazz);
	}

	@Override
	public  List <E> findByFieldAll(String field,Object value,Class<E> clazz){
		return  dao.findByFieldAll(field, value,clazz);
		
	}

	@Override
	public E findByFieldSingle(String field, Object value,Class<E> clazz) {
		// TODO Auto-generated method stub
		return  dao.findByFieldSingle(field, value,clazz);
		
	}
	@Override
	public E findByConditionSingle(QueryCondition conditions,Class<E> clazz) {
		// TODO Auto-generated method stub
		E result = dao.findByConditionSingle(conditions,clazz);
		if (result != null){
			return  result; 
		}else {
			return null;
		}
	}

	@Override
	public  List<E> findByConditionAll(QueryCondition conditions,Class<E> clazz) {
		// TODO Auto-generated method stub
		return dao.findByConditionAll(conditions,clazz);
	}


	@Override
	public int findCountByCondition(QueryCondition conditions,Class<E> clazz) {
		// TODO Auto-generated method stub
		return dao.findCountByCondition(conditions,clazz);
	}


	@Override
	public List<Map<String,Object>> findAggregationByCondition(QueryCondition conditions,Class<E> clazz) throws Exception {
		// TODO Auto-generated method stub
		return dao.findAggregationByCondition(conditions,clazz);
	}











	



}
