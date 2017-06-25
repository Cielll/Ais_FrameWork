package com.airport.ais.models.aodb.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airport.ais.enums.aodb.ResourceStatusCode;
import com.airport.ais.models.IntIdEntity;

/**
 * 
 * FileName      BoardingBridge.java
 * @Description  TODO 廊桥的实体类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
@Table(name="BoardingBridge")
public class BoardingBridge extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String BRIDGEID                             = "bridgeID";
	public static final String DESCRIPTION                          = "description";
	public static final String TERMINAL                             = "terminal";
	public static final String STATUSGENERAL                        = "statusGeneral";
	public static final String STATUSGENERALSTARTDATETIME           = "statusGeneralStartDateTime";
	public static final String STATUSGENERALENDDATETIME             = "statusGeneralEndDateTime";
	public static final String STATUSPCA                            = "statusPCA;";
	public static final String STATUSPCASTARTDATETIME               = "statusPCAStartDateTime";
	public static final String STATUSPCAENDDATETIME                 = "statusPCAEndDateTime";
	public static final String STATUSPOWER                          = "statusPower";
	public static final String STATUSPOWERSTARTDATETIME             = "statusPowerStartDateTime";
	public static final String STATUSPOWERENDDATETIME               = "statusPowerEndDateTime";
	
	/**
	 * 廊桥ID
	 */
	@Column(length=10)
	private String bridgeID;
	/**
	 * 廊桥描述
	 */
	@Column(length=64)
	private String description;
	/**
	 * 所属航站楼
	 */
	@ManyToOne
	private Terminal terminal;
	/**
	 * 廊桥状态
	 */
	@Column(length=1)
	@Enumerated(EnumType.STRING)
	private ResourceStatusCode statusGeneral;
	/**
	 * 廊桥状态开始时间
	 */
	private Date statusGeneralStartDateTime;
	/**
	 * 廊桥状态结束时间
	 */
	private Date statusGeneralEndDateTime;
	/**
	 * 廊桥PCA状态
	 */
	@Column(length=1)
	@Enumerated(EnumType.STRING)
	private ResourceStatusCode statusPCA;
	/**
	 * 廊桥PCA状态开始时间
	 */
	private Date statusPCAStartDateTime;
	/**
	 * 廊桥PCA状态结束时间
	 */
	private Date statusPCAEndDateTime;
	/**
	 * 廊桥Power状态
	 */
	@Column(length=1)
	@Enumerated(EnumType.STRING)
	private ResourceStatusCode statusPower;
	/**
	 * 廊桥Power状态开始时间
	 */
	private Date statusPowerStartDateTime;
	/**
	 * 廊桥Power状态结束时间
	 */
	private Date statusPowerEndDateTime;
	
	public String getBridgeID() {
		return bridgeID;
	}
	
	public void setBridgeID(String bridgeID) {
		this.bridgeID = bridgeID;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Terminal getTerminal() {
		return terminal;
	}
	
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	
	public ResourceStatusCode getStatusGeneral() {
		return statusGeneral;
	}
	
	public void setStatusGeneral(ResourceStatusCode statusGeneral) {
		this.statusGeneral = statusGeneral;
	}
	
	public Date getStatusGeneralStartDateTime() {
		return statusGeneralStartDateTime;
	}
	
	public void setStatusGeneralStartDateTime(Date statusGeneralStartDateTime) {
		this.statusGeneralStartDateTime = statusGeneralStartDateTime;
	}
	
	public Date getStatusGeneralEndDateTime() {
		return statusGeneralEndDateTime;
	}
	
	public void setStatusGeneralEndDateTime(Date statusGeneralEndDateTime) {
		this.statusGeneralEndDateTime = statusGeneralEndDateTime;
	}
	
	public ResourceStatusCode getStatusPCA() {
		return statusPCA;
	}
	
	public void setStatusPCA(ResourceStatusCode statusPCA) {
		this.statusPCA = statusPCA;
	}
	
	public Date getStatusPCAStartDateTime() {
		return statusPCAStartDateTime;
	}
	
	public void setStatusPCAStartDateTime(Date statusPCAStartDateTime) {
		this.statusPCAStartDateTime = statusPCAStartDateTime;
	}
	
	public Date getStatusPCAEndDateTime() {
		return statusPCAEndDateTime;
	}
	
	public void setStatusPCAEndDateTime(Date statusPCAEndDateTime) {
		this.statusPCAEndDateTime = statusPCAEndDateTime;
	}
	
	public ResourceStatusCode getStatusPower() {
		return statusPower;
	}
	
	public void setStatusPower(ResourceStatusCode statusPower) {
		this.statusPower = statusPower;
	}
	
	public Date getStatusPowerStartDateTime() {
		return statusPowerStartDateTime;
	}
	
	public void setStatusPowerStartDateTime(Date statusPowerStartDateTime) {
		this.statusPowerStartDateTime = statusPowerStartDateTime;
	}
	
	public Date getStatusPowerEndDateTime() {
		return statusPowerEndDateTime;
	}
	
	public void setStatusPowerEndDateTime(Date statusPowerEndDateTime) {
		this.statusPowerEndDateTime = statusPowerEndDateTime;
	}
	
	
	

}
