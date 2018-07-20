package com.jack.service.common.exception;

import java.io.Serializable;

/**
 * 
 * @ClassName: CacheException
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:09:47
 */
public class CacheException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	private Throwable cause;

	/**
	 * 
	 */
	public CacheException() {
		super();
	}

	/**
	 * 
	 * @param cause
	 */
	public CacheException(Throwable cause) {
		super(cause);
		this.cause = cause;
	}
	
	public Throwable getCause() {
		return cause;
	}
}
