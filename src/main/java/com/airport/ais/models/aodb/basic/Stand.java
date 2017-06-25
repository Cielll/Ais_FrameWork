package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * FileName      Stand.java
 * @Description  TODO 停机位的实体类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 * 
 */

@Entity
@Table(name="Stand")
public class Stand extends FlightResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String  STANDPOSITION    = "standPosition";
	public static final String  STANDISSECURE    = "standIsSecure";
	public static final String  GATE             = "gate";

	/**
	 * 停机位编号
	 */
	@Column(length=6)
	private String standPosition;
	/**
	 * 安全登机口
	 */
	private Boolean standIsSecure;
	/**
	 * 对应的登机口
	 */
	@ManyToOne
	private Gate gate;
	
	public String getStandPosition() {
		return standPosition;
	}
	
	public void setStandPosition(String standPosition) {
		this.standPosition = standPosition;
	}
	
	public Boolean getStandIsSecure() {
		return standIsSecure;
	}
	
	public void setStandIsSecure(Boolean standIsSecure) {
		this.standIsSecure = standIsSecure;
	}
	
	public Gate getGate() {
		return gate;
	}
	
	public void setGate(Gate gate) {
		this.gate = gate;
	}
	
	
	
}
