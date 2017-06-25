package com.airport.ais.enums.aodb;


/**
 * FileName      SectorCode.java
 * @Description  TODO �������
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��12��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��12��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

public enum SectorCode {
	/**
	 *   ����
	 */
    D,
    /**
     *   ����
     */
    I,
    /**
     *   ���
     */
    M,
    /**
     *   ����
     */
    R;
    public String value() {
        return name();
    }

    public static SectorCode fromValue(String v) {
        return valueOf(v);
    }
}