package com.airport.ais.models.report;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * 
 * FileName      CumulativeColumnField.java
 * @Description  TODO 用于累计计算的列字段 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月22日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@Entity
@DiscriminatorValue(value = "cumulativeField")
public class CumulativeColumnField extends ColumnField {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 需要对什么数据进行累计
	 */
	@Transient
	private AggregationColumnField aggregationColumnField;
	
	
	/**
	 * 限定的年份
	 */
	private String year;
	
	/**
	 * 是否需要进行比较
	 */
	private boolean compare;

	/**
	 * 进行年或者是月的比较的标识
	 */
	private String flag;

	/**
	 * @return the aggregationColumnField
	 */
	public AggregationColumnField getAggregationColumnField() {
		return aggregationColumnField;
	}

	/**
	 * @param aggregationColumnField the aggregationColumnField to set
	 */
	public void setAggregationColumnField(AggregationColumnField aggregationColumnField) {
		this.aggregationColumnField = aggregationColumnField;
	}

	/**
	 * @return the compare
	 */
	public Boolean getCompare() {
		return compare;
	}

	/**
	 * @param compare the compare to set
	 */
	public void setCompare(Boolean compare) {
		this.compare = compare;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	
	

}
