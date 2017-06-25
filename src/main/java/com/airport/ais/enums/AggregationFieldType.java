package com.airport.ais.enums;

/**
 * 
 * FileName      AggregationFieldType.java
 * @Description  TODO 聚合字段枚举类型
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月22日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */


public enum AggregationFieldType {
	Sum,
	Avg,
	Count,
	None;
	
    public String value() {
        return name();
    }

    public static  AggregationFieldType fromValue(String v) {
        return valueOf(v);
    }
}
