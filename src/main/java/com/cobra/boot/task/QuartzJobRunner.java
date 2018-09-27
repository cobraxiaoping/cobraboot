package com.cobra.boot.task;

import java.util.List;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.cobra.boot.entity.QuartzJob;
import com.cobra.boot.services.QuartzJobService;

/**
 * @author cobra
 * 项目启动执行定时任务的调度
 */
@Component
public class QuartzJobRunner implements ApplicationRunner {

	private Logger log = LoggerFactory.getLogger(QuartzJobRunner.class);

	@Autowired
	private QuartzJobService quartzJobService;
	
	@Autowired
	private QuartzJobManager quartzJobManager;

	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		log.info("**********初始化加载定时任务开始**********");
		List<QuartzJob> jobList = quartzJobService.findQuartzJobByStatus(QuartzJob.STATUS_RUNNING);
		jobList.forEach((job)->{
			try {
				quartzJobManager.addJob(job.getJobName(), job.getJobGroup(), job.getJobName(), job.getJobGroup(), job.getJobClass(), job.getCronExpression());
			} catch (SchedulerException e) {
				e.printStackTrace();
				log.info("**********初始化加载定时任务异常**********");
			}
		});
		log.info("**********初始化加载定时任务结束**********");
	}
}
