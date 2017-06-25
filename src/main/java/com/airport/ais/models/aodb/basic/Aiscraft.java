package com.airport.ais.models.aodb.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      Aiscraft.java
 * @Description  TODO 飞机注册信息的实体类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
@Table(name="Aiscraft")
public class Aiscraft extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String  REGISTRATION               = "registration";
	public static final String  REGISTRATIONDESCRIPTION    = "registrationDescription";
	public static final String  CARRIER                    = "carrier";
	public static final String  AIRCRAFTSUBTYPE            = "aircraftSubtype";
	public static final String  PASSENGERCAPACITY          = "passengerCapacity";
	public static final String  AIRCRAFTNOSENUMBER         = "aircraftNoseNumber";
	public static final String  SETTLEMENTWEIGHT           = "settlementWeight";	
	public static final String  MAXIMUMPAYLOAD             = "maximumPayload";
	public static final String  SETTLEMENTLOAD             = "settlementPayload";
	public static final String  EQUIPMENT                  = "equipment";
	public static final String  CALLSIGN                   = "callsign";
	public static final String  STARUSETTIME               = "startUseTime";
	public static final String  STOPUSETIME                = "stopUseTime";
	
	/**
	 * 飞机注册号
	 */
	@Column(length=8)
	private String  registration;
	/**
	 * 飞机注册号的描述 
	 */
	@Column(length=64)
	private String  registrationDescription;
	/**
	 * 归属承运人
	 */
	@ManyToOne
	private Carrier carrier;
	/**
	 * 机型
	 */
	@ManyToOne
	private AircraftSubtype aircraftSubtype;
	/**
	 * 飞机座位数
	 */
	private Integer passengerCapacity;
	/**
	 * 飞机噪声数值
	 */
	private String  aircraftNoseNumber;
	/**
	 * 飞机的重量,用于结算系统
	 */
	private Integer settlementWeight;
	/**
	 * 最大业载，用于统计系统
	 */
	private Integer maximumPayload;
	/**
	 * 结算业载，用于结算
	 */
	private Integer settlementPayload;
	/**
	 * 机载设备，用于空管系统
	 */
	private String equipment;
	/**
	 * 呼号，用于空管系统
	 */
	private String callsign;
	/**
	 *  开始使用时间，用于更新清算飞机数据用
	 */
	private Date startUseTime;
	/**
	 *  停止使用时间，用于更新清算飞机数据用
	 */
	private Date stopUseTime;
	
	

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getRegistrationDescription() {
		return registrationDescription;
	}

	public void setRegistrationDescription(String registrationDescription) {
		this.registrationDescription = registrationDescription;
	}

	public Carrier getCarrier() {
		return carrier;
	}

	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}

	public AircraftSubtype getAircraftSubtype() {
		return aircraftSubtype;
	}

	public void setAircraftSubtype(AircraftSubtype aircraftSubtype) {
		this.aircraftSubtype = aircraftSubtype;
	}

	public Integer getPassengerCapacity() {
		return passengerCapacity;
	}

	public void setPassengerCapacity(Integer passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public String getAircraftNoseNumber() {
		return aircraftNoseNumber;
	}

	public void setAircraftNoseNumber(String aircraftNoseNumber) {
		this.aircraftNoseNumber = aircraftNoseNumber;
	}

	

	public Integer getSettlementWeight() {
		return settlementWeight;
	}

	public void setSettlementWeight(Integer settlementWeight) {
		this.settlementWeight = settlementWeight;
	}

	public Integer getMaximumPayload() {
		return maximumPayload;
	}

	public void setMaximumPayload(Integer maximumPayload) {
		this.maximumPayload = maximumPayload;
	}

	public Integer getSettlementPayload() {
		return settlementPayload;
	}

	public void setSettlementPayload(Integer settlementPayload) {
		this.settlementPayload = settlementPayload;
	}

	public String getEquipment() {
		return equipment;
	}

	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}

	public String getCallsign() {
		return callsign;
	}

	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	public Date getStartUseTime() {
		return startUseTime;
	}

	public void setStartUseTime(Date startUseTime) {
		this.startUseTime = startUseTime;
	}

	public Date getStopUseTime() {
		return stopUseTime;
	}

	public void setStopUseTime(Date stopUseTime) {
		this.stopUseTime = stopUseTime;
	}
	
	

}
