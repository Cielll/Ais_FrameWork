package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      FlightClassification.java
 * @Description  TODO 航班分类的实体类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="FlightClassification")
public class FlightClassification extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String CLASSIFICATIONCODE = "classificationCode";	
	public static final String ENGLISHDESCRIPTION = "englishDescription";	
	public static final String CHINESEDESCRIPTION = "chineseDescription";	
	public static final String FLIGHTSERVICETYPE  = "flightServiceType";	
	
	/**
	 * 分类代码
	 */
	@Column(length=3)
	private String classificationCode;
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
	 * 航班服务类型
	 */
	@ManyToOne
	private FlightServiceType flightServiceType;
	
	public String getClassificationCode() {
		return classificationCode;
	}
	
	public void setClassificationCode(String classificationCode) {
		this.classificationCode = classificationCode;
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
	
	public FlightServiceType getFlightServiceType() {
		return flightServiceType;
	}
	
	public void setFlightServiceType(FlightServiceType flightServiceType) {
		this.flightServiceType = flightServiceType;
	}
	
	
	

}
