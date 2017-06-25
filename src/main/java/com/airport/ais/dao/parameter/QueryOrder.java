package com.airport.ais.dao.parameter;

import java.io.Serializable;

import com.airport.ais.enums.QuerySortMode;

/**
 * 
 * 
 * FileName      AisOrder.java
 * @Description  TODO 排序类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月22日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月22日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

public class QueryOrder implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 字段名
	 */
	private String name;
	
	/**
	 * 排序类型
	 */
	private QuerySortMode querySortMode;
	

	public String getName() {
		return name;
	}
	

	public void setName(String name) {
		this.name = name;
	}
	

	public QuerySortMode getQuerySortMode() {
		return querySortMode;
	}
	

	public void setQuerySortMode(QuerySortMode querySortMode) {
		this.querySortMode = querySortMode;
	}
	

	
	

}
