package com.airport.ais.models.aodb.flight;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.airport.ais.enums.aodb.FlightCode;
import com.airport.ais.enums.aodb.GateBoardingStatus;
import com.airport.ais.enums.aodb.PassagerCardLevel;
import com.airport.ais.models.IntIdEntity;
import com.airport.ais.models.aodb.basic.Airport;
import com.airport.ais.models.aodb.basic.Aiscraft;
import com.airport.ais.models.aodb.basic.CAACDelayCategory;
import com.airport.ais.models.aodb.basic.CAACDelayCode;
import com.airport.ais.models.aodb.basic.Carrier;
import com.airport.ais.models.aodb.basic.FlightStatus;

/**
 * 
 * FileName      Flight.java
 * @Description  运营航班的基类继承 BasicFlight,添加运营航班所需的数据字段。
 * 1、对静态数据集合类继承以便进一步的扩充字段
 * 2、添加一个静态数据集合类Load
 * 3、添加两个实体表
 * 3.1 Flight.Load.LoadFlight
 * 3.2 Flight.Load.Passenger
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月17日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月17日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@SuppressWarnings("serial")
@MappedSuperclass
public  abstract class Flight extends BasicFlight {
	
	/**
	 * 各个数据字段名,用来调用点用字段名
	 */	
	public static final  String  LOAD = "load";
	
	/**
	 * TypeName      Flight.FlightIdentification
	 * @Description  继承BasicFlight.FlightIdentification
	 */
	@MappedSuperclass
	public abstract static class FlightIdentification extends BasicFlight.FlightIdentification{
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String    SCHEDULEDDATETIME     =    "scheduledDateTime";
		
		/**
		 * 执行日期
		 */
		protected Date scheduledDateTime;

		public Date getScheduledDateTime() {
			return scheduledDateTime;
		}

		public void setScheduledDateTime(Date scheduledDateTime) {
			this.scheduledDateTime = scheduledDateTime;
		}
		
		
	}
	
	
	
	/**
	 * FileName      Flight.AircraftData
	 * @Description  继承BasicFlight.AircraftData
	 */
	@MappedSuperclass
	public abstract static class AircraftData extends BasicFlight.AircraftData{
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String 	AISCRAFT     =    "aiscraft";
		public static final  String 	CARRIER      =    "carrier";
		
		/**
		 * 飞机
		 */
		@ManyToOne
		protected Aiscraft aiscraft;
		/**
		 * 承运人
		 */
		@ManyToOne
		protected Carrier carrier;
		
		public Aiscraft getAiscraft() {
			return aiscraft;
		}
		
		public void setAiscraft(Aiscraft aiscraft) {
			this.aiscraft = aiscraft;
		}
		
		public Carrier getCarrier() {
			return carrier;
		}
		
		public void setCarrier(Carrier carrier) {
			this.carrier = carrier;
		}
		
		
	}
	
	/**
	 * TypeName      Flight.FlightData
	 * @Description  继承BasicFlight.FlightData
	 */
	@MappedSuperclass
	public abstract static class FlightData extends BasicFlight.FlightData{
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String FLIGHTSTATUS         =    "flightStatus ";
		public static final  String CAACDELAYDETAILS     =    "caacDelayDetails ";
		public static final  String ALTERNATEAIRPORT     =    "alternateAirport";
		public static final  String FLIGHTREPEATCOUNT    =   "flightRepeatCount";
		public static final  String ISRETURNFLIGHT       =   "isReturnFlight";
		public static final  String HASVIPS              =   "hasVIPs";
		public static final  String FLIGHTCODE           =   "flightCode";
		
		
		/**
		 * 航班状态
		 */
		@ManyToOne
		protected FlightStatus flightStatus;
		/**
		 * 延误细节
		 */
		@Embedded
		protected CAACDelayDetails caacDelayDetails;
		/**
		 * 备降机场
		 */
		@ManyToOne
		protected Airport alternateAirport;
		
		/**
		 *  航班重复次数，一般指返场
		 */
		protected Integer flightRepeatCount;
		/**
		 * 航班航班标识
		 */
		protected Boolean isReturnFlight;
		/**
		 * 是否有VIP
		 */
		protected Boolean hasVIPs;
		/**
		 * 航班正常代码
		 */
		@Column(length=1)
		@Enumerated(EnumType.STRING)
		protected FlightCode flightCode;
		/**
		 * 连接航班
		 */
		@Embedded
		protected LinkedFlight linkedFlight;
		
		/**
		 * 
		 * TypeName      Flight.FlightData.CAACDelayDetails
		 * @Description  航班延误细节的静态类 
		 */
		public static class CAACDelayDetails {
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			public static final  String  CAACDELAYCATEGORY           = "caacDelayCategory";
			public static final  String  CAACDELAYCODE               = "caacDelayCode";
			public static final  String  CAACDELAYDURATION           = "caacDelayDuration";
			public static final  String  CAACDELAYAIRPORTORIGINATED  = "caacDelayAirportOriginated";
			
			/**
			 * 延误类别
			 */
			@ManyToOne
		    protected CAACDelayCategory caacDelayCategory;
		    /**
		     * 延误代码
		     */
			@ManyToOne
		    protected CAACDelayCode caacDelayCode;
		    /**
		     * 延误时间
		     */
			@Column(length=6)
		    protected String caacDelayDuration;
		    /**
		     * 是否是始发延误原因
		     */
		    protected Boolean caacDelayAirportOriginated;
		    
			public CAACDelayCategory getCaacDelayCategory() {
				
				return caacDelayCategory;
			}
			
			public void setCaacDelayCategory(CAACDelayCategory caacDelayCategory) {
				this.caacDelayCategory = caacDelayCategory;
			}
			
			public CAACDelayCode getCaacDelayCode() {
				return caacDelayCode;
			}
			
			public void setCaacDelayCode(CAACDelayCode caacDelayCode) {
				this.caacDelayCode = caacDelayCode;
			}
			
			public String getCaacDelayDuration() {
				return caacDelayDuration;
			}
			
			public void setCaacDelayDuration(String caacDelayDuration) {
				this.caacDelayDuration = caacDelayDuration;
			}
			
			public Boolean getCaacDelayAirportOriginated() {
				return caacDelayAirportOriginated;
			}
			
			public void setCaacDelayAirportOriginated(Boolean caacDelayAirportOriginated) {
				this.caacDelayAirportOriginated = caacDelayAirportOriginated;
			}
		    
		    
		}
		/**
		 * 
		 * TypeName      Flight.FlightData.LinkedFlight
		 * @Description  继承 BasicFlight.FlightData.LinkedFlight
		 * 增加字段: 
		 */
		public static class LinkedFlight extends BasicFlight.FlightData.LinkedFlight{
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			public static final  String    LINKEDSCHEDULEDDATETIME =  "linkedscheduledDateTime";
			 
			
			/**
			 *  连接航班日期
			 */
			protected Date linkedscheduledDateTime;

			public Date getLinkedscheduledDateTime() {
				return linkedscheduledDateTime;
			}

			public void setLinkedscheduledDateTime(Date linkedscheduledDateTime) {
				this.linkedscheduledDateTime = linkedscheduledDateTime;
			}
			
		}
		
		
	}
	
	/**
	 * TypeName      Flight.OperationalTimes
	 * @Description  继承 BasicFlight.OperationalTimes
	 * 注：备降时间也更新在正常起降时间中
	 */
	@MappedSuperclass
	public abstract static class OperationalTimes extends BasicFlight.OperationalTimes{
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String ACTUALOFFBLOCKSDATETIME         = "actualOffBlocksDateTime";
		public static final  String ACTUALONBLOCKSDATETIME          = "actualOnBlocksDateTime";
		public static final  String WHEELSUPDATETIME                = "wheelsUpDateTime";
		public static final  String WHEELSDOWNDATETIME              = "wheelsDownDateTime";
		public static final  String SCHEDULEDAIRBORNEDATETIME       = "scheduledAirborneDateTime";
		public static final  String ESTIMATEDAIRBORNEDATETIME       = "estimatedAirborneDateTime";
		public static final  String ACTUALAIRBORNEDATETIME          = "actualAirborneDateTime";
		public static final  String SCHEDULEDLANDDATETIME           = "scheduledLandDateTime";
		public static final  String ESTIMATEDLANDDATETIME           = "estimatedLandDateTime";
		public static final  String ACTUALLANDDATETIME              = "actualLandDateTime";
		
		
		
		
		/**
		 * 离港时间
		 */
		protected Date actualOffBlocksDateTime;
		/**
		 * 到港时间
		 */
		protected Date actualOnBlocksDateTime;
		/**
		 * 上轮档时间
		 */
		protected Date wheelsUpDateTime;
		/**
		 *  下轮档时间
		 */
		protected Date wheelsDownDateTime;
		/**
		 *  计划起飞的时间
		 */
		protected Date scheduledAirborneDateTime;
		/**
		 * 预计起飞的时间
		 */
		protected Date estimatedAirborneDateTime;
		/**
		 * 实际起飞的时间
		 */
		protected Date actualAirborneDateTime;
		/**
		 *  计划起飞的时间
		 */
		protected Date scheduledLandDateTime;
		/**
		 * 预计起飞的时间
		 */
		protected Date estimatedLandDateTime;
		/**
		 * 实际起飞的时间
		 */
		protected Date actualLandDateTime;
		
		public Date getActualOffBlocksDateTime() {
			return actualOffBlocksDateTime;
		}
		
		public void setActualOffBlocksDateTime(Date actualOffBlocksDateTime) {
			this.actualOffBlocksDateTime = actualOffBlocksDateTime;
		}
		
		public Date getActualOnBlocksDateTime() {
			return actualOnBlocksDateTime;
		}
		
		public void setActualOnBlocksDateTime(Date actualOnBlocksDateTime) {
			this.actualOnBlocksDateTime = actualOnBlocksDateTime;
		}
		
		public Date getWheelsUpDateTime() {
			return wheelsUpDateTime;
		}
		
		public void setWheelsUpDateTime(Date wheelsUpDateTime) {
			this.wheelsUpDateTime = wheelsUpDateTime;
		}
		
		public Date getWheelsDownDateTime() {
			return wheelsDownDateTime;
		}
		
		public void setWheelsDownDateTime(Date wheelsDownDateTime) {
			this.wheelsDownDateTime = wheelsDownDateTime;
		}
		
		public Date getScheduledAirborneDateTime() {
			return scheduledAirborneDateTime;
		}
		
		public void setScheduledAirborneDateTime(Date scheduledAirborneDateTime) {
			this.scheduledAirborneDateTime = scheduledAirborneDateTime;
		}
		
		public Date getEstimatedAirborneDateTime() {
			return estimatedAirborneDateTime;
		}
		
		public void setEstimatedAirborneDateTime(Date estimatedAirborneDateTime) {
			this.estimatedAirborneDateTime = estimatedAirborneDateTime;
		}
		
		public Date getActualAirborneDateTime() {
			return actualAirborneDateTime;
		}
		
		public void setActualAirborneDateTime(Date actualAirborneDateTime) {
			this.actualAirborneDateTime = actualAirborneDateTime;
		}
		
		public Date getScheduledLandDateTime() {
			return scheduledLandDateTime;
		}
		
		public void setScheduledLandDateTime(Date scheduledLandDateTime) {
			this.scheduledLandDateTime = scheduledLandDateTime;
		}
		
		public Date getEstimatedLandDateTime() {
			return estimatedLandDateTime;
		}
		
		public void setEstimatedLandDateTime(Date estimatedLandDateTime) {
			this.estimatedLandDateTime = estimatedLandDateTime;
		}
		
		public Date getActualLandDateTime() {
			return actualLandDateTime;
		}
		
		public void setActualLandDateTime(Date actualLandDateTime) {
			this.actualLandDateTime = actualLandDateTime;
		}
		
		

	}

	
	/**
	 * TypeName      Flight.AirportData
	 * @Description  继承 BasicFlight.AirportData
	 * 注：备降时间也更新在正常起降时间中
	 */
	@MappedSuperclass
	public abstract static  class AirportData extends BasicFlight.AirportData{
		
		
		
		/**
		  * TypeName      Flight.AirportData.BaggageMakeupPosition
		  * @Description  继承BasicFlight.AirportData.BaggageMakeupPosition
		  */
		 @MappedSuperclass
		 public  class BaggageMakeupPosition  extends BasicFlight.AirportData.BaggageMakeupPosition {
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			 public static final String  BAGGAGEMAKEUPOPENDATETIME  = "baggageMakeupOpenDateTime";
			 public static final String  BAGGAGEMAKEUPCLOSEDATETIME = "baggageMakeupCloseDateTime";
			 /**
			  * 开启时间
			  */
			 protected Date baggageMakeupOpenDateTime;
			 /**
			  * 关闭时间
			  */
			 protected Date baggageMakeupCloseDateTime;
			 
			 public Date getBaggageMakeupOpenDateTime() {
				 return baggageMakeupOpenDateTime;
			 }
			 
			 public void setBaggageMakeupOpenDateTime(Date baggageMakeupOpenDateTime) {
				 this.baggageMakeupOpenDateTime = baggageMakeupOpenDateTime;
			 }
			 
			 public Date getBaggageMakeupCloseDateTime() {
				 return baggageMakeupCloseDateTime;
			 }
			 
			 public void setBaggageMakeupCloseDateTime(Date baggageMakeupCloseDateTime) {
				 this.baggageMakeupCloseDateTime = baggageMakeupCloseDateTime;
			 }
			 
			 
		 }
		 /**
		  * 
		  * TypeName      Flight.AirportData.BaggageReclaimCarousel
		  * @Description  继承BasicFlight.AirportData.BaggageReclaimCarousel
		  */
		 @MappedSuperclass
		 public  class BaggageReclaimCarousel extends BasicFlight.AirportData.BaggageReclaimCarousel{
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			 public static final String  BAGGAGERECLAIMOPENDATETIME  = "baggageReclaimOpenDateTime";
			 public static final String  BAGGAGERECLAIMCLOSEDATETIME = "baggageReclaimCloseDateTime";
			 public static final String  FIRSTBAGDATETIME            = "firstBagDateTime";
			 public static final String  LASTBAGDATETIME             = "lastBagDateTime";
			 public static final String  EXITDOORNUMBER              = "exitDoorNumber";
			 
			 /**
			  * 开启时间
			  */
			 protected Date baggageReclaimOpenDateTime;
			 /**
			  * 关闭时间
			  */
			 protected Date baggageReclaimCloseDateTime;
			 /**
			  * 开启时间
			  */
			 protected Date firstBagDateTime;
			 /**
			  * 关闭时间
			  */
			 protected Date lastBagDateTime;
			 /**
			  * 出口标识
			  */
			 @Column(length=4)
			 protected String exitDoorNumber;
			 
			 public Date getBaggageReclaimOpenDateTime() {
				 return baggageReclaimOpenDateTime;
			 }
			 
			 public void setBaggageReclaimOpenDateTime(Date baggageReclaimOpenDateTime) {
				 this.baggageReclaimOpenDateTime = baggageReclaimOpenDateTime;
			 }
			 
			 public Date getBaggageReclaimCloseDateTime() {
				 return baggageReclaimCloseDateTime;
			 }
			 
			 public void setBaggageReclaimCloseDateTime(Date baggageReclaimCloseDateTime) {
				 this.baggageReclaimCloseDateTime = baggageReclaimCloseDateTime;
			 }
			 
			 public Date getFirstBagDateTime() {
				 return firstBagDateTime;
			 }
			 
			 public void setFirstBagDateTime(Date firstBagDateTime) {
				 this.firstBagDateTime = firstBagDateTime;
			 }
			 
			 public Date getLastBagDateTime() {
				 return lastBagDateTime;
			 }
			 
			 public void setLastBagDateTime(Date lastBagDateTime) {
				 this.lastBagDateTime = lastBagDateTime;
			 }
			 
			 public String getExitDoorNumber() {
				 return exitDoorNumber;
			 }
			 
			 public void setExitDoorNumber(String exitDoorNumber) {
				 this.exitDoorNumber = exitDoorNumber;
			 }
			 
			 
		 }
		 /**
		  * TypeName      Flight.AirportData.Checkin
		  * @Description  继承BasicFlight.AirportData.Checkin
		  */
		 @MappedSuperclass
		 public class Checkin extends BasicFlight.AirportData.Checkin{
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			 public static final String  CHECKINOPENDATETIME  = "checkinOpenDateTime";
			 public static final String  CHECKINCLOSEDATETIME = "checkinCloseDateTime";
			 
			 /**
			  *  值机开始时间
			  */
			 protected Date checkinOpenDateTime; 
			 /**
			  *  值机结束时间
			  */
			 protected Date checkinCloseDateTime;
			 
			 public Date getCheckinOpenDateTime() {
				 return checkinOpenDateTime;
			 }
			 
			 public void setCheckinOpenDateTime(Date checkinOpenDateTime) {
				 this.checkinOpenDateTime = checkinOpenDateTime;
			 }
			 
			 public Date getCheckinCloseDateTime() {
				 return checkinCloseDateTime;
			 }
			 
			 public void setCheckinCloseDateTime(Date checkinCloseDateTime) {
				 this.checkinCloseDateTime = checkinCloseDateTime;
			 }
			 
			 
		 }
		 /**
		  * TypeName      Flight.AirportData.Checkin
		  * @Description  继承BasicFlight.AirportData.Checkin
		  */
		 @MappedSuperclass
		 public class Gate extends BasicFlight.AirportData.Gate{
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */	
			 public static final String   GATEOPENDATETIME   = "gateOpenDateTime";
			 public static final String   GATECLOSEDATETIME  = "gateCloseDateTime";
			 public static final String   GATEBOARDINGSTATUS = "gateBoardingStatus";
			 
			 /**
			  * 登机开放的时间
			  */
			 protected Date gateOpenDateTime;
			 /**
			  * 登机结束的时间
			  */
			 protected Date gateCloseDateTime;
			 /**
			  * 登机状态
			  */
			 @Enumerated(EnumType.STRING)
			 protected GateBoardingStatus gateBoardingStatus;
			 
			 public Date getGateOpenDateTime() {
				 return gateOpenDateTime;
			 }
			 
			 public void setGateOpenDateTime(Date gateOpenDateTime) {
				 this.gateOpenDateTime = gateOpenDateTime;
			 }
			 
			 public Date getGateCloseDateTime() {
				 return gateCloseDateTime;
			 }
			 
			 public void setGateCloseDateTime(Date gateCloseDateTime) {
				 this.gateCloseDateTime = gateCloseDateTime;
			 }
			 
			 public GateBoardingStatus getGateBoardingStatus() {
				 return gateBoardingStatus;
			 }
			 
			 public void setGateBoardingStatus(GateBoardingStatus gateBoardingStatus) {
				 this.gateBoardingStatus = gateBoardingStatus;
			 }
			 
			 
		 }
	
	}

	/**
	 * TypeName      Flight.Load
	 * @Description  航班载量的静态类，与载量相关的所有数据的集合
	 */
	@MappedSuperclass
	public abstract static class Load {
		/**
		 * 各个数据字段名,用来调用点用字段名
		 */	
		public static final  String    PASSENGERLOADFACTOR     = "passengerLoadFactor";
		public static final  String    PASSENGERTONKILOMETERS  = "passengerTonkilometers";
		public static final  String    CARGOTONKILOMETERS      = "cargoTonkilometers";
		public static final  String    MAILTONKILOMETERS       = "mailTonkilometers";
		public static final  String    LOADS                   = "loads";
		public static final  String    PASSENGERS              = "passengers";
	
		
		/**
		 * 航班客座率
		 */
		protected Double passengerLoadFactor;
		/**
		 * 旅客周转量
		 */
		protected Integer passengerTonkilometers;
		/**
		 * 货物周转量
		 */
		protected Integer cargoTonkilometers;
		/**
		 * 邮件周转量
		 */
		protected Integer mailTonkilometers;
		
		
		
		
		public Double getPassengerLoadFactor() {
			return passengerLoadFactor;
		}

		public void setPassengerLoadFactor(Double passengerLoadFactor) {
			this.passengerLoadFactor = passengerLoadFactor;
		}

		public Integer getPassengerTonkilometers() {
			return passengerTonkilometers;
		}

		public void setPassengerTonkilometers(Integer passengerTonkilometers) {
			this.passengerTonkilometers = passengerTonkilometers;
		}

		public Integer getCargoTonkilometers() {
			return cargoTonkilometers;
		}

		public void setCargoTonkilometers(Integer cargoTonkilometers) {
			this.cargoTonkilometers = cargoTonkilometers;
		}

		public Integer getMailTonkilometers() {
			return mailTonkilometers;
		}

		public void setMailTonkilometers(Integer mailTonkilometers) {
			this.mailTonkilometers = mailTonkilometers;
		}

		public  abstract Set<? extends LoadFlight> getLoadFlights(); 
		 
		public  abstract Set<? extends Passenger>  getPassengers();
		
		/**
		 * TypeName      Flight.Load.LoadFlight
		 * @Description  航班载量的实体类
		 */
		@MappedSuperclass
		public class LoadFlight extends IntIdEntity {
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */				
			public static final String   LOADDEPARTUREAIRPORT = "loadDepartureAirport";
			public static final String   LOADARRIVALAIRPORT   = "loadArrivalAirport";
			public static final String   ADULT                = "adult";
			public static final String   CHD                  = "chd";
			public static final String   INF                  = "inf";
			public static final String   CARGO                = "cargo";
			public static final String   MAIL                 = "mail";
			public static final String   BAGGAGE              = "baggage";
			
			/**
			 * 起始机场
			 */
			protected Airport loadDepartureAirport; 
			/**
			 * 落地机场
			 */
			protected Airport loadArrivalAirport;
			/**
			 *  成人
			 */
			protected Integer adult;
			/**
			 * 儿童
			 */
			protected Integer chd;
			/**
			 * 婴儿
			 */
			protected Integer inf;
			/**
			 * 货物
			 */
			protected Integer cargo;
			/**
			 * 邮件
			 */
			protected Integer mail;
			/**
			 * 行李
			 */
			protected Integer baggage;
			
			public Airport getLoadDepartureAirport() {
				return loadDepartureAirport;
			}
			
			public void setLoadDepartureAirport(Airport loadDepartureAirport) {
				this.loadDepartureAirport = loadDepartureAirport;
			}
			
			public Airport getLoadArrivalAirport() {
				return loadArrivalAirport;
			}
			
			public void setLoadArrivalAirport(Airport loadArrivalAirport) {
				this.loadArrivalAirport = loadArrivalAirport;
			}
			
			public Integer getAdult() {
				return adult;
			}
			
			public void setAdult(Integer adult) {
				this.adult = adult;
			}
			
			public Integer getChd() {
				return chd;
			}
			
			public void setChd(Integer chd) {
				this.chd = chd;
			}
			
			public Integer getInf() {
				return inf;
			}
			
			public void setInf(Integer inf) {
				this.inf = inf;
			}
			
			public Integer getCargo() {
				return cargo;
			}
			
			public void setCargo(Integer cargo) {
				this.cargo = cargo;
			}
			
			public Integer getMail() {
				return mail;
			}
			
			public void setMail(Integer mail) {
				this.mail = mail;
			}
			
			public Integer getBaggage() {
				return baggage;
			}
			
			public void setBaggage(Integer baggage) {
				this.baggage = baggage;
			}
			
			
		}
		/**
		 * TypeName      Flight.Load.Passenger
		 * @Description  旅客名单的实体类
		 */
		@MappedSuperclass
		public class Passenger extends IntIdEntity{
			/**
			 * 各个数据字段名,用来调用点用字段名
			 */				
			public static final String   NAME         = "name";
			public static final String   TICKETNO     = "ticketNo";
			public static final String   CARDNUMBER   = "cardNumber";
			public static final String   CLASSLEVEL   = "classLevel";
			public static final String   CARDLEVEL    = "cardLevel";
			public static final String   COST         = "cost";
					
			/**
			 * 姓名
			 */
			@Column(length=32)
			protected String name;
			/**
			 * 票号
			 */
			@Column(length=32)
			protected String ticketNumber;
			/**
			 * 卡号
			 */
			@Column(length=32)
			protected String cardNumber;
			/**
			 * 舱位等级
			 */
			@Column(length=1)
			protected String classLevel;
			
			@Column(length=10)
			@Enumerated(EnumType.STRING)
			protected PassagerCardLevel cardLevel;
			/**
			 * 费用
			 */
			protected Integer cost;
			
			public String getName() {
				return name;
			}
			
			public void setName(String name) {
				this.name = name;
			}
			
			public String getTicketNumber() {
				return ticketNumber;
			}
			
			public void setTicketNumber(String ticketNumber) {
				this.ticketNumber = ticketNumber;
			}
			
			public String getCardNumber() {
				return cardNumber;
			}
			
			public void setCardNumber(String cardNumber) {
				this.cardNumber = cardNumber;
			}
			
			public String getClassLevel() {
				return classLevel;
			}
			
			public void setClassLevel(String classLevel) {
				this.classLevel = classLevel;
			}
			
			public PassagerCardLevel getCardLevel() {
				return cardLevel;
			}
			
			public void setCardLevel(PassagerCardLevel cardLevel) {
				this.cardLevel = cardLevel;
			}
			
			public Integer getCost() {
				return cost;
			}
			
			public void setCost(Integer cost) {
				this.cost = cost;
			}
			
			
		}
		
	}

	public  abstract Load getLoad();
}
