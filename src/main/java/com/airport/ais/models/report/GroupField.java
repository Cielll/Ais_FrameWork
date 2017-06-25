package com.airport.ais.models.report;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Transient;

import com.airport.ais.enums.QueryGroupDate;

/**
 * 
 * FileName      GroupField.java
 * @Description  TODO 分组字段，用于报表字段的行，进行GroupBy的统计，表达式的参数只允许一个字段
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月22日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 * 
 */

@Entity
@DiscriminatorValue(value = "groupField")
public class GroupField extends ReportField {

	
	private static final long serialVersionUID = 1L;

	public static String EXPRESSION     = "expression";
	public static String QUERYGROUPDATE = "queryGroupDate";
	
	/**
	 * 表达式
	 */
	@Transient
	private Object expression;
	
	
	/**
	 * 日期类型
	 */
	@Column(length=10)
	@Enumerated(EnumType.STRING)
	private QueryGroupDate queryGroupDate;


	/**
	 * @return the expression
	 */
	public Object getExpression() {
		return expression;
	}


	/**
	 * @param expression the expression to set
	 */
	public void setExpression(Object expression) {
		this.expression = expression;
	}


	/**
	 * @return the queryGroupDate
	 */
	public QueryGroupDate getQueryGroupDate() {
		return queryGroupDate;
	}


	/**
	 * @param queryGroupDate the queryGroupDate to set
	 */
	public void setQueryGroupDate(QueryGroupDate queryGroupDate) {
		this.queryGroupDate = queryGroupDate;
	}




}
