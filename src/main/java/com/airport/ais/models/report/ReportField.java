package com.airport.ais.models.report;

import java.io.Serializable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import com.airport.ais.models.IntIdEntity;


/**
 * 
 * 
 * FileName      ReportField.java
 * @Description  TODO����ͳ�Ʒ��鱨���ֶεĻ��� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��22��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��22��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */
@Entity
@SuppressWarnings("serial")
@Table(name="ReportField")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="fieldType",discriminatorType=DiscriminatorType.STRING,length=10)
public class ReportField  extends  IntIdEntity implements  Serializable {


	public static String EXPRESSIONSTRING  = "expressionString";
	public static String ALIAS             = "alias";
		
	/**
	 *  ���ʽ���ַ���
	 */
	protected String expressionString;

	/**
	 *  ����
	 */
	protected String alias;

	/**
	 * @return the expressionString
	 */
	public String getExpressionString() {
		return expressionString;
	}

	/**
	 * @param expressionString the expressionString to set
	 */
	public void setExpressionString(String expressionString) {
		this.expressionString = expressionString;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
}
