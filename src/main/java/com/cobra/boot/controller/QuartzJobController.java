package com.cobra.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cobra.boot.commons.ResponseResult;
import com.cobra.boot.entity.QuartzJob;
import com.cobra.boot.services.QuartzJobService;

/**  
 * @ClassName: QuartzJobController  
 * @Description: quartz定时任务管理  
 * @author: cobra  
 * @date: 2018年9月28日  
 * @version: v1.0
 */  
@RestController
@RequestMapping("/quartz")
public class QuartzJobController {

	@Autowired
	private QuartzJobService quartzJobService;

	/**  
	 * @Method: createQuartzJob  
	 * @Description: 创建定时任务
	 * @param: @param job
	 * @param: @return
	 * @return: ResponseResult
	 * @throws  
	 */  
	@PostMapping(value="/create")
	public ResponseResult createQuartzJob(@RequestBody QuartzJob job) {
		quartzJobService.createQuartzJob(job);
		return ResponseResult.newInstance(ResponseResult.SUCCESS, null);
	}

	/**  
	 * @Method: modifyQuartzJob  
	 * @Description: 修改定时任务
	 * @param: @param job
	 * @param: @return
	 * @return: ResponseResult
	 * @throws  
	 */  
	@PostMapping(value="/modify")
	public ResponseResult modifyQuartzJob(@RequestBody QuartzJob job) {
		quartzJobService.modifyQuartzJob(job);
		return ResponseResult.newInstance(ResponseResult.SUCCESS, null);
	}

	/**  
	 * @Method: pauseAllQuartzJob  
	 * @Description: 暂停所有定时任务
	 * @param: @return
	 * @return: ResponseResult
	 * @throws  
	 */  
	@RequestMapping("/pauseAll")
	public ResponseResult pauseAllQuartzJob() {
		quartzJobService.pauseAllQuartzJob();
		return ResponseResult.newInstance(ResponseResult.SUCCESS, null);

	}

	/**  
	 * @Method: pauseQuartzJob  
	 * @Description: 暂停某个定时任务
	 * @param: @param quartzJob
	 * @param: @return
	 * @return: ResponseResult
	 * @throws  
	 */  
	@RequestMapping("/pause")
	public ResponseResult pauseQuartzJob(QuartzJob quartzJob) {
		quartzJobService.pauseQuartzJob(quartzJob);
		return ResponseResult.newInstance(ResponseResult.SUCCESS, null);
	}

	/**  
	 * @Method: resumeAllQuartzJob  
	 * @Description: 恢复所有暂停的定时任务
	 * @param: @return
	 * @return: ResponseResult
	 * @throws  
	 */  
	@RequestMapping("/resumeAll")
	public ResponseResult resumeAllQuartzJob() {
		quartzJobService.resumeAllQuartzJob();
		return ResponseResult.newInstance(ResponseResult.SUCCESS, null);
	}

	/**  
	 * @Method: resumeQuartzJob  
	 * @Description: 恢复某个暂停的定时任务
	 * @param: @param quartzJob
	 * @param: @return
	 * @return: ResponseResult
	 * @throws  
	 */  
	@RequestMapping("/resume")
	public ResponseResult resumeQuartzJob(QuartzJob quartzJob) {
		quartzJobService.resumeQuartzJob(quartzJob);
		return ResponseResult.newInstance(ResponseResult.SUCCESS, null);
	}

	/**  
	 * @Method: deleteQuartzJob  
	 * @Description: 删除某个定时任务
	 * @param: @param quartzJob
	 * @param: @return
	 * @return: ResponseResult
	 * @throws  
	 */  
	@RequestMapping("/delete")
	public ResponseResult deleteQuartzJob(QuartzJob quartzJob) {
		System.out.println("jobID:"+quartzJob.getJobId());
		quartzJobService.deleteQuartzJob(quartzJob);
		return ResponseResult.newInstance(ResponseResult.SUCCESS, null);
	}
}
