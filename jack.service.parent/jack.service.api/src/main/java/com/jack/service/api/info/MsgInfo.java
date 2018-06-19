package com.jack.service.api.info;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @ClassName: DataInfo
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:08:42
 */
@Data
public class MsgInfo implements Serializable {

	
	/** 
	 * @Fields serialVersionUID : 
	 * @author lksoulman
	 */ 
	
	private static final long serialVersionUID = 4137884435933573994L;

	/**
	 * code
	 */
	private int code;

	/**
	 * message
	 */
	private String message;

	/**
	 * data
	 */
	private Object data;
}
