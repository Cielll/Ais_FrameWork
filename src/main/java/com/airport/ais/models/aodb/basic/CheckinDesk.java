package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * FileName      CheckinDesk.java
 * @Description  TODO 值机柜台的实体类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
@Table(name="CheckinDesk")
public class CheckinDesk extends FlightResource {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final String 	CHECKINDESKID = "checkinDeskID";
	public static final String 	CHECKINGROUP  = "checkinGroup";
	
	/**
	 * 值机柜台ID
	 */
	@Column(length=4)
	private String checkinDeskID;
	/**
	 * 值机柜台组
	 */
	@Column(length=4)
	private String checkinGroup;
	
	public String getCheckinDeskID() {
		return checkinDeskID;
	}
	
	public void setCheckinDeskID(String checkinDeskID) {
		this.checkinDeskID = checkinDeskID;
	}
	
	public String getCheckinGroup() {
		return checkinGroup;
	}
	
	public void setCheckinGroup(String checkinGroup) {
		this.checkinGroup = checkinGroup;
	}
	
	

}
