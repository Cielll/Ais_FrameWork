package com.airport.ais.enums.aodb;

/**
 * 
 * 
 * FileName      FlightTransitCode.java
 * @Description  TODO 飞机的 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月12日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月12日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */



public enum FlightTransitCode {
	/**
	 * 技术性经停
	 */
    T,
    /**
     * 一般经停
     */
    Y;

    public String value() {
        return name();
    }

    public static FlightTransitCode fromValue(String v) {
        return valueOf(v);
    }

}