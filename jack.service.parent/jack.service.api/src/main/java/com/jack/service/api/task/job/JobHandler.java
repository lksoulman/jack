package com.jack.service.api.task.job;

import java.util.Map;

import com.jack.service.api.exception.JobException;

/**
 * 
 * @ClassName: JobHandler
 * @Description:
 * @author lksoulman
 * @date 2018-06-14 15:08:58
 */
public interface JobHandler {

	/**
	 * 
	 * @Description:
	 * @param paramMap
	 * @throws JobException
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-14 15:14:25
	 */
	void execute(Map<String, Object> paramMap) throws JobException;
}
