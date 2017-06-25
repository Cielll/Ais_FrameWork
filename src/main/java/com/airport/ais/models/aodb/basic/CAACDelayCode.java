package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;


/**
 * 
 * 
 * FileName      CAACDelayCode.java
 * @Description  TODO ������� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��13��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��13��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Entity
@Table(name="CAACDelayCode")
public class CAACDelayCode extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * ���������ֶ���,�������õ����ֶ���
	 */	
	public static final String  DELAYCODE            = "delayCode";
	public static final String  ENGLISHDESCRIPTION   = "englishDescription";
	public static final String  CHINESEDESCRIPTION   = "chineseDescription";
	
	/**
	 * �������
	 */
	@Column(length=4)
	private String delayCode;
	/**
	 *  Ӣ������
	 */
	@Column(length=128)
	private String englishDescription;
	/**
	 * ��������
	 */
	@Column(length=128)
	private String chineseDescription;
	
	public String getDelayCode() {
		return delayCode;
	}
	
	public void setDelayCode(String delayCode) {
		this.delayCode = delayCode;
	}
	
	public String getEnglishDescription() {
		return englishDescription;
	}
	
	public void setEnglishDescription(String englishDescription) {
		this.englishDescription = englishDescription;
	}
	
	public String getChineseDescription() {
		return chineseDescription;
	}
	
	public void setChineseDescription(String chineseDescription) {
		this.chineseDescription = chineseDescription;
	}
	
	
	

}
