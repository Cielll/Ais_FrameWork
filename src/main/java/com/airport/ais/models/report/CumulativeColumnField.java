package com.airport.ais.models.report;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * 
 * FileName      CumulativeColumnField.java
 * @Description  TODO �����ۼƼ�������ֶ� 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017��6��22��
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017��6��22��      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <�޸�ԭ������>
 */

@Entity
@DiscriminatorValue(value = "cumulativeField")
public class CumulativeColumnField extends ColumnField {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ��Ҫ��ʲô���ݽ����ۼ�
	 */
	@Transient
	private AggregationColumnField aggregationColumnField;
	
	
	/**
	 * �޶������
	 */
	private String year;
	
	/**
	 * �Ƿ���Ҫ���бȽ�
	 */
	private boolean compare;

	/**
	 * ������������µıȽϵı�ʶ
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
