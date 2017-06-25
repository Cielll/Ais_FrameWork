package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 
 * FileName      CheckinDesk.java
 * @Description  TODO ֵ����̨��ʵ���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Entity
@Table(name="CheckinDesk")
public class CheckinDesk extends FlightResource {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String 	CHECKINDESKID = "checkinDeskID";
	public static final String 	CHECKINGROUP  = "checkinGroup";
	
	/**
	 * ֵ����̨ID
	 */
	@Column(length=4)
	private String checkinDeskID;
	/**
	 * ֵ����̨��
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
