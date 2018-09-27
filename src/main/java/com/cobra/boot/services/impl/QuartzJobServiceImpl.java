package com.cobra.boot.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cobra.boot.entity.QuartzJob;
import com.cobra.boot.repository.QuartzJobRepository;
import com.cobra.boot.services.QuartzJobService;

/**
 * @author cobra
 *
 */
@Service
public class QuartzJobServiceImpl implements QuartzJobService {

	@Autowired
	private QuartzJobRepository jobRepository;

	@Transactional(rollbackOn = Exception.class)
	@Override
	public QuartzJob createQuartzJob(QuartzJob job) {
		QuartzJob quartzJob = jobRepository.save(job);
		return quartzJob;
	}

	@Transactional(rollbackOn = Exception.class)
	@Override
	public QuartzJob updateQuartzJob(QuartzJob job) {
		QuartzJob quartzJob = jobRepository.save(job);
		return quartzJob;
	}

	@Override
	public QuartzJob findQuartzJobById(Integer jodId) {
		QuartzJob quartzJob = jobRepository.findById(jodId).orElse(null);
		return quartzJob;
	}

	@Override
	public List<QuartzJob> findQuartzJobByStatus(String jobStatus) {
		QuartzJob jobFilter = new QuartzJob();
		jobFilter.setJobStatus(jobStatus);
		List<QuartzJob> quartzJobList = new QuartzJobRepository.Executor(jobRepository).findAll(jobFilter);
		return quartzJobList;
	}
}
