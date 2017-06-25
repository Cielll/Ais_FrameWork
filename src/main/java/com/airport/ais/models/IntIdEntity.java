package com.airport.ais.models;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


/**
 * FileName      IntIdEntity.java
 * @Description  TODO I id为整型实体类父类 
 * @author       ZhangYu    Company:    LZAirport
 * @version      V0.9a CreateDate: 2017年6月11日
 * @ModificationHistory
 * Date         Author     Version   Description
 * <p>---------------------------------------------
 * <p>2017年6月11日      ZhangYu    1.0        1.0
 * <p>Why & What is modified: <修改原因描述>
 */

@SuppressWarnings("serial")
@MappedSuperclass
public abstract class IntIdEntity extends DefaultEntity  implements Serializable {
	
	public static String ID           = "id";
	
	/**
	 * 主键
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	@Override
	public Object getId() {
		return this.id;
	}

	@Override
	public void setId(Object id) {
		this.id = (int) id;
	}

}
