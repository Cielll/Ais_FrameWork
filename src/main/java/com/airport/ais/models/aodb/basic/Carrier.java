package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      Carrier.java
 * @Description  TODO 承运人实体类  
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="Carrier")
public class Carrier extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final  String CARRIERCODE                = "carrierCode";
	public static final  String SETTLEMENTOWNERCODE        = "settlementOwnerCode";
	public static final  String SETTLEMENTPAYCODE          = "settlementPayCode";
	public static final  String ENGLISHNAME                = "englishName";
	public static final  String CHINESENAME                = "chineseName";
	public static final  String DESCRIPTION                = "description";
	public static final  String AIRLINE                    = "airline";
	public static final  String FLIGHTSERVICETYPE          = "flightServiceType";
	public static final  String CARGOCHECK                 = "cargoCheck";
	
	/**
	 * 承运人代码
	 */
	@Column(length=3)
	private String carrierCode;
	/**
	 *  结算代码，结算收入用
	 */
	@Column(length=3)
	private String settlementOwnerCode;  
	
	/**
	 *  付款代码，结算收入用
	 */
	@Column(length=5)
	private String settlementPayCode;
	/**
	 * 航空公司英文名字
	 */
	@Column(length=32)
	private String englishName;
	/**
	 * 航空公司中文名字
	 */
	@Column(length=32)
	private String chineseName;
	/**
	 * 描述
	 */
	@Column(length=128)
	private String description;
	/**
	 * 所属航空公司
	 */
	@ManyToOne
	private Airline airline;
	/**
	 * 服务类型
	 */
	@ManyToOne
	private FlightServiceType flightServiceType;
	/**
	 * 货物判断标志，结算收入用
	 */
	private boolean cargoCheck;
	
	public String getCarrierCode() {
		return carrierCode;
	}
	
	public void setCarrierCode(String carrierCode) {
		this.carrierCode = carrierCode;
	}
	
	public String getSettlementOwnerCode() {
		return settlementOwnerCode;
	}
	
	public void setSettlementOwnerCode(String settlementOwnerCode) {
		this.settlementOwnerCode = settlementOwnerCode;
	}
	
	public String getSettlementPayCode() {
		return settlementPayCode;
	}
	
	public void setSettlementPayCode(String settlementPayCode) {
		this.settlementPayCode = settlementPayCode;
	}
	
	public String getEnglishName() {
		return englishName;
	}
	
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	
	public String getChineseName() {
		return chineseName;
	}
	
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Airline getAirline() {
		return airline;
	}
	
	public void setAirline(Airline airline) {
		this.airline = airline;
	}
	
	public FlightServiceType getFlightServiceType() {
		return flightServiceType;
	}
	
	public void setFlightServiceType(FlightServiceType flightServiceType) {
		this.flightServiceType = flightServiceType;
	}
	
	public boolean isCargoCheck() {
		return cargoCheck;
	}
	
	public void setCargoCheck(boolean cargoCheck) {
		this.cargoCheck = cargoCheck;
	}

}
