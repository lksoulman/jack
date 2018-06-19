package com.jack.service.task.factory;

import org.springframework.scheduling.SchedulingException;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 
 * @ClassName: TaskFactory
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:26:11
 */
public class TaskFactory extends SchedulerFactoryBean {

	@Override
	public void start() throws SchedulingException {

		super.start();
	}
}
