package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;


/**
 * 
 * 
 * FileName      FlightServiceType.java
 * @Description  TODO 服务类型的实体类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月14日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月14日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
@Table(name="FlightServiceType")
public class FlightServiceType extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String NATURECODE         = "natureCode";	
	public static final String ENGLISHDESCRIPTION = "englishDescription";	
	public static final String CHINESEDESCRIPTION = "chineseDescription";
	public static final String FLIGHTNATURE       = "flightNature";
	/**
	 * IATA代码
	 */
	@Column(length=1)
	private String serviceTypeIATACode;
	/**
	 *  英文描述
	 */
	@Column(length=32)
	private String englishDescription;
	/**
	 * 中文描述
	 */
	@Column(length=32)
	private String chineseDescription;
	/**
	 * 航班性质代码
	 */
	@ManyToOne
	private FlightNature flightNature;
	
	public String getServiceTypeIATACode() {
		return serviceTypeIATACode;
	}
	
	public void setServiceTypeIATACode(String serviceTypeIATACode) {
		this.serviceTypeIATACode = serviceTypeIATACode;
	}
	
	public String getEnglishDescription() {
		return englishDescription;
	}
	
	public void setEnglishDescription(String englishDescription) {
		this.englishDescription = englishDescription;
	}
	
	public String getChineseDescription() {
		return chineseDescription;
	}
	
	public void setChineseDescription(String chineseDescription) {
		this.chineseDescription = chineseDescription;
	}
	
	public FlightNature getFlightNature() {
		return flightNature;
	}
	
	public void setFlightNature(FlightNature flightNature) {
		this.flightNature = flightNature;
	}
	
	

}
