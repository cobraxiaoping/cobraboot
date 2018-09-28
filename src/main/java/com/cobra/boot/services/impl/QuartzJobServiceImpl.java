package com.cobra.boot.services.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.cobra.boot.entity.QuartzJob;
import com.cobra.boot.repository.QuartzJobRepository;
import com.cobra.boot.services.QuartzJobService;
import com.cobra.boot.task.QuartzJobManager;
import com.cobra.boot.utils.DateUtils;


/**  
 * @ClassName: QuartzJobServiceImpl  
 * @Description: job操作实现类  
 * @author: cobra  
 * @date: 2018年9月28日  
 * @version: v1.0
 */  
@Service
public class QuartzJobServiceImpl implements QuartzJobService {

	@Autowired
	private QuartzJobRepository quartzJobRepository;

	@Autowired
	private QuartzJobManager quartzJobManager;

	@Transactional(rollbackOn = Exception.class)
	@Override
	public QuartzJob createQuartzJob(QuartzJob job) {
		QuartzJob quartzJob = quartzJobRepository.save(job);
		if (!StringUtils.isEmpty(quartzJob)) {
			try {
				Date startTime = quartzJobManager.addJob(quartzJob);
				quartzJob.setStartTime(DateUtils.formateDate(startTime, DateUtils.YMD_HMS));
				quartzJobRepository.save(quartzJob);
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		return quartzJob;
	}

	@Transactional(rollbackOn = Exception.class)
	@Override
	public QuartzJob modifyQuartzJob(QuartzJob quartzJob) {
		QuartzJob job = quartzJobRepository.findById(quartzJob.getJobId()).orElse(null);
		if (!StringUtils.isEmpty(job)) {
			job = quartzJobRepository.save(quartzJob);
			try {
				quartzJobManager.modifyJob(job);
			} catch (SchedulerException e) {
				e.printStackTrace();
			}
		}
		return quartzJob;
	}

	@Override
	public void pauseAllQuartzJob() {
		try {
			quartzJobManager.pauseAllJob();
			List<QuartzJob> quartzJob = quartzJobRepository.findAll();
			quartzJob.forEach((job)->{
				job.setJobStatus(QuartzJob.STATUS_NOT_RUNNING);
				quartzJobRepository.save(job);
			});
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Transactional(rollbackOn = Exception.class)
	@Override
	public void pauseQuartzJob(QuartzJob quartzJob) {
		try {
			QuartzJob job = quartzJobRepository.findById(quartzJob.getJobId()).orElse(null);
			if(!StringUtils.isEmpty(job)) {
				quartzJobManager.pauseJob(job);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void resumeAllQuartzJob() {
		try {
			quartzJobManager.resumeAllJob();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	/* (非 Javadoc)  
	 * @param quartzJob  
	 * @see com.cobra.boot.services.QuartzJobService#resumeQuartzJob(com.cobra.boot.entity.QuartzJob)  
	 */
	@Override
	public void resumeQuartzJob(QuartzJob quartzJob) {
		try {
			QuartzJob job = quartzJobRepository.findById(quartzJob.getJobId()).orElse(null);
			if(!StringUtils.isEmpty(job)) {
				quartzJobManager.resumeJob(job);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Transactional(rollbackOn = Exception.class)
	@Override
	public void deleteQuartzJob(QuartzJob quartzJob) {
		try {
			QuartzJob job = quartzJobRepository.findById(quartzJob.getJobId()).orElse(null);
			if (!StringUtils.isEmpty(job)) {
				quartzJobManager.deleteJob(job);
				quartzJobRepository.delete(job);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}

	@Override
	public QuartzJob findQuartzJobById(Integer jodId) {
		QuartzJob quartzJob = quartzJobRepository.findById(jodId).orElse(null);
		return quartzJob;
	}

	@Override
	public List<QuartzJob> findQuartzJobByStatus(String jobStatus) {
		QuartzJob jobFilter = new QuartzJob();
		jobFilter.setJobStatus(jobStatus);
		List<QuartzJob> quartzJobList = new QuartzJobRepository.Executor(quartzJobRepository).findAll(jobFilter);
		return quartzJobList;
	}

}
