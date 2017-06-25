package com.airport.ais.models.aodb.basic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * 
 * FileName Gate.java
 * 
 * @Description TODO 登机口的实体类
 * @author ZhangYu Company: LZAirport
 * @version V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory Date Author Version Description
 *                      <p>
 *                      ---------------------------------------------
 *                      <p>
 *                      2017年6月13日 ZhangYu 1.0 1.0
 *                      <p>
 *                      Why & What is modified: <修改原因描述>
 */

@Entity
@Table(name="Gate")
public class Gate extends FlightResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String GATENUMBER ="gateNumber";
	public static final String BOARDINGBRIDGES = "boardingBridges";
	/**
	 * 登机口编号
	 */
	@Column(length = 4)
	private String gateNumber;
	/**
	 * 对应的登机桥
	 */
	@OneToMany
	@JoinColumn(name="gate_id")
	private List<BoardingBridge> boardingBridges;
	
	public String getGateNumber() {
		return gateNumber;
	}
	
	public void setGateNumber(String gateNumber) {
		this.gateNumber = gateNumber;
	}
	
	public List<BoardingBridge> getBoardingBridges() {
		if (boardingBridges == null){
			boardingBridges = new ArrayList<BoardingBridge>();
		}
		return this.boardingBridges;
	}
	
	
	
	
	

}
