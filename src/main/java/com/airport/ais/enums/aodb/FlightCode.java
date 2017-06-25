//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.8-b130911.1802 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2017.06.01 ʱ�� 09:59:39 PM CST 
//


package com.airport.ais.enums.aodb;


/**
 * FileName      FlightCancelCode.java
 * @Description  TODO ������� �����ڱ�ʶ����(ȡ�������������󣬵�״̬)
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��17��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��17��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
public enum FlightCode {
	/**
	 *  ����ȡ��
	 */
    C,
    /**
     *  ���౸��
     */
    A,
    /**
     *  ��������
     */
    D,
    /**
     *  ��������
     */
    N;

    public String value() {
        return name();
    }

    public static FlightCode fromValue(String v) {
        return valueOf(v);
    }

}
