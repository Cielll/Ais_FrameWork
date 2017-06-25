//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2017.06.01 时间 09:59:39 PM CST 
//


package com.airport.ais.enums.aodb;

import javax.xml.bind.annotation.XmlEnumValue;



/**
 * 
 * 
 * FileName      BaggageReclaimCarouselRole.java
 * @Description  TODO  行李转盘规则
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月17日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月17日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
public enum BaggageReclaimCarouselRole {

    @XmlEnumValue("Primary")
    PRIMARY("Primary"),
    @XmlEnumValue("Secondary")
    SECONDARY("Secondary");
    private final String value;

    BaggageReclaimCarouselRole(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static BaggageReclaimCarouselRole fromValue(String v) {
        for (BaggageReclaimCarouselRole c: BaggageReclaimCarouselRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
