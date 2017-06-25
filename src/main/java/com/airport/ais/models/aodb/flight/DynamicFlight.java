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
 * 
 * FileName      DynamicFlight.java
 * @Description  TODO 运营航班的动态实体类，主要是定义各中航班相关的实体表
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月20日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月20日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="Dynamic_Flight")
public class DynamicFlight extends Flight {

	private static final long serialVersionUID = 1L;
	
	@Embedded
	protected DynamicFlight.FlightIdentification flightIdentification;
	
	@Embedded
	protected DynamicFlight.AircraftData aircraftData;
	
	@Embedded
	protected DynamicFlight.AirportData airportData;
	
	@Embedded
	protected DynamicFlight.FlightData flightData;
	
	@Embedded
	protected DynamicFlight.RouteData routeData;
	
	@Embedded
	protected DynamicFlight.OperationalTimes operationalTimes; 
	
	@Embedded
	protected DynamicFlight.Load load;
	
	
	@Override
	public DynamicFlight.FlightIdentification getFlightIdentification() {
		if (flightIdentification == null){
			flightIdentification = new DynamicFlight.FlightIdentification();
		}
		return flightIdentification;
	}

	public void setFlightIdentification(DynamicFlight.FlightIdentification flightIdentification) {
		this.flightIdentification = flightIdentification;
	}

	@Override
	public DynamicFlight.AircraftData getAircraftData() {
		if (aircraftData == null){
			aircraftData = new DynamicFlight.AircraftData();
		}
		return aircraftData;
	}

	public void setAircraftData(DynamicFlight.AircraftData aircraftData) {
		this.aircraftData = aircraftData;
	}

	@Override
	public DynamicFlight.AirportData getAirportData() {
		if (airportData == null){
			airportData = new DynamicFlight.AirportData();
		}
		return airportData;
	}

	public void setAirportData(DynamicFlight.AirportData airportData) {
		this.airportData = airportData;
	}

	@Override
	public DynamicFlight.FlightData getFlightData() {
		if (flightData == null){
			flightData = new DynamicFlight.FlightData();
		}
		return flightData;
	}

	public void setFlightData(DynamicFlight.FlightData flightData) {
		this.flightData = flightData;
	}

	@Override
	public DynamicFlight.RouteData getRouteData() {
		if (routeData == null){
			routeData = new DynamicFlight.RouteData();
		}
		return routeData;
	}

	
	public void setRouteData(DynamicFlight.RouteData routeData) {
		this.routeData = routeData;
	}

	@Override
	public DynamicFlight.OperationalTimes getOperationalTimes() {
		if (operationalTimes == null){
			operationalTimes = new DynamicFlight.OperationalTimes();
		}
		return operationalTimes;
	}

	public void setOperationalTimes(DynamicFlight.OperationalTimes operationalTimes) {
		this.operationalTimes = operationalTimes;
	}

	@Override
	public DynamicFlight.Load getLoad() {
		if (load == null){
			load = new DynamicFlight.Load();
		}
		return load;
	}

	public void setLoad(DynamicFlight.Load load) {
		this.load = load;
	}

	public static class  FlightIdentification extends Flight.FlightIdentification{
		
	}
	
	public static class  AircraftData extends Flight.AircraftData {
		
	}
	
	public static class  AirportData extends Flight.AirportData{
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected Set<DynamicFlight.AirportData.BaggageMakeupPosition> baggageMakeupPositions;
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected Set<DynamicFlight.AirportData.BaggageReclaimCarousel> baggageReclaimCarousels;
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected Set<DynamicFlight.AirportData.Checkin> checkins;
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected Set<DynamicFlight.AirportData.Gate> gates;

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.BaggageMakeupPosition> getBaggageMakeupPositions() {
			if (baggageMakeupPositions == null){
				baggageMakeupPositions = new HashSet<DynamicFlight.AirportData.BaggageMakeupPosition>();
			}
			return this.baggageMakeupPositions;
		}

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.BaggageReclaimCarousel> getBaggageReclaimCarousels() {
			if (baggageReclaimCarousels == null){
				baggageReclaimCarousels = new HashSet<DynamicFlight.AirportData.BaggageReclaimCarousel>();
			}
			return this.baggageReclaimCarousels;
		}

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.Checkin> getCheckins() {
			if (checkins == null){
				checkins = new HashSet<DynamicFlight.AirportData.Checkin>();
			}
			return this.checkins;
		}

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.Gate> getGates() {
			if (gates == null){
				gates = new HashSet<DynamicFlight.AirportData.Gate>();
			}
			return this.gates;
		}
		
		@Entity
		@Table(name="Dynamic_BaggageMakeupPosition")
		public class BaggageMakeupPosition extends Flight.AirportData.BaggageMakeupPosition{

			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Dynamic_BaggageReclaimCarousel")
		public class BaggageReclaimCarousel extends Flight.AirportData.BaggageReclaimCarousel{
			
			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Dynamic_Checkin")
		public class Checkin extends Flight.AirportData.Checkin{

			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Dynamic_Gate")
		public class Gate extends Flight.AirportData.Gate{

			private static final long serialVersionUID = 1L;
			
		}
	}

	public static class  FlightData extends Flight.FlightData{
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected Set<DynamicFlight.FlightData.ShareFlight> shareFlights;
		
		
		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.FlightData.ShareFlight> getShareFlights() {
			if (shareFlights == null){
				shareFlights = new HashSet<DynamicFlight.FlightData.ShareFlight>();
			}
			return this.shareFlights;
		}

		@Entity
		@Table(name="Dynamic_ShareFlight")
		public class ShareFlight extends  BasicFlight.FlightData.ShareFlight{

			private static final long serialVersionUID = 1L;
			
		}


	
	}
	
	public static class  RouteData extends BasicFlight.RouteData{
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected Set<DynamicFlight.RouteData.StopFlight> stopFlights;
		
		@Override
		public Set<? extends StopFlight> getStopFlights() {
			if (stopFlights == null){
				stopFlights = new HashSet<DynamicFlight.RouteData.StopFlight>();
			}
			return this.stopFlights;
		}

		@Entity
		@Table(name="Dynamic_StopFlight")
		public  class StopFlight extends BasicFlight.RouteData.StopFlight{
			
			private static final long serialVersionUID = 1L;
			
		}
	}

	public static class  OperationalTimes extends Flight.OperationalTimes{
		
	}

	public static class  Load extends Flight.Load{
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected Set<DynamicFlight.Load.LoadFlight> loadFlights;
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="dynamicFlight_id")
		protected Set<DynamicFlight.Load.Passenger>  passengers;
		
		

		@Override
		public Set<? extends LoadFlight> getLoadFlights() {
			if (loadFlights == null){
				loadFlights = new HashSet<DynamicFlight.Load.LoadFlight>();
			}
			return this.loadFlights;
		}

		@Override
		public Set<? extends Passenger> getPassengers() {
			if (passengers == null){
				passengers = new HashSet<DynamicFlight.Load.Passenger>();
			}
			return this.passengers;
		}

		@Entity
		@Table(name="Dynamic_LoadFlight")
		public class LoadFlight extends Flight.Load.LoadFlight{

			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="Dynamic_Passager")
		public class Passenger extends Flight.Load.Passenger{

			private static final long serialVersionUID = 1L;
			
		}
		
	}
}
