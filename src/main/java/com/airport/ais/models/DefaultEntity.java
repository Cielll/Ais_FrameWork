package com.airport.ais.models;

import javax.persistence.MappedSuperclass;



/**
 * 
 * 
 * FileName      DefaultEntity.java
 * @Description  TODO  ʵ����ԭʼ����
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��11��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��11��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@MappedSuperclass
public abstract class DefaultEntity {

	
	
	/**
	 * @return the id
	 */
	public abstract Object getId();

	/**
	 * @param id the id to set
	 */
	public abstract void setId(Object id); 
	
	
	/**
	 * 
	 * @Description: TODO(������һ�仰�����������������)
	 * @return
	 */
	public Object getIdValue(){
		return this.getId();
	}

	
	/**
	 * ��д��equals����
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (DefaultEntity.class.isAssignableFrom(obj.getClass())&&!this.getIdValue().equals(0)){
			//���obj��Entity����һ�»����������࣬�Ƚ�����Id
			//���ID Ϊ0 ˵��������û�н������ݿ⣬�޷���ID���бȽ�
			return (this.getIdValue() .equals(((DefaultEntity)obj).getIdValue()));
		}
		//�����ø���ķ������бȽϣ�һ���ǱȽ��ڴ��ַ
		return super.equals(obj);
	}

	
	
	

}
