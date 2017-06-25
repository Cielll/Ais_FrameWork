package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * FileName      BaggageMakeupPosition.java
 * @Description  TODO 行李装载转盘的实体类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="BaggageMakeupPosition")
public class BaggageMakeupPosition extends FlightResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String  BAGGAGEMAKEUPPOSITIONID       = "baggageMakeupPositionID";
	public static final String  CAPACITY                      = "capacity";
	
	/**
	 * 装盘ID
	 */
	@Column(length=10)
	private String baggageMakeupPositionID;
	/**
	 * 装载能力
	 */
	protected Integer capacity;
	
	
	public String getBaggageMakeupPositionID() {
		return baggageMakeupPositionID;
	}
	
	public void setBaggageMakeupPositionID(String baggageMakeupPositionID) {
		this.baggageMakeupPositionID = baggageMakeupPositionID;
	}
	
	public Integer getCapacity() {
		return capacity;
	}
	
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	
	
	
}
