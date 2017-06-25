package com.airport.ais.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import com.airport.ais.dao.parameter.QueryCondition;

/**
 * 
 * FileName      IDao.java
 * @Description  TODO ͨ��DAO��ӿ�
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��22��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��22��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Local
public interface IDao <K,E>{
	
	/**
	 * �����ݿⱣ��һ������
	 * @param E ʵ�����
	 * @return ���ر����IDֵ
	 */
	public E save(E obj);
	
	
	/**
	 * �����ݿ���ɾ��һ�������Ķ���
	 * @param E ʵ�����
	 */
	public void delete(E entity);
	
	/**
	 * ����һ������ķ���
	 * @param E ʵ����
	 */
	public E update(E entity);
	
	
	/**
	 * �����ݿ��з��ظ���һ��ID��ʵ�����
	 * @param id	������ID
	 * @return	��ѯ����ʵ�����
	 */
	public E findById(K id,Class<E> clazz);
	
	/**
	 * �����ݿⷵ�ظ�һ���ض�ʵ��������������
	 * @return	���еĸ���ʵ��������͵���������
	 */
	public List<E> getAll(Class<E> clazz);
	
	
	
	
	
	
	/**
	 * ���ݸ������ֶ��������������һ��ʵ�����
	 * @param field �������ֶ���
	 * @param value	ָ��������
	 * @return ����������һ��ʵ�����
	 */
	public E findByFieldSingle(String field,Object value,Class<E> clazz);
	
	
	
	/**
	 * ���ݸ������ֶ��������������ʵ����󼯺�
	 * @param field �������ֶ���
	 * @param value	ָ��������
	 * @return ����������ʵ����󼯺�
	 */
	public List<E> findByFieldAll(String field,Object value,Class<E> clazz);

	
	
	/**
	 * ���ݸ��������������������ʵ����󼯺�
	 * @param  conditions ���������
	 * @return ����������һ��ʵ�����
	 */
	public E findByConditionSingle(QueryCondition condition,Class<E> clazz);
	
	/**
	 ���ݸ��������������������ʵ����󼯺�
	 * @param  conditions ���������
	 * @return ����������ʵ����󼯺�
	 */
	public List<E> findByConditionAll(QueryCondition condition,Class<E> clazz);
	
	/**
	 * 
	 * @Description: TODO ���ݸ�����������ȡ��������������
	 * @param conditions ���������
	 * @return ��ȡ�����������������
	 */
	public int findCountByCondition(QueryCondition condition,Class<E> clazz);



	/**
	 * 
	 * @Description: TODO ���ݸ������������оۺϴ���
	 * @param conditions ���������
	 * @return �ۺϵĽ��
	 */
	public List<Map<String,Object>> findAggregationByCondition(QueryCondition condition,Class<E> clazz) throws Exception;
}
