package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;


/**
 * 
 * 
 * FileName      Airline.java
 * @Description  TODO 航空公司的实体类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="Airline")
public class Airline extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final  String IATACODE         = "IATACode";
	public static final  String ICAOCODE         = "ICAOCode";
	public static final  String DESCRIPTION      = "description";
	public static final  String ENGLISHNAME      = "englishName";
	public static final  String CHINESENAME      = "chineseName";
	public static final  String SECTOR           = "sector";
	public static final  String RECEIVEADDRESS   = "receiveAddress";
	
	
	
	/**
	 * 两字代码
	 */
	@Column(length=2)
	private String IATACode;
	/**
	 * 三字代码
	 */
	@Column(length=3)
	private String ICAOCode;
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
	 * 航空公司领域
	 */
	@ManyToOne
	private Sector sector;
	/**
	 * 接收地址，用于空管系统
	 */
	private String receiveAddress;
	
	
	public String getIATACode() {
		return IATACode;
	}
	
	public void setIATACode(String iATACode) {
		IATACode = iATACode;
	}
	
	public String getICAOCode() {
		return ICAOCode;
	}
	
	public void setICAOCode(String iCAOCode) {
		ICAOCode = iCAOCode;
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
	
	public Sector getSector() {
		return sector;
	}
	
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	
	public String getReceiveAddress() {
		return receiveAddress;
	}
	
	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	

	

}
