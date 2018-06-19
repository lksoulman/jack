package com.jack.service.common.exception;

/**
 * 
 * @ClassName: SqlConfigException
 * @Description:
 * @author lksoulman
 * @date 2018-06-08 10:50:30
 */
public class SqlConfigException extends RuntimeException {

	/**
	 * @Fields serialVersionUID :
	 * @author lksoulman
	 */
	private static final long serialVersionUID = 1568715345542393612L;

	public SqlConfigException() {
		super();
	}

	public SqlConfigException(String msg) {
		super(msg);
	}

	public SqlConfigException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
