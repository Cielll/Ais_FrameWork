package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.airport.ais.enums.aodb.SectorCode;
import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      FlightSector.java
 * @Description  TODO 航班领域的实体类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="Sector")
public class Sector extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String SECTORCODE         = "sectorCode";	
	public static final String ENGLISHDESCRIPTION = "englishDescription";	
	public static final String CHINESEDESCRIPTION = "chineseDescription";	
	public static final String FLIGHTSERVICETYPE  = "flightServiceType";		
	/**
	 * 
	 */
	@Column(length=1)
	@Enumerated(EnumType.STRING)
	private SectorCode sectorCode;
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
	
	public SectorCode getSectorCode() {
		return sectorCode;
	}
	
	public void setSectorCode(SectorCode sectorCode) {
		this.sectorCode = sectorCode;
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
