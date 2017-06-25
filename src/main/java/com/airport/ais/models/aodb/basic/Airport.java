package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      Airport.java
 * @Description  TODO 机场的实体类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="Airport")
public class Airport extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String IATACODE                   = "IATACode";
	public static final String ICAOCODE                   = "ICAOCode";
	public static final String ENGLISHNAME                = "ENGLISHNAME";
	public static final String CHINESENAME                = "chineseName";
	public static final String SECTOR                     = "sector";
	public static final String DESCRIPTION                = "description";
	public static final String MAXIMUMSUBTYPE             = "maximumSubtype";
	public static final String INTERVALDELAYTIME          = "intervalDelayTime";
	public static final String RECEIVEADDRESSDEPARTURE    = "receiveAddressDeparture";
	public static final String RECEIVEADDRESSARRIVAL      = "receiveAddressArrival";
	public static final String RECEIVEADDRESSPLAN         = "receiveAddressPlan";
	public static final String RECEIVEADDRESSEST          = "receiveAddressEST";
	
	
	/**
	 * 三字代码
	 */
	@Column(length = 3)
	private String IATACode;
	
	/**
	 * 四字代码
	 */
	@Column(length = 4)
	private String ICAOCode;
	
	/**
	 * 英文名
	 */
	@Column(length=32)
	private String englishName;
	/**
	 * 中文名
	 */
	@Column(length=32)
	private String chineseName;
	/**
	 * 领域代码（国内,国外)
	 */
	@ManyToOne
	private Sector sector;
	/**
	 * 描述
	 */
	@Column(length=64)
	private String description;
	/**
	 * 机场可起降最大机型
	 */
	@ManyToOne
	private AircraftSubtype maximumSubtype;
	
	
	/**
	 * 延误判断时间
	 */
	private int intervalDelayTime;
	
	/**
	 * 起飞报收电地址 FPL相同
	 */
	private String receiveAddressDeparture;
	
	/**
	 * 落地报收电地址 
	 */
	private String receiveAddressArrival;
	
	/**
	 *  计划报收电地址
	 */
	private String receiveAddressPlan;
	
	/**
	 * 飞越报的收电地址
	 */
	private String receiveAddressEST;


	/**
	 * @return the intervalDelayTime
	 */
	public int getIntervalDelayTime() {
		return intervalDelayTime;
	}

	/**
	 * @param intervalDelayTime the intervalDelayTime to set
	 */
	public void setIntervalDelayTime(int intervalDelayTime) {
		this.intervalDelayTime = intervalDelayTime;
	}

	/**
	 * @return the receiveAddressDeparture
	 */
	public String getReceiveAddressDeparture() {
		return receiveAddressDeparture;
	}

	/**
	 * @param receiveAddressDeparture the receiveAddressDeparture to set
	 */
	public void setReceiveAddressDeparture(String receiveAddressDeparture) {
		this.receiveAddressDeparture = receiveAddressDeparture;
	}

	/**
	 * @return the receiveAddressArrival
	 */
	public String getReceiveAddressArrival() {
		return receiveAddressArrival;
	}

	/**
	 * @param receiveAddressArrival the receiveAddressArrival to set
	 */
	public void setReceiveAddressArrival(String receiveAddressArrival) {
		this.receiveAddressArrival = receiveAddressArrival;
	}

	/**
	 * @return the receiveAddressPlan
	 */
	public String getReceiveAddressPlan() {
		return receiveAddressPlan;
	}

	/**
	 * @param receiveAddressPlan the receiveAddressPlan to set
	 */
	public void setReceiveAddressPlan(String receiveAddressPlan) {
		this.receiveAddressPlan = receiveAddressPlan;
	}

	/**
	 * @return the receiveAddressEST
	 */
	public String getReceiveAddressEST() {
		return receiveAddressEST;
	}

	/**
	 * @param receiveAddressEST the receiveAddressEST to set
	 */
	public void setReceiveAddressEST(String receiveAddressEST) {
		this.receiveAddressEST = receiveAddressEST;
	}

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

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public AircraftSubtype getMaximumSubtype() {
		return maximumSubtype;
	}

	public void setMaximumSubtype(AircraftSubtype maximumSubtype) {
		this.maximumSubtype = maximumSubtype;
	}


	
	
	

}
