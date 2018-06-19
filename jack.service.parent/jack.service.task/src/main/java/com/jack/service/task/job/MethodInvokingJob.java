package com.jack.service.task.job;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.MapUtils;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.jack.service.api.task.job.JobHandler;
import com.jack.service.api.task.job.JobInvoker;

/**
 * 
 * @ClassName: MethodInvokingJob
 * @Description:
 * @author lksoulman
 * @date 2018-06-14 15:30:23
 */
public class MethodInvokingJob extends QuartzJobBean {

	private static final String JOBINVOKER = "jobInvoker";
	private static final String APPLICATION_CONTEXT_KEY = "springContextKey";

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jdm = context.getJobDetail().getJobDataMap();
		JobInvoker jobInvoker = (JobInvoker) jdm.get(JOBINVOKER);
		try {
			String className = jobInvoker.getClassName();
			String serverName = className.substring(className.lastIndexOf(".") + 1);
			JobHandler jobHandler = getBean(context, serverName);
			// String jobDetailName = context.getJobDetail().getKey().getName();
			Map<String, Object> map = jobInvoker.getParamMap();
			if (MapUtils.isEmpty(map)) {
				map = new HashMap<>();
			}
			String taskId = MapUtils.getString(map, "SITEID", "0");
			// Log logg = Log.build(taskId, jobDetailName);
			// log.info(logg.setType(LogType.QUARTZ).setMessage("调度任务执行:" +
			// jobDetailName).toString());
			// map.put("log", logg);
			jobHandler.execute(map);
		} catch (Exception ex) {
			// log.error(Log.build().setType(LogType.QUARTZ)
			// .setMessage(jobInvoker.getParaMap() + "-" + jobInvoker.getClassName() +
			// ":执行异常", ex).toString());
			// ture为调度重试、false不重试
			throw new JobExecutionException(ex, false);
		}
	}

	/**
	 * 
	 * @Description:
	 * @param context
	 * @throws Exception
	 * @return ApplicationContext
	 * @author lksoulman
	 * @date 2018-06-14 15:40:41
	 */
	private ApplicationContext getSpringApp(JobExecutionContext context) throws Exception {
		ApplicationContext applicationContext = (ApplicationContext) context.getScheduler().getContext()
				.get(APPLICATION_CONTEXT_KEY);
		if (applicationContext == null) {
			throw new JobExecutionException("No application context available in scheduler context for key \""
					+ APPLICATION_CONTEXT_KEY + "\"");
		}
		return applicationContext;
	}

	/**
	 * 
	 * @Description:
	 * @param context
	 * @param name
	 * @throws Exception
	 * @return JobHandler
	 * @author lksoulman
	 * @date 2018-06-14 15:40:46
	 */
	private JobHandler getBean(JobExecutionContext context, String name) throws Exception {
		return getSpringApp(context).getBean(name, JobHandler.class);
	}
}
