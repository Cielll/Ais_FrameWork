package com.airport.ais.models;

import javax.persistence.MappedSuperclass;



/**
 * 
 * 
 * FileName      DefaultEntity.java
 * @Description  TODO  实体类原始父类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月11日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月11日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
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
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 */
	public Object getIdValue(){
		return this.getId();
	}

	
	/**
	 * 重写的equals方法
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (DefaultEntity.class.isAssignableFrom(obj.getClass())&&!this.getIdValue().equals(0)){
			//如果obj和Entity类型一致或者是其子类，比较两个Id
			//如果ID 为0 说明该数据没有进入数据库，无法用ID进行比较
			return (this.getIdValue() .equals(((DefaultEntity)obj).getIdValue()));
		}
		//否则用父类的方法进行比较，一般是比较内存地址
		return super.equals(obj);
	}

	
	
	

}
