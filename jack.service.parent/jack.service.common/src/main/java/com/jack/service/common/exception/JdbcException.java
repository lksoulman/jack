package com.jack.service.common.exception;

import java.io.Serializable;

/**
 * 
 * @ClassName: JdbcException 
 * @Description: JdbcException 
 * @author lksoulman  
 * @date 2018年5月22日 下午4:08:24
 */
public class JdbcException extends RuntimeException implements Serializable {

  /** 
   * @Fields serialVersionUID : 序列化 
   */ 
  private static final long serialVersionUID = 1L;

  private Throwable cause;  
  
  public JdbcException(String message) {
		super(message);
	}
	
	public JdbcException(String message,Throwable cause) {
		super(message);
		this.cause = cause;
	}
	
	public JdbcException(Throwable cause) {
		super(cause.getMessage());
		this.cause = cause;
	}

	public Throwable getCause() {
		return this.cause;
	}
}
