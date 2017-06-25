package com.airport.ais.models.aodb.flight;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * 
 * FileName      ScheduledFlight.java
 * @Description  TODO 运营航班的航班计划实体类
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月20日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月20日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="Scheduled_Flight")
public class ScheduledFlight extends Flight {

	private static final long serialVersionUID = 1L;

	@Embedded
	protected ScheduledFlight.FlightIdentification flightIdentification;
	
	@Embedded
	protected ScheduledFlight.AircraftData aircraftData;
	
	@Embedded
	protected ScheduledFlight.AirportData airportData;
	
	@Embedded
	protected ScheduledFlight.FlightData flightData;
	
	@Embedded
	protected ScheduledFlight.RouteData routeData;
	
	@Embedded
	protected ScheduledFlight.OperationalTimes operationalTimes; 
	
	@Embedded
	protected ScheduledFlight.Load load;
	
	@Override
	public ScheduledFlight.FlightIdentification getFlightIdentification() {
		if (flightIdentification == null){
			flightIdentification = new ScheduledFlight.FlightIdentification();
		}
		return flightIdentification;
	}

	public void setFlightIdentification(ScheduledFlight.FlightIdentification flightIdentification) {
		this.flightIdentification = flightIdentification;
	}

	@Override
	public ScheduledFlight.AircraftData getAircraftData() {
		if (aircraftData == null){
			aircraftData = new ScheduledFlight.AircraftData();
		}
		return aircraftData;
	}

	public void setAircraftData(ScheduledFlight.AircraftData aircraftData) {
		this.aircraftData = aircraftData;
	}

	@Override
	public ScheduledFlight.AirportData getAirportData() {
		if (airportData == null){
			airportData = new ScheduledFlight.AirportData();
		}
		return airportData;
	}

	public void setAirportData(ScheduledFlight.AirportData airportData) {
		this.airportData = airportData;
	}

	@Override
	public ScheduledFlight.FlightData getFlightData() {
		if (flightData == null){
			flightData = new ScheduledFlight.FlightData();
		}
		return flightData;
	}

	public void setFlightData(ScheduledFlight.FlightData flightData) {
		this.flightData = flightData;
	}

	@Override
	public ScheduledFlight.RouteData getRouteData() {
		if (routeData == null){
			routeData = new ScheduledFlight.RouteData();
		}
		return routeData;
	}

	
	public void setRouteData(ScheduledFlight.RouteData routeData) {
		this.routeData = routeData;
	}

	@Override
	public ScheduledFlight.OperationalTimes getOperationalTimes() {
		if (operationalTimes == null){
			operationalTimes = new ScheduledFlight.OperationalTimes();
		}
		return operationalTimes;
	}

	public void setOperationalTimes(ScheduledFlight.OperationalTimes operationalTimes) {
		this.operationalTimes = operationalTimes;
	}

	@Override
	public ScheduledFlight.Load getLoad() {
		if (load == null){
			load = new ScheduledFlight.Load();
		}
		return load;
	}

	public void setLoad(ScheduledFlight.Load load) {
		this.load = load;
	}

	
	
	public static class  FlightIdentification extends Flight.FlightIdentification{
		
	}
	
	public static class  AircraftData extends Flight.AircraftData {
		
	}
	
	public static class  AirportData extends Flight.AirportData{
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="scheduled_Flight_id")
		protected Set<ScheduledFlight.AirportData.BaggageMakeupPosition> baggageMakeupPositions;
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="scheduled_Flight_id")
		protected Set<ScheduledFlight.AirportData.BaggageReclaimCarousel> baggageReclaimCarousels;
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="scheduled_Flight_id")
		protected Set<ScheduledFlight.AirportData.Checkin> checkins;
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="scheduled_Flight_id")
		protected Set<ScheduledFlight.AirportData.Gate> gates;

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.BaggageMakeupPosition> getBaggageMakeupPositions() {
			if (baggageMakeupPositions == null){
				baggageMakeupPositions = new HashSet<ScheduledFlight.AirportData.BaggageMakeupPosition>();
			}
			return this.baggageMakeupPositions;
		}

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.BaggageReclaimCarousel> getBaggageReclaimCarousels() {
			if (baggageReclaimCarousels == null){
				baggageReclaimCarousels = new HashSet<ScheduledFlight.AirportData.BaggageReclaimCarousel>();
			}
			return this.baggageReclaimCarousels;
		}

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.Checkin> getCheckins() {
			if (checkins == null){
				checkins = new HashSet<ScheduledFlight.AirportData.Checkin>();
			}
			return this.checkins;
		}

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.Gate> getGates() {
			if (gates == null){
				gates = new HashSet<ScheduledFlight.AirportData.Gate>();
			}
			return this.gates;
		}
		
		@Entity
		@Table(name="Scheduled_BaggageMakeupPosition")
		public class BaggageMakeupPosition extends Flight.AirportData.BaggageMakeupPosition{

			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Scheduled_BaggageReclaimCarousel")
		public class BaggageReclaimCarousel extends Flight.AirportData.BaggageReclaimCarousel{
			
			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Scheduled_Checkin")
		public class Checkin extends Flight.AirportData.Checkin{

			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Scheduled_Gate")
		public class Gate extends Flight.AirportData.Gate{

			private static final long serialVersionUID = 1L;
			
		}
	}

	public static class  FlightData extends Flight.FlightData{
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="scheduled_Flight_id")
		protected Set<ScheduledFlight.FlightData.ShareFlight> shareFlights;
		
		
		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.FlightData.ShareFlight> getShareFlights() {
			if (shareFlights == null){
				shareFlights = new HashSet<ScheduledFlight.FlightData.ShareFlight>();
			}
			return this.shareFlights;
		}

		@Entity
		@Table(name="Scheduled_ShareFlight")
		public class ShareFlight extends  BasicFlight.FlightData.ShareFlight{

			private static final long serialVersionUID = 1L;
			
		}


	
	}
	
	public static class  RouteData extends BasicFlight.RouteData{
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="scheduled_Flight_id")
		protected Set<ScheduledFlight.RouteData.StopFlight> stopFlights;
		
		@Override
		public Set<? extends StopFlight> getStopFlights() {
			if (stopFlights == null){
				stopFlights = new HashSet<ScheduledFlight.RouteData.StopFlight>();
			}
			return this.stopFlights;
		}

		@Entity
		@Table(name="Scheduled_StopFlight")
		public  class StopFlight extends BasicFlight.RouteData.StopFlight{
			
			private static final long serialVersionUID = 1L;
			
		}
	}

	public static class  OperationalTimes extends Flight.OperationalTimes{
		
	}

	public static class  Load extends Flight.Load{
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="scheduled_Flight_id")
		protected Set<ScheduledFlight.Load.LoadFlight> loadFlights;
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="scheduled_Flight_id")
		protected Set<ScheduledFlight.Load.Passenger>  passengers;
		
		

		@Override
		public Set<? extends LoadFlight> getLoadFlights() {
			if (loadFlights == null){
				loadFlights = new HashSet<ScheduledFlight.Load.LoadFlight>();
			}
			return this.loadFlights;
		}

		@Override
		public Set<? extends Passenger> getPassengers() {
			if (passengers == null){
				passengers = new HashSet<ScheduledFlight.Load.Passenger>();
			}
			return this.passengers;
		}

		@Entity
		@Table(name="Scheduled_LoadFlight")
		public class LoadFlight extends Flight.Load.LoadFlight{

			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Scheduled_Passenger")
		public class Passenger extends Flight.Load.Passenger{

			private static final long serialVersionUID = 1L;
			
		}
		
	}
	
}
