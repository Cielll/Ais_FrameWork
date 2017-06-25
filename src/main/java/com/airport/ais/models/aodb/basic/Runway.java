package com.airport.ais.models.aodb.basic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.airport.ais.enums.aodb.ResourceStatusCode;
import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      Runway.java
 * @Description  TODO 跑道的实体类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="Runway")
public class Runway extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String  RUNWAYID                      = "runwayID";
	public static final String  DESCRIPTION                   = "description";
	public static final String  STATUSCODE                    = "statusCode";
	public static final String  STATUSSTARTDATETIME           = "statusStartDateTime";
	public static final String  STATUSENDDATETIME             = "statusEndDateTime";
	public static final String  STATUSREASON                  = "statusReason";
	
	/**
	 * 跑道ID
	 */
	private String runwayID;
	/**
	 * 描述
	 */
	private Integer description;
	/**
	 * 状态
	 */
	@Column(length=1)
	@Enumerated(EnumType.STRING)
	private ResourceStatusCode statusCode;
	/**
	 * 状态开始时间
	 */
	private Date statusStartDateTime;
	/**
	 * 状态结束时间
	 */
	private Date statusEndDateTime;
	/**
	 *  状态理由
	 */
	private String statusReason;
	
	
	
	public String getRunwayID() {
		return runwayID;
	}
	
	public void setRunwayID(String runwayID) {
		this.runwayID = runwayID;
	}
	
	public Integer getDescription() {
		return description;
	}
	
	public void setDescription(Integer description) {
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
	
	
	
	

}
