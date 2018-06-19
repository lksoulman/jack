package com.jack.service.task.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.listeners.JobListenerSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: TaskJobListener
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:27:25
 */
public class TaskJobListener extends JobListenerSupport {

	private static final Logger logger = LoggerFactory.getLogger(TaskSchedulerListener.class);

	private String name;

	public TaskJobListener(String name) {
		this.name = name;
	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		super.jobToBeExecuted(context);
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		super.jobExecutionVetoed(context);
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		if (jobException != null) {
			logger.error("Job执行异常", jobException);
		}
	}

}
