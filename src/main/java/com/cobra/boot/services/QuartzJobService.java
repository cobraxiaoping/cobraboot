package com.cobra.boot.services;

import java.util.List;

import com.cobra.boot.entity.QuartzJob;

/**
 * @author cobra
 *
 */
public interface QuartzJobService {

	/**  
	 * @Method: createQuartzJob  
	 * @Description: 创建job
	 * @param: @param job
	 * @param: @return
	 * @return: QuartzJob
	 * @throws  
	 */  
	public QuartzJob createQuartzJob(QuartzJob job);

	
	/**  
	 * @Method: modifyQuartzJob  
	 * @Description: 修改job
	 * @param: @param job
	 * @param: @return
	 * @return: QuartzJob
	 * @throws  
	 */  
	public QuartzJob modifyQuartzJob(QuartzJob job);

	
	/**  
	 * @Method: pauseAllQuartzJob  
	 * @Description: 暂停所有job
	 * @param: 
	 * @return: void
	 * @throws  
	 */  
	public void pauseAllQuartzJob();


	/**  
	 * @Method: pauseQuartzJob  
	 * @Description: 暂停某个job
	 * @param: @param quartzJob
	 * @return: void
	 * @throws  
	 */  
	public void pauseQuartzJob(QuartzJob quartzJob);

	
	/**  
	 * @Method: resumeAllQuartzJob  
	 * @Description: 恢复所有job
	 * @param: 
	 * @return: void
	 * @throws  
	 */  
	public void resumeAllQuartzJob();

	
	/**  
	 * @Method: resumeQuartzJob  
	 * @Description: 恢复某个job
	 * @param: @param quartzJob
	 * @return: void
	 * @throws  
	 */  
	public void resumeQuartzJob(QuartzJob quartzJob);

	
	/**  
	 * @Method: deleteQuartzJob  
	 * @Description: 删除某个job
	 * @param: @param quartzJob
	 * @return: void
	 * @throws  
	 */  
	public void deleteQuartzJob(QuartzJob quartzJob);

	
	/**  
	 * @Method: findQuartzJobById  
	 * @Description:  查询job
	 * @param: @param jodId
	 * @param: @return
	 * @return: QuartzJob
	 * @throws  
	 */  
	public QuartzJob findQuartzJobById(Integer jodId);

	
	/**  
	 * @Method: findQuartzJobByStatus  
	 * @Description: 根据状态查找job
	 * @param: @param jobStatus
	 * @param: @return
	 * @return: List<QuartzJob>
	 * @throws  
	 */  
	public List<QuartzJob> findQuartzJobByStatus(String jobStatus);

}
