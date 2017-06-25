package com.airport.ais.enums.aodb;


/**
 * FileName      SectorCode.java
 * @Description  TODO 领域代码
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月12日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月12日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public enum SectorCode {
	/**
	 *   国内
	 */
    D,
    /**
     *   国际
     */
    I,
    /**
     *   混合
     */
    M,
    /**
     *   地区
     */
    R;
    public String value() {
        return name();
    }

    public static SectorCode fromValue(String v) {
        return valueOf(v);
    }
}