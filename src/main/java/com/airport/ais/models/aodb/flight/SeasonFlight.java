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
 * @Description  TODO ��������ʵ���� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��19��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��19��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */


@Entity
@Table(name="Season_Flight")
public class SeasonFlight extends BasicFlight {

	private static final long serialVersionUID = 1L;
	
	/**
	 * �����ʶ
	 */
	@Embedded
	protected SeasonFlight.FlightIdentification flightIdentification;
	/**
	 * �������� 
	 */
	@Embedded
	protected SeasonFlight.AircraftData aircraftData;
	/**
	 * �ɻ�����
	 */
	@Embedded
	protected SeasonFlight.AirportData airportData;
	/**
	 * ��������
	 */
	@Embedded
	protected SeasonFlight.FlightData flightData;
	/**
	 * ��������
	 */
	@Embedded
	protected SeasonFlight.RouteData routeData; 
	/**
	 * �������ʱ��
	 */
	@Embedded
	protected SeasonFlight.OperationalTimes operationalTimes; 
	
	
	/**
	 * TypeName      SeasonFlight.FlightIdentification 
	 * @Description  �̳�BasicFlight.FlightIdentification
	 */
	public static class FlightIdentification extends BasicFlight.FlightIdentification {
		
		/**
		 * ���������ֶ���,�������õ����ֶ���
		 */	
		public static final  String		DAYSOFOPERATION     = "daysOfOperation";
		public static final  String		SEASON              = "season";
		public static final  String		FLIGHTFIRSTDATETIME = "flightFirstDateTime";
		public static final  String		FLIGHTLASTDATETIME  = "flightLastDateTime";
		
		/**
		 *  ����ִ��Ƶ�ʼ���
		 */

		@Enumerated(EnumType.STRING)
		@ElementCollection(fetch=FetchType.EAGER)
		@Column(length=12)
		protected Set<OperationalDay> daysOfOperation;
		/**
		 * ����
		 */
		@Column(length=15)
		@Enumerated(EnumType.STRING)
		protected Season season;
		/**
		 * ������ʼʱ��
		 */
		protected Date flightFirstDateTime;
		/**
		 * ��������ʱ��
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
	 * @Description  �̳�BasicFlight.AircraftData
	 */
	public static class AircraftData extends BasicFlight.AircraftData {
		
	}
	/**
	 * TypeName      SeasonFlight.AirportData 
	 * @Description  �̳�BasicFlight.AirportData
	 */
	public static class AirportData extends BasicFlight.AirportData{
		/**
		 * ��������װ��ת�̼���
		 */
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.AirportData.BaggageMakeupPosition> baggageMakeupPosition;
		/**
		 * ������������ת�̼���
		 */
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.AirportData.BaggageReclaimCarousel> baggageReclaimCarousels;
		/**
		 * ����ֵ����̨����
		 */
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="season_Flight_id")
		protected Set<SeasonFlight.AirportData.Checkin> checkins;
		/**
		 * �����ǻ��ڼ���
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
		 * @Description  �̳�BasicFlight.AirportData.BaggageMakeupPosition����������װ��ת�̵�ʵ���
		 */
		@Entity
		@Table(name="Season_BaggageMakeupPosition")
		 public  class BaggageMakeupPosition extends BasicFlight.AirportData.BaggageMakeupPosition{

			private static final long serialVersionUID = 1L;
		 }

		/**
		 * TypeName      SeasonFlight.AirportData.BaggageReclaimCarousel 
		 * @Description  �̳�BasicFlight.AirportData.BaggageReclaimCarousel����������ת�������ʵ���
		 */
		 @Entity
		 @Table(name="Season_BaggageReclaimCarousel")
		 public  class BaggageReclaimCarousel extends BasicFlight.AirportData.BaggageReclaimCarousel{

			private static final long serialVersionUID = 1L;
		 }
	 
		 /**
		 * TypeName      SeasonFlight.AirportData.Checkin 
		 * @Description  �̳�BasicFlight.AirportData.Checkin ����ֵ����̨��ʵ���
		 */		 
		 @Entity
		 @Table(name="Season_Checkin")
		 public class Checkin extends BasicFlight.AirportData.Checkin{

			private static final long serialVersionUID = 1L;
		 }

		/**
		 * TypeName      SeasonFlight.AirportData.Gate 
		 * @Description  �̳�BasicFlight.AirportData.Gate  �����ǻ��ڵ�ʵ���
		 */
		 @Entity
		 @Table(name="Season_Gate")
		 public class Gate extends BasicFlight.AirportData.Gate{

			private static final long serialVersionUID = 1L;
			 
		 }

		


		 
	}
	/**
	 * TypeName      SeasonFlight.FlightData 
	 * @Description  �̳�BasicFlight.FlightData
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
	 * @Description  �̳�BasicFlight.RouteData
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
	 * @Description  �̳�BasicFlight.OperationalTimes
	 */
	public static class OperationalTimes extends BasicFlight.OperationalTimes{
		
		/**
		 * ���������ֶ���,�������õ����ֶ���
		 */	
		public static final  String SCHEDULEDOFFBLOCKSDATETIME      = "scheduledOffBlocksDateTime";
		public static final  String SCHEDULEDONBLOCKSDATETIME       = "scheduledOnBlocksDateTime";
		public static final  String SCHEDULEDWHEELSUPDATETIME       = "scheduledwheelsUpDateTime";
		public static final  String SCHEDULEDWHEELSDOWNDATETIME     = "scheduledwheelsDownDateTime";
		public static final  String SCHEDULEDAIRBORNEDATETIME       = "scheduledAirborneDateTime";
		public static final  String SCHEDULEDLANDDATETIME           = "scheduledLandDateTime";
		/**
		 * �ƻ����ʱ��
		 */
		@Column(length=6)
		protected String scheduledOffBlocksDateTime;
		/**
		 * �ƻ�����ʱ��
		 */
		@Column(length=6)
		protected String scheduledOnBlocksDateTime;
		/**
		 * �ƻ����ֵ�ʱ��
		 */
		@Column(length=6)
		protected String scheduledwheelsUpDateTime;
		/**
		 *  �ƻ����ֵ�ʱ��
		 */
		@Column(length=6)
		protected String scheduledwheelsDownDateTime;
		/**
		 *  �ƻ���ɵ�ʱ��
		 */
		@Column(length=6)
		protected String scheduledAirborneDateTime;
		/**
		 *  �ƻ���ص�ʱ��
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
