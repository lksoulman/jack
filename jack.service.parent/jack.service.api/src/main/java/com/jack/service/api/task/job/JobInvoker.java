package com.jack.service.api.task.job;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/**
 * 
 * @ClassName: JobInvoker
 * @Description:
 * @author lksoulman
 * @date 2018-06-14 15:09:18
 */
public class JobInvoker implements Serializable {

	/**
	 * @Fields serialVersionUID :
	 * @author lksoulman
	 */
	private static final long serialVersionUID = 4099229186114411228L;
	private String className;
	private String method;
	private Map<String, Object> paramMap;
	private boolean concurrent = false;

	/**
	 * @throws LinkageError
	 * @throws ClassNotFoundException
	 * 
	 */
	public JobInvoker(String className, String method, Map<String, Object> paramMap)
			throws ClassNotFoundException, LinkageError {
		this.method = method;
		this.className = className;
		this.paramMap = paramMap;
	}

	public JobInvoker(String className, String method, Object value) throws ClassNotFoundException, LinkageError {
		this.method = method;
		this.className = className;
		this.paramMap = new HashMap<>();
		paramMap.put("SITEID", value);
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Map<String, Object> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}

	public boolean isConcurrent() {
		return concurrent;
	}

	public void setConcurrent(boolean concurrent) {
		this.concurrent = concurrent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return className + ":" + method + ":" + paramMap;
	}
}
