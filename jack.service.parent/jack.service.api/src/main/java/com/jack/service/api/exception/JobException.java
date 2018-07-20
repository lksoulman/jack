package com.jack.service.api.exception;

import java.io.Serializable;

/**
 * 
 * @ClassName: TaskException 
 * @Description:  
 * @author lksoulman 
 * @date 2018-06-14 15:12:02
 */
public class JobException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	private Throwable cause;

	/**
	 * 
	 */
	public JobException() {
		super();
	}

	/**
	 * 
	 * @param cause
	 */
	public JobException(Throwable cause) {
		super(cause);
		this.cause = cause;
	}
	
	/**
	 * 
	 * @Description: 
	 * @return 
	 * @return Throwable
	 * @author lksoulman
	 * @date 2018-06-27 09:43:14
	 */
	public Throwable getThrowable() {
		return cause; 
	}
}