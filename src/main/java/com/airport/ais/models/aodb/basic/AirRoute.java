package com.airport.ais.models.aodb.basic;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      AirportAirRoute.java
 * @Description  TODO ���к���ʵ���
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��21��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��21��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Entity
@Table(name="AirRoute")
public class AirRoute extends IntIdEntity {

	private static final long serialVersionUID = 1L;
	public static final String  DEPARTUREAIRPORT          = "departureAirport";
	public static final String  ARRIVALAIRPORT            = "arrivalAirport";
	public static final String DEPARTUREAIRROUTE          = "departureAirRoute";
	public static final String ARRIVALAIRROUTE            = "arrivalAirRoute";
	public static final String DEPARTUREAIRROUTEDISTANCE  = "departureAirRouteDistance";
	public static final String ARRIVALAIRROUTEDISTANCE    =  "arrivalAirRouteDistance";

	
	/**
	 * ���ۻ���
	 */
	@ManyToOne
	protected Airport departureAirport;
	/**
	 * �������
	 */
	@ManyToOne
	protected Airport arrivalAirport;	
	
	/**
	 * ��·
	 */
	private String airRoute;
	

	/**
	 * ���ߵľ���
	 */
	private Integer airRouteDistance;


	/**
	 * @return the departureAirport
	 */
	public Airport getDepartureAirport() {
		return departureAirport;
	}


	/**
	 * @param departureAirport the departureAirport to set
	 */
	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}


	/**
	 * @return the arrivalAirport
	 */
	public Airport getArrivalAirport() {
		return arrivalAirport;
	}


	/**
	 * @param arrivalAirport the arrivalAirport to set
	 */
	public void setArrivalAirport(Airport arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}


	/**
	 * @return the airRoute
	 */
	public String getAirRoute() {
		return airRoute;
	}


	/**
	 * @param airRoute the airRoute to set
	 */
	public void setAirRoute(String airRoute) {
		this.airRoute = airRoute;
	}


	/**
	 * @return the airRouteDistance
	 */
	public Integer getAirRouteDistance() {
		return airRouteDistance;
	}


	/**
	 * @param airRouteDistance the airRouteDistance to set
	 */
	public void setAirRouteDistance(Integer airRouteDistance) {
		this.airRouteDistance = airRouteDistance;
	}
	
	
	

	

}
