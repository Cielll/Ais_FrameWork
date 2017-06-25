package com.airport.ais.models.aodb.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.airport.ais.enums.aodb.ResourceStatusCode;
import com.airport.ais.models.IntIdEntity;


/**
 * FileName      FlightResource.java
 * @Description  TODO 航班资源的基类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月14日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月14日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class FlightResource extends IntIdEntity {
	
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String  DESCRIPTION                   = "description";
	public static final String  STATUSCODE                    = "statusCode";
	public static final String  STATUSSTARTDATETIME           = "statusStartDateTime";
	public static final String  STATUSENDDATETIME             = "statusEndDateTime";
	public static final String  STATUSREASON                  = "statusReason";
	public static final String  TERMINAL                      = "terminal"; 
	/**
	 * 描述
	 */
	@Column(length=128)
	protected String description;
	/**
	 * 状态
	 */
	@Column(length=1)
	@Enumerated(EnumType.STRING)
	protected ResourceStatusCode statusCode;
	/**
	 * 状态开始时间
	 */
	protected Date statusStartDateTime;
	/**
	 * 状态结束时间
	 */
	protected Date statusEndDateTime;
	/**
	 *  状态理由
	 */
	protected String statusReason;
	/**
	 * 航站楼
	 */
	@ManyToOne
	protected Terminal terminal;


	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ResourceStatusCode getStatusCode() {
		return statusCode;
	}
	
	public void setStatusCode(ResourceStatusCode statusCode) {
		this.statusCode = statusCode;
	}
	
	public Date getStatusStartDateTime() {
		return statusStartDateTime;
	}
	
	public void setStatusStartDateTime(Date statusStartDateTime) {
		this.statusStartDateTime = statusStartDateTime;
	}
	
	public Date getStatusEndDateTime() {
		return statusEndDateTime;
	}
	
	public void setStatusEndDateTime(Date statusEndDateTime) {
		this.statusEndDateTime = statusEndDateTime;
	}
	
	public String getStatusReason() {
		return statusReason;
	}
	
	public void setStatusReason(String statusReason) {
		this.statusReason = statusReason;
	}

	public Terminal getTerminal() {
		return terminal;
	}

	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	

}