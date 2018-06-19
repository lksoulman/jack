package com.jack.service.task.listener;

import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.spi.MutableTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName: TaskSchedulerListener
 * @Description:
 * @author lksoulman
 * @date 2018-06-07 14:27:32
 */
public class TaskSchedulerListener implements SchedulerListener {

	private static final Logger logger = LoggerFactory.getLogger(TaskSchedulerListener.class);

	@Override
	public void jobScheduled(Trigger trigger) {

	}

	@Override
	public void jobUnscheduled(TriggerKey triggerKey) {

	}

	@Override
	public void triggerFinalized(Trigger trigger) {

	}

	@Override
	public void triggerPaused(TriggerKey triggerKey) {

	}

	@Override
	public void triggersPaused(String triggerGroup) {

	}

	@Override
	public void triggerResumed(TriggerKey triggerKey) {

	}

	@Override
	public void triggersResumed(String triggerGroup) {

	}

	@Override
	public void jobAdded(JobDetail jobDetail) {

	}

	@Override
	public void jobDeleted(JobKey jobKey) {

	}

	@Override
	public void jobPaused(JobKey jobKey) {

	}

	@Override
	public void jobsPaused(String jobGroup) {

	}

	@Override
	public void jobResumed(JobKey jobKey) {

	}

	@Override
	public void jobsResumed(String jobGroup) {

	}

	/**
	 * @param msg
	 * @param cause
	 * @datetime 2017年1月9日-下午2:29:57
	 * @desc 在 Scheduler 的正常运行期间产生一个严重错误时调用这个方法。错误的类型会各式的，但是下面列举了一些错误例子： ·初始化 Job
	 *       类的问题 ·试图去找到下一 Trigger 的问题 ·JobStore 中重复的问题 ·数据存储连接的问题 你可以使用
	 *       SchedulerException 的 getErrorCode() 或者 getUnderlyingException()
	 *       方法或获取到特定错误的更详尽的信息。
	 */
	@Override
	public void schedulerError(String msg, SchedulerException cause) {
		logger.error("调度执行异常:" + msg, cause);
	}

	@Override
	public void schedulerInStandbyMode() {

	}

	@Override
	public void schedulerStarted() {

	}

	@Override
	public void schedulerStarting() {

	}

	@Override
	public void schedulerShutdown() {

	}

	@Override
	public void schedulerShuttingdown() {

	}

	@Override
	public void schedulingDataCleared() {

	}
}
