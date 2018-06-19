package com.jack.service.api.task;

import org.quartz.CronExpression;

import com.jack.service.api.task.job.JobInvoker;

/**
 * 
 * @ClassName: TaskService
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:11:39
 */
public interface TaskServiceApi {

	/**
	 * 
	 * @Description:
	 * @param name
	 * @param group
	 * @param cronExpression
	 * @param jobInvoker
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-14 15:21:33
	 */
	void schedule(String name, String group, String cronExpression, JobInvoker jobInvoker);

	/**
	 * 
	 * @Description:
	 * @param name
	 * @param group
	 * @param cronExpression
	 * @param jobInvoker
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-14 15:21:46
	 */
	void schedule(String name, String group, CronExpression cronExpression, JobInvoker jobInvoker);

	/**
	 * 
	 * @Description:
	 * @param triggerName
	 * @param group
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-14 16:07:30
	 */
	void pauseTrigger(String triggerName, String group);

	/**
	 * 
	 * @Description:
	 * @param triggerName
	 * @param group
	 * @return void
	 * @author lksoulman
	 * @date 2018-06-14 16:07:38
	 */
	void resumeTrigger(String triggerName, String group);

	/**
	 * 
	 * @Description:
	 * @param triggerName
	 * @param group
	 * @return
	 * @return boolean
	 * @author lksoulman
	 * @date 2018-06-14 16:07:49
	 */
	boolean removeTrigdger(String triggerName, String group);

	/**
	 * 
	 * @Description:
	 * @param test
	 * @return String
	 * @author lksoulman
	 * @date 2018-06-14 13:43:41
	 */
	String testApi(String test);
}
