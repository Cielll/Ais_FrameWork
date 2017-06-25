package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      FlightNature.java
 * @Description  TODO 航班性质的实体类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="FlightNature")
public class FlightNature extends IntIdEntity {

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
	/**
	 * 航班性质
	 */
	@Column(length=3)
	private String natureCode;
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
	
	public String getNatureCode() {
		return natureCode;
	}
	
	public void setNatureCode(String natureCode) {
		this.natureCode = natureCode;
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
	
	
	
	

}
