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
 * FileName      HistoryFlight.java
 * @Description  TODO 运营航班的历史数据，主要是定义各中航班相关的实体表 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月20日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月20日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
@Table(name="History_Flight")
public class HistoryFlight extends Flight {

	private static final long serialVersionUID = 1L;
	
	@Embedded
	protected HistoryFlight.FlightIdentification flightIdentification;
	
	@Embedded
	protected HistoryFlight.AircraftData aircraftData;
	
	@Embedded
	protected HistoryFlight.AirportData  airportData;
	
	@Embedded
	protected HistoryFlight.FlightData flightData;
	
	@Embedded
	protected HistoryFlight.OperationalTimes operationalTimes;
	
	@Embedded
	protected HistoryFlight.RouteData routeData;
	
	@Embedded
	protected HistoryFlight.Load load;
	
	
	@Override
	public HistoryFlight.FlightIdentification getFlightIdentification() {
		if (flightIdentification == null){
			flightIdentification = new HistoryFlight.FlightIdentification();
		}
		return flightIdentification;
	}

	public void setFlightIdentification(HistoryFlight.FlightIdentification flightIdentification) {
		this.flightIdentification = flightIdentification;
	}

	@Override
	public HistoryFlight.AircraftData getAircraftData() {
		if (aircraftData == null){
			aircraftData = new HistoryFlight.AircraftData();
		}
		return aircraftData;
	}

	public void setAircraftData(HistoryFlight.AircraftData aircraftData) {
		this.aircraftData = aircraftData;
	}

	@Override
	public HistoryFlight.AirportData getAirportData() {
		if (airportData == null){
			airportData = new HistoryFlight.AirportData();
		}
		return airportData;
	}

	public void setAirportData(HistoryFlight.AirportData airportData) {
		this.airportData = airportData;
	}

	@Override
	public HistoryFlight.FlightData getFlightData() {
		if (flightData == null){
			flightData = new HistoryFlight.FlightData();
		}
		return flightData;
	}

	public void setFlightData(HistoryFlight.FlightData flightData) {
		this.flightData = flightData;
	}

	@Override
	public HistoryFlight.RouteData getRouteData() {
		if (routeData == null){
			routeData = new HistoryFlight.RouteData();
		}
		return routeData;
	}

	
	public void setRouteData(HistoryFlight.RouteData routeData) {
		this.routeData = routeData;
	}

	@Override
	public HistoryFlight.OperationalTimes getOperationalTimes() {
		if (operationalTimes == null){
			operationalTimes = new HistoryFlight.OperationalTimes();
		}
		return operationalTimes;
	}

	public void setOperationalTimes(HistoryFlight.OperationalTimes operationalTimes) {
		this.operationalTimes = operationalTimes;
	}

	@Override
	public HistoryFlight.Load getLoad() {
		if (load == null){
			load = new HistoryFlight.Load();
		}
		return load;
	}

	public void setLoad(HistoryFlight.Load load) {
		this.load = load;
	}

	
	public static class  FlightIdentification extends Flight.FlightIdentification{
		
	}
	
	public static class  AircraftData extends Flight.AircraftData {
		
	}
	
