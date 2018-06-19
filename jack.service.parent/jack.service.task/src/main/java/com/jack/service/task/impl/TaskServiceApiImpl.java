package com.jack.service.task.impl;

import java.text.ParseException;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.collections4.MapUtils;
import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jack.service.api.task.TaskServiceApi;
import com.jack.service.api.task.job.JobInvoker;
import com.jack.service.task.job.MethodInvokingJob;
import com.jack.service.task.job.StatefulMethodInvokingJob;
import com.jack.service.task.listener.TaskSchedulerListener;

/**
 * 
 * @ClassName: TaskServiceImpl
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:27:16
 */
@Service
public class TaskServiceApiImpl implements TaskServiceApi {

	private static final Logger logger = LoggerFactory.getLogger(TaskServiceApiImpl.class);

	@Autowired
	private Scheduler schedulerFactory;

	@Override
	public void schedule(String name, String group, String cronExpression, JobInvoker jobInvoker) {
		try {
			schedule(name, group, new CronExpression(cronExpression), jobInvoker);
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error(e.getMessage() + " " + cronExpression);
		}
	}

	@Override
	public void schedule(String name, String group, CronExpression cronExpression, JobInvoker jobInvoker) {
		if (name == null || name.trim().equals(""))
			name = UUID.randomUUID().toString();

		Class<? extends Job> jobClass = (jobInvoker.isConcurrent() ? MethodInvokingJob.class
				: StatefulMethodInvokingJob.class);
		JobDetailImpl jobDetailImpl = new JobDetailImpl();
		jobDetailImpl.setName(name);
		jobDetailImpl.setDurability(true);
		jobDetailImpl.setRequestsRecovery(true);
		jobDetailImpl.setJobClass(jobClass);
		jobDetailImpl.getJobDataMap().put("jobInvoker", jobInvoker);
		CronTriggerImpl trigger = new CronTriggerImpl();
		trigger.setCronExpression(cronExpression);
		TriggerKey triggerKey = new TriggerKey(name, group);
		trigger.setJobName(jobDetailImpl.getKey().getName());
		trigger.setKey(triggerKey);

		// 立即执行第一次misfire的操作，并且放弃其他misfire的（类似所有misfire的操作被合并执行了）。
		// 然后继续按调度执行。无论misfire多少次trigger的执行，都只会立刻执行1次。
		trigger.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_FIRE_ONCE_NOW);
		Map<String, Object> paraMap = jobInvoker.getParamMap();
		if (!MapUtils.isEmpty(paraMap)) {
			trigger.getJobDataMap().putAll(paraMap);
			String desc = MapUtils.getString(paraMap, "DESC", null);
			trigger.setDescription(desc);
		}

		try {
			schedulerFactory.getListenerManager().addSchedulerListener(new TaskSchedulerListener());
			schedulerFactory.addJob(jobDetailImpl, true);
			if (schedulerFactory.checkExists(triggerKey)) {
				schedulerFactory.rescheduleJob(triggerKey, trigger);
			} else {
				schedulerFactory.scheduleJob(trigger);
			}
		} catch (SchedulerException e) {
			throw new IllegalArgumentException(e);
		}
	}

	@Override
	public void pauseTrigger(String triggerName, String group) {
		try {
			schedulerFactory.pauseTrigger(new TriggerKey(triggerName, group));
		} catch (SchedulerException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public void resumeTrigger(String triggerName, String group) {
		TriggerKey triggerKey = new TriggerKey(triggerName, group);
		try {
			schedulerFactory.resumeTrigger(triggerKey);
		} catch (SchedulerException e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public boolean removeTrigdger(String triggerName, String group) {
		TriggerKey triggerKey = new TriggerKey(triggerName, group);
		try {
			schedulerFactory.pauseTrigger(triggerKey);// 停止触发器
			return schedulerFactory.unscheduleJob(triggerKey);// 移除触发器
		} catch (SchedulerException e) {
			throw new RuntimeException(e);
		}
	}

	public String testApi(String test) {
		return test;
	}
}
