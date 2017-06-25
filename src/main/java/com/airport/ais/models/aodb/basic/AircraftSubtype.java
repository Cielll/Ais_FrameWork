package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      AircraftSubtype.java
 * @Description  TODO �ɻ������ʵ���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Entity
@Table(name="AircraftSubtype")
public class AircraftSubtype extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String SUBTYPEDESCRIPTION               = "subtypeDescription";
	public static final String TYPEIATACODE                     = "typeIATACode";
	public static final String TYPEICAOCODE                     = "typeICAOCode";
	public static final String HEIGHT                           = "height";
	public static final String LENGTH                           = "length";
	public static final String WEIGHT                           = "weight";
	public static final String WIDTH                            = "width";
	public static final String PASSENGERCAPACITY                = "passengerCapacity";
	public static final String BUSINESSCLASSPASSENGERCAPACITY   = "businessClassPassengerCapacity";
	public static final String ECONOMYCLASSPASSENGERCAPACITY    = "economyClassPassengerCapacity";
	public static final String FIRSTCLASSPASSENGERCAPACITY      = "firstClassPassengerCapacity";
	public static final String NEARBRIDGEFLAG                   = "nearBridgeFlag";
	public static final String CLEARANCESECOND                  = "clearanceSecond";
	
	/**
	 * ��������
	 */
	@Column(length=64)
	private String subtypeDescription;
	/**
	 * ϵͳ����Ļ������
	 */
	@Column(length=4)
	private String typeIATACode;
	/**
	 * ��ͳ��ϵͳ�Ļ������
	 */
	@Column(length=4)
	private String typeICAOCode;
	/**
	 * �߶�
	 */
	private Integer height;
	/**
	 * ����
	 */
	private Integer length;
	/**
	 * ����
	 */
	private Integer weight;
	/**
	 * ���
	 */
	private Integer width;
	/**
	 * ��λ��
	 */
	private Integer passengerCapacity;
	/**
	 * ���������
	 */
	private Integer businessClassPassengerCapacity;
	/**
	 * ���ò�����
	 */
	private Integer economyClassPassengerCapacity;
	/**
	 * ͷ�Ȳ�����
	 */
	private Integer firstClassPassengerCapacity;
	/**
	 * ���ű�־
	 */
	private boolean nearBridgeFlag;
	/** 
	 *  ���������ĺ�����
	 */
	private long clearanceSecond;
	
	public String getSubtypeDescription() {
		return subtypeDescription;
	}
	
	public void setSubtypeDescription(String subtypeDescription) {
		this.subtypeDescription = subtypeDescription;
	}
	
	public String getTypeIATACode() {
		return typeIATACode;
	}
	
	public void setTypeIATACode(String typeIATACode) {
		this.typeIATACode = typeIATACode;
	}
	
	public String getTypeICAOCode() {
		return typeICAOCode;
	}
	
	public void setTypeICAOCode(String typeICAOCode) {
		this.typeICAOCode = typeICAOCode;
	}
	
	public Integer getHeight() {
		return height;
	}
	
	public void setHeight(Integer height) {
		this.height = height;
	}
	
	public Integer getLength() {
		return length;
	}
	
	public void setLength(Integer length) {
		this.length = length;
	}
	
	public Integer getWeight() {
		return weight;
	}
	
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	
	public Integer getWidth() {
		return width;
	}
	
	public void setWidth(Integer width) {
		this.width = width;
	}
	
	public Integer getPassengerCapacity() {
		return passengerCapacity;
	}
	
	public void setPassengerCapacity(Integer passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}
	
	public Integer getBusinessClassPassengerCapacity() {
		return businessClassPassengerCapacity;
	}
	
	public void setBusinessClassPassengerCapacity(Integer businessClassPassengerCapacity) {
		this.businessClassPassengerCapacity = businessClassPassengerCapacity;
	}
	
	public Integer getEconomyClassPassengerCapacity() {
		return economyClassPassengerCapacity;
	}
	
	public void setEconomyClassPassengerCapacity(Integer economyClassPassengerCapacity) {
		this.economyClassPassengerCapacity = economyClassPassengerCapacity;
	}
	
	public Integer getFirstClassPassengerCapacity() {
		return firstClassPassengerCapacity;
	}
	
	public void setFirstClassPassengerCapacity(Integer firstClassPassengerCapacity) {
		this.firstClassPassengerCapacity = firstClassPassengerCapacity;
	}
	
	public boolean isNearBridgeFlag() {
		return nearBridgeFlag;
	}
	
	public void setNearBridgeFlag(boolean nearBridgeFlag) {
		this.nearBridgeFlag = nearBridgeFlag;
	}
	
	public long getClearanceSecond() {
		return clearanceSecond;
	}
	
	public void setClearanceSecond(long clearanceSecond) {
		this.clearanceSecond = clearanceSecond;
	}
	
	
	
	
	
	
	

}
