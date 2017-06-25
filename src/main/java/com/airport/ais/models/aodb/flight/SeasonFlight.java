package com.airport.ais.models.aodb.flight;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.airport.ais.enums.aodb.OperationalDay;
import com.airport.ais.enums.aodb.Season;

/**
 * 
 * FileName      SeasonFlight.java
 * @Description  TODO 航季航班实体类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月19日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月19日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */


@Entity
@Table(name="Season_Flight")
public class SeasonFlight extends BasicFlight {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 航班标识
	 */
	@Embedded
	protected SeasonFlight.FlightIdentification flightIdentification;
	/**
	 * 航班数据 
	 */
	@Embedded
	protected SeasonFlight.AircraftData aircraftData;
	/**
	 * 飞机数据
	 */
	@Embedded
	protected SeasonFlight.AirportData airportData;
	/**
	 * 航班数据
	 */
	@Embedded
	protected SeasonFlight.FlightData flightData;
	/**
	 * 航线数据
	 */
	@Embedded
	protected SeasonFlight.RouteData routeData; 
	/**
	 * 航班操作时间
	 */
	@Embedded
	protected SeasonFlight.OperationalTimes operationalTimes; 
	
	
	/**
	 * TypeName      SeasonFlight.FlightIdentification 
	 * @Description  继承BasicFlight.FlightIdentification
	 */
	public static class FlightIdentification extends BasicFlight.FlightIdentification {
		
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String		DAYSOFOPERATION     = "daysOfOperation";
		public static final  String		SEASON              = "season";
		public static final  String		FLIGHTFIRSTDATETIME = "flightFirstDateTime";
		public static final  String		FLIGHTLASTDATETIME  = "flightLastDateTime";
		
		/**
		 *  航班执行频率集合
		 */

		@Enumerated(EnumType.STRING)
		@ElementCollection(fetch=FetchType.EAGER)
		@Column(length=12)
		protected Set<OperationalDay> daysOfOperation;
		/**
		 * 航季
		 */
		@Column(length=15)
		@Enumerated(EnumType.STRING)
		protected Season season;
		/**
		 * 航季开始时间
		 */
		protected Date flightFirstDateTime;
		/**
		 * 航季结束时间
		 */
		protected Date flightLastDateTime;
		
		public Set<OperationalDay> getDaysOfOperation() {
			if (daysOfOperation == null){
				daysOfOperation = new HashSet<OperationalDay>();
			}
			return this.daysOfOperation;
		}
		
		
		public Date getFlightFirstDateTime() {
			return flightFirstDateTime;
		}
		
		public void setFlightFirstDateTime(Date flightFirstDateTime) {
			this.flightFirstDateTime = flightFirstDateTime;
		}
		
		public Date getFlightLastDateTime() {
			return flightLastDateTime;
		}
		
		public void setFlightLastDateTime(Date flightLastDateTime) {
			this.flightLastDateTime = flightLastDateTime;
		}
		
	}

	/**
	 * TypeName      SeasonFlight.AircraftData 
	 * @Description  继承BasicFlight.AircraftData
	 */
	public static class AircraftData extends BasicFlight.AircraftData {
		
	}
	/**
	 * TypeName      SeasonFlight.AirportData 
	 * @Description  继承BasicFlight.AirportData
	 */
	public static class AirportData extends BasicFlight.AirportData{
		/**
		 * 航季行李装载转盘集合
		 */
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.AirportData.BaggageMakeupPosition> baggageMakeupPosition;
		/**
		 * 航季行李认领转盘集合
		 */
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.AirportData.BaggageReclaimCarousel> baggageReclaimCarousels;
		/**
		 * 航季值机柜台集合
		 */
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.AirportData.Checkin> checkins;
		/**
		 * 航季登机口集合
		 */
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.AirportData.Gate> gates;
		
		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.BaggageMakeupPosition> getBaggageMakeupPositions() {
			if (baggageMakeupPosition == null){
				baggageMakeupPosition = new HashSet<SeasonFlight.AirportData.BaggageMakeupPosition>();
			}
			return baggageMakeupPosition;
		}

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.BaggageReclaimCarousel> getBaggageReclaimCarousels() {
			if (baggageReclaimCarousels == null){
				baggageReclaimCarousels = new HashSet<SeasonFlight.AirportData.BaggageReclaimCarousel>();
			}
			return baggageReclaimCarousels;
		}

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.Checkin> getCheckins() {
			if (checkins == null){
				checkins = new HashSet<SeasonFlight.AirportData.Checkin>();
			}
			return checkins;
		}

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.Gate> getGates() {
			if (gates == null){
				gates = new HashSet<SeasonFlight.AirportData.Gate>();
			}
			return gates;
		} 	    
		
		

