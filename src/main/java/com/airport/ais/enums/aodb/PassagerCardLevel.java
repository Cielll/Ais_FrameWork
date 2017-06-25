package com.airport.ais.enums.aodb;

/**
 * 
 * 
 * FileName      PassagerCardLevel.java
 * @Description  TODO  常旅客卡等级
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月18日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月18日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
public enum PassagerCardLevel {
	/**
	 * 金卡
	 */
	GOLD("Gold"),
	/**
	 * 银卡
	 */
	SILVER("Silver"),
	/**
	 * 头等舱
	 */
	FIRSTCLASS("FirstClass");
	
	private final String value;
	
	PassagerCardLevel(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PassagerCardLevel fromValue(String v) {
        for (PassagerCardLevel c: PassagerCardLevel.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
