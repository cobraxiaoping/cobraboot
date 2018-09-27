package com.cobra.boot.services;

import java.util.List;


import com.cobra.boot.entity.QuartzJob;

/**
 * @author cobra
 *
 */
public interface QuartzJobService {

	/**
	 * 创建job
	 * 
	 * @return
	 */
	public QuartzJob createQuartzJob(QuartzJob job);

	/**
	 * @param job
	 * @return
	 */
	public QuartzJob updateQuartzJob(QuartzJob job);

	/**
	 * 查询job
	 * 
	 * @param jodid
	 * @return
	 */
	public QuartzJob findQuartzJobById(Integer jodId);

	/**
	 * @param jobstatus
	 * @return
	 */
	public List<QuartzJob> findQuartzJobByStatus(String jobStatus);

}