		/**
		 * TypeName      SeasonFlight.AirportData.BaggageMakeupPosition 
		 * @Description  继承BasicFlight.AirportData.BaggageMakeupPosition，航季行李装载转盘的实体表
		 */
		@Entity
		@Table(name="Season_BaggageMakeupPosition")
		 public  class BaggageMakeupPosition extends BasicFlight.AirportData.BaggageMakeupPosition{

			private static final long serialVersionUID = 1L;
		 }

		/**
		 * TypeName      SeasonFlight.AirportData.BaggageReclaimCarousel 
		 * @Description  继承BasicFlight.AirportData.BaggageReclaimCarousel，航季行李转盘认领的实体表
		 */
		 @Entity
		 @Table(name="Season_BaggageReclaimCarousel")
		 public  class BaggageReclaimCarousel extends BasicFlight.AirportData.BaggageReclaimCarousel{

			private static final long serialVersionUID = 1L;
		 }
	 
		 /**
		 * TypeName      SeasonFlight.AirportData.Checkin 
		 * @Description  继承BasicFlight.AirportData.Checkin 航季值机柜台的实体表
		 */		 
		 @Entity
		 @Table(name="Season_Checkin")
		 public class Checkin extends BasicFlight.AirportData.Checkin{

			private static final long serialVersionUID = 1L;
		 }

		/**
		 * TypeName      SeasonFlight.AirportData.Gate 
		 * @Description  继承BasicFlight.AirportData.Gate  航季登机口的实体表
		 */
		 @Entity
		 @Table(name="Season_Gate")
		 public class Gate extends BasicFlight.AirportData.Gate{

			private static final long serialVersionUID = 1L;
			 
		 }

		


		 
	}
	/**
	 * TypeName      SeasonFlight.FlightData 
	 * @Description  继承BasicFlight.FlightData
	 */
	public static class FlightData extends BasicFlight.FlightData{
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.FlightData.ShareFlight> shareFlights;
		
		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.FlightData.ShareFlight> getShareFlights() {
			if (shareFlights == null){
				shareFlights = new HashSet<SeasonFlight.FlightData.ShareFlight>();
			}
			return this.shareFlights;
		}

		@Entity
		@Table(name="Season_ShareFlight")
		public class ShareFlight extends BasicFlight.FlightData.ShareFlight{
			
			private static final long serialVersionUID = 1L;
			
		}

	}
	
	/**
	 * TypeName      SeasonFlight.RouteDData 
	 * @Description  继承BasicFlight.RouteData
	 */
	public static class RouteData extends BasicFlight.RouteData{
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.RouteData.StopFlight> stopFlights;
		
		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.RouteData.StopFlight> getStopFlights() {
			if (stopFlights == null){
				stopFlights = new HashSet<SeasonFlight.RouteData.StopFlight>();
			}
			return stopFlights;
		}
		
		@Entity
		@Table(name="Season_StopFlight")
		public class StopFlight extends BasicFlight.RouteData.StopFlight{
			private static final long serialVersionUID = 1L;
			
		}



		
	}
	
	/**
	 * TypeName      SeasonFlight.OperationalTimes
	 * @Description  继承BasicFlight.OperationalTimes
	 */
	public static class OperationalTimes extends BasicFlight.OperationalTimes{
		
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String SCHEDULEDOFFBLOCKSDATETIME      = "scheduledOffBlocksDateTime";
		public static final  String SCHEDULEDONBLOCKSDATETIME       = "scheduledOnBlocksDateTime";
		public static final  String SCHEDULEDWHEELSUPDATETIME       = "scheduledwheelsUpDateTime";
		public static final  String SCHEDULEDWHEELSDOWNDATETIME     = "scheduledwheelsDownDateTime";
		public static final  String SCHEDULEDAIRBORNEDATETIME       = "scheduledAirborneDateTime";
		public static final  String SCHEDULEDLANDDATETIME           = "scheduledLandDateTime";
		/**
		 * 计划离港时间
		 */
		@Column(length=6)
		protected String scheduledOffBlocksDateTime;
		/**
		 * 计划到港时间
		 */
		@Column(length=6)
		protected String scheduledOnBlocksDateTime;
		/**
		 * 计划上轮档时间
		 */
		@Column(length=6)
		protected String scheduledwheelsUpDateTime;
		/**
		 *  计划下轮档时间
		 */
		@Column(length=6)
		protected String scheduledwheelsDownDateTime;
		/**
		 *  计划起飞的时间
		 */
		@Column(length=6)
		protected String scheduledAirborneDateTime;
		/**
		 *  计划落地的时间
		 */
		@Column(length=6)
		protected String scheduledLandDateTime;
		