	public static class  AirportData extends Flight.AirportData{

		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="history_Flight_id")
		protected Set<HistoryFlight.AirportData.BaggageMakeupPosition> baggageMakeupPositions;
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="history_Flight_id")
		protected Set<HistoryFlight.AirportData.BaggageReclaimCarousel> baggageReclaimCarousels;
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="history_Flight_id")
		protected Set<HistoryFlight.AirportData.Checkin> checkins;
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="history_Flight_id")
		protected Set<HistoryFlight.AirportData.Gate> gates;

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.BaggageMakeupPosition> getBaggageMakeupPositions() {
			if (baggageMakeupPositions == null){
				baggageMakeupPositions = new HashSet<HistoryFlight.AirportData.BaggageMakeupPosition>();
			}
			return this.baggageMakeupPositions;
		}

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.BaggageReclaimCarousel> getBaggageReclaimCarousels() {
			if (baggageReclaimCarousels == null){
				baggageReclaimCarousels = new HashSet<HistoryFlight.AirportData.BaggageReclaimCarousel>();
			}
			return this.baggageReclaimCarousels;
		}

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.Checkin> getCheckins() {
			if (checkins == null){
				checkins = new HashSet<HistoryFlight.AirportData.Checkin>();
			}
			return this.checkins;
		}

		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.AirportData.Gate> getGates() {
			if (gates == null){
				gates = new HashSet<HistoryFlight.AirportData.Gate>();
			}
			return this.gates;
		}
		
		@Entity
		@Table(name="History_BaggageMakeupPosition")
		public class BaggageMakeupPosition extends Flight.AirportData.BaggageMakeupPosition{

			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="History_BaggageReclaimCarousel")
		public class BaggageReclaimCarousel extends Flight.AirportData.BaggageReclaimCarousel{
			
			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="History_Checkin")
		public class Checkin extends Flight.AirportData.Checkin{

			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="History_Gate")
		public class Gate extends Flight.AirportData.Gate{

			private static final long serialVersionUID = 1L;
			
		}
	}

	public static class  FlightData extends Flight.FlightData{
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="history_Flight_id")
		protected Set<HistoryFlight.FlightData.ShareFlight> shareFlights;
		
		
		@Override
		public Set<? extends com.airport.ais.models.aodb.flight.BasicFlight.FlightData.ShareFlight> getShareFlights() {
			if (shareFlights == null){
				shareFlights = new HashSet<HistoryFlight.FlightData.ShareFlight>();
			}
			return this.shareFlights;
		}

		@Entity
		@Table(name="History_ShareFlight")
		public class ShareFlight extends  BasicFlight.FlightData.ShareFlight{

			private static final long serialVersionUID = 1L;
			
		}


	
	}
	
	public static class  RouteData extends BasicFlight.RouteData{
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="history_Flight_id")
		protected Set<HistoryFlight.RouteData.StopFlight> stopFlights;
		
		@Override
		public Set<? extends StopFlight> getStopFlights() {
			if (stopFlights == null){
				stopFlights = new HashSet<HistoryFlight.RouteData.StopFlight>();
			}
			return this.stopFlights;
		}

		@Entity
		@Table(name="History_StopFlight")
		public  class StopFlight extends BasicFlight.RouteData.StopFlight{
			
			private static final long serialVersionUID = 1L;
			
		}
	}

	public static class  OperationalTimes extends Flight.OperationalTimes{
		
	}

	public static class  Load extends Flight.Load{
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="history_Flight_id")
		protected Set<HistoryFlight.Load.LoadFlight> loadFlights;
		
		@OneToMany(cascade = {CascadeType.MERGE,CascadeType.REMOVE,CascadeType.PERSIST},orphanRemoval=true)
		@JoinColumn(name="history_Flight_id")
		protected Set<HistoryFlight.Load.Passenger>  passagers;
		
		

		@Override
		public Set<? extends LoadFlight> getLoadFlights() {
			if (loadFlights == null){
				loadFlights = new HashSet<HistoryFlight.Load.LoadFlight>();
			}
			return this.loadFlights;
		}

		@Override
		public Set<? extends Passenger> getPassengers() {
			if (passagers == null){
				passagers = new HashSet<HistoryFlight.Load.Passenger>();
			}
			return this.passagers;
		}

		@Entity
		@Table(name="History_LoadFlight")
		public class LoadFlight extends Flight.Load.LoadFlight{

			private static final long serialVersionUID = 1L;
			
		}
		
		@Entity
		@Table(name="History_Passenger")
		public class Passenger extends Flight.Load.Passenger{

			private static final long serialVersionUID = 1L;
			
		}
		
	}
	
	
}
