package com.airport.ais.enums.aodb;


/**
 * 
 * 
 * FileName      ResourceStatus.java
 * @Description  TODO 资源状态
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月14日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月14日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */
public enum ResourceStatusCode {
		/**
		 * 打开
		 */
	 	O,
	 	/**
	 	 * 关闭
	 	 */
	    C,
	    /**
	     * 维护
	     */
	    S,
	    /**
	     * 不可用
	     */
	    U;

	    public String value() {
	        return name();
	    }

	    public static ResourceStatusCode fromValue(String v) {
	        return valueOf(v);
	    }

}