		public String getScheduledOffBlocksDateTime() {
			return scheduledOffBlocksDateTime;
		}
		
		public void setScheduledOffBlocksDateTime(String scheduledOffBlocksDateTime) {
			this.scheduledOffBlocksDateTime = scheduledOffBlocksDateTime;
		}
		
		public String getScheduledOnBlocksDateTime() {
			return scheduledOnBlocksDateTime;
		}
		
		public void setScheduledOnBlocksDateTime(String scheduledOnBlocksDateTime) {
			this.scheduledOnBlocksDateTime = scheduledOnBlocksDateTime;
		}
		
		public String getScheduledwheelsUpDateTime() {
			return scheduledwheelsUpDateTime;
		}
		
		public void setScheduledwheelsUpDateTime(String scheduledwheelsUpDateTime) {
			this.scheduledwheelsUpDateTime = scheduledwheelsUpDateTime;
		}
		
		public String getScheduledwheelsDownDateTime() {
			return scheduledwheelsDownDateTime;
		}
		
		public void setScheduledwheelsDownDateTime(String scheduledwheelsDownDateTime) {
			this.scheduledwheelsDownDateTime = scheduledwheelsDownDateTime;
		}
		
		public String getScheduledAirborneDateTime() {
			return scheduledAirborneDateTime;
		}
		
		public void setScheduledAirborneDateTime(String scheduledAirborneDateTime) {
			this.scheduledAirborneDateTime = scheduledAirborneDateTime;
		}
		
		public String getScheduledLandDateTime() {
			return scheduledLandDateTime;
		}
		
		public void setScheduledLandDateTime(String scheduledLandDateTime) {
			this.scheduledLandDateTime = scheduledLandDateTime;
		}
		
		
	}


	@Override
	public SeasonFlight.FlightIdentification getFlightIdentification() {
		if (flightIdentification == null){
			flightIdentification = new SeasonFlight.FlightIdentification();
		}
		return flightIdentification;
	}
	
	@Override
	public SeasonFlight.AircraftData getAircraftData() {
		if (aircraftData == null){
			aircraftData = new SeasonFlight.AircraftData();
		}
		return aircraftData;
	}

	@Override
	public SeasonFlight.AirportData getAirportData() {
		if (airportData == null){
			airportData = new SeasonFlight.AirportData();
		}
		return airportData;
	}

	@Override
	public SeasonFlight.FlightData getFlightData() {
		if (flightData == null){
			flightData = new SeasonFlight.FlightData();
		}
		return flightData;
	}

	@Override
	public SeasonFlight.RouteData getRouteData() {
		if (routeData == null){
			routeData = new SeasonFlight.RouteData();
		}
		return routeData;
	}

	@Override
	public SeasonFlight.OperationalTimes getOperationalTimes() {
		if (operationalTimes == null){
			operationalTimes = new SeasonFlight.OperationalTimes();
		}
		return operationalTimes;
	}

	public void setFlightIdentification(SeasonFlight.FlightIdentification flightIdentification) {
		this.flightIdentification = flightIdentification;
	}

	public void setAircraftData(SeasonFlight.AircraftData aircraftData) {
		this.aircraftData = aircraftData;
	}

	public void setAirportData(SeasonFlight.AirportData airportData) {
		this.airportData = airportData;
	}

	public void setFlightData(SeasonFlight.FlightData flightData) {
		this.flightData = flightData;
	}

	public void setRouteData(SeasonFlight.RouteData routeData) {
		this.routeData = routeData;
	}

	public void setOperationalTimes(SeasonFlight.OperationalTimes operationalTimes) {
		this.operationalTimes = operationalTimes;
	}


	
	

	
	
	
	
}
