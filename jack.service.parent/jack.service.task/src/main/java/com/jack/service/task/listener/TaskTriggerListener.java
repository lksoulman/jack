package com.jack.service.task.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.stat.TableStat.Name;

/**
 * 
 * @ClassName: TaskTriggerListener
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:27:44
 */
public class TaskTriggerListener implements TriggerListener {

	private static final Logger logger = LoggerFactory.getLogger(TaskTriggerListener.class);

	private String name = "TaskTriggerListener";

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void triggerFired(Trigger trigger, JobExecutionContext context) {

	}

	@Override
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
		return false;
	}

	@Override
	public void triggerMisfired(Trigger trigger) {
		logger.warn(trigger.getKey().getName() + "执行超时:" + trigger.toString());
	}

	@Override
	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			CompletedExecutionInstruction triggerInstructionCode) {
		logger.warn(trigger.getKey().getName() + ":执行完成");
	}
}
