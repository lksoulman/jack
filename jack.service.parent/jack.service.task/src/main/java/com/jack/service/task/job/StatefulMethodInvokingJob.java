package com.jack.service.task.job;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.PersistJobDataAfterExecution;

/**
 * 
 * @ClassName: StatefulMethodInvokingJob
 * @Description:
 * @author lksoulman
 * @date 2018-06-14 15:57:24
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class StatefulMethodInvokingJob extends MethodInvokingJob {

}
