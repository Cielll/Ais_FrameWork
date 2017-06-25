package com.airport.ais.models.aodb.basic;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      AirportAirRoute.java
 * @Description  TODO 空中航线实体表
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月21日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月21日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
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
	 * 出港机场
	 */
	@ManyToOne
	protected Airport departureAirport;
	/**
	 * 到达机场
	 */
	@ManyToOne
	protected Airport arrivalAirport;	
	
	/**
	 * 航路
	 */
	private String airRoute;
	

	/**
	 * 航线的距离
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
