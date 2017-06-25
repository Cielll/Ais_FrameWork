package com.airport.ais.service;

import java.util.List;
import java.util.Map;
import com.airport.ais.dao.IDao;
import com.airport.ais.dao.parameter.QueryCondition;



/**
 * ͨ�õ�Service��ӿڣ��ṩ������ʵ�����������
 * @author ZhangYu
 * @since JDK1.6
 * @version 0.9a 24/06/2014	
 */


public interface IService<K,E>  {
	

	/**
	 * ���ò������ݵ�Dao����
	 * @param dao
	 */
	public void setDao(IDao<K, E> dao);	

	
	/**
	 * ɾ��һ�����ݶ���
	 * @param obj
	 */
	public void remove(E obj);	
	
	/**
	 * ����һ�����ݶ���
	 * @param obj
	 */
	public E add(E obj);
	
	/**
	 * ����һ�����ݶ���
	 * @param object
	 */
	public E update(E object);
	
	/**
	 * �������е����ݶ���
	 * @return
	 */
	public  List <E> getAll(Class<E> clazz);

	/**
	 * ����ָ��Id����������ݶ���
	 * @param id �ؼ���
	 * @return ָ��Id����������ݶ���
	 */
	public E findByID(K id,Class<E> clazz);
	
	/**
	 * ����ָ���ֶ�ֵ�õ������ݶ���
	 * @param field
	 * @param value
	 * @return ָ���ֶ�ֵ�����ݶ���
	 */
	public  List <E>  findByFieldAll(String field,Object value,Class<E> clazz);

	/**
	 * ����ָ���ֶ�ֵ�����ݶ���ļ���
	 * @param field
	 * @param value
	 * @return ָ���ֶ�ֵ�����ݶ���ļ���
	 */
	public E  findByFieldSingle(String field,Object value,Class<E> clazz);
	
	/**
	 * ���ݸ��������������������ʵ����󼯺�
	 * @param fields �ֶ�����
	 * @param opers ��ϵ�����
	 * @param links ���ӷ� and or
	 * @param values ��������
	 * @return ����������һ��ʵ�����
	 */
	public E  findByConditionSingle(QueryCondition conditions,Class<E> clazz);
	
	/**
	 ���ݸ��������������������ʵ����󼯺�
	 * @param fields �ֶ�����
	 * @param opers ��ϵ�����
	 * @param links ���ӷ� and or
	 * @param values ��������
	 * @return ����������ʵ����󼯺�
	 */
	public  List <E>  findByConditionAll(QueryCondition conditions,Class<E> clazz);
	
	/**
	 * ���ݸ�����������ȡ��������������
	 * @Description: TODO(������һ�仰�����������������)
	 * @param conditions ���������
	 * @return ��ȡ�����������������
	 */
	public int findCountByCondition(QueryCondition conditions,Class<E> clazz);
	
	/**
	 * 
	 * @Description: TODO ���ݸ������������оۺϴ���
	 * @param conditions ���������
	 * @return �ۺϵĽ��
	 * @throws Exception 
	 */
	public List<Map<String,Object>> findAggregationByCondition(QueryCondition conditions,Class<E> clazz) throws Exception;
	
	
	
}
