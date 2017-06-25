package com.airport.ais.models.aodb.basic;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;

/**
 * 
 * 
 * FileName      Route.java
 * @Description  TODO 航线 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月17日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月17日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
@Table(name="FlightRoute")
public class FlightRoute extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
