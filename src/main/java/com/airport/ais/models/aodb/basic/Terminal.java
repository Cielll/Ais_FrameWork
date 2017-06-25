package com.airport.ais.models.aodb.basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.airport.ais.models.IntIdEntity;


/**
 * 
 * 
 * FileName      Terminal.java
 * @Description  TODO 航站楼的实体类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月13日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月13日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
@Entity
@Table(name="Terminal")
public class Terminal extends IntIdEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String TERMINALCODE = "terminalCode";
	public static final String DESCRIPTION  = "description";
	public static final String AIRPORT      = "Airport";
	
	/**
	 * 航站楼编码
	 */
	@Column(length=4)
	private String terminalCode;
	/**
	 * 描述
	 */
	@Column(length=64)
	private String description;
	/**
	 * 所属机场
	 */
	@ManyToOne
	private Airport airport;
	
	public String getTerminalCode() {
		return terminalCode;
	}
	
	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Airport getAirport() {
		return airport;
	}
	
	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	

}
