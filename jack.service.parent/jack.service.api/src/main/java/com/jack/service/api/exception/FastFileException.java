package com.jack.service.api.exception;

import java.io.Serializable;

/**
 * 
 * @ClassName: FastFileException
 * @Description:
 * @author lksoulman
 * @date 2018-06-14 17:44:09
 */
public class FastFileException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	private Throwable cause;

	/**
	 * 
	 */
	public FastFileException() {
		super();
	}

	/**
	 * 
	 * @param cause
	 */
	public FastFileException(Throwable cause) {
		super(cause);
		this.cause = cause;
	}
	
	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public FastFileException(String message,Throwable cause) {
		super(message);
		this.cause = cause;
	}
}
