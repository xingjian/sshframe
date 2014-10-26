/** @文件名: DispatchJob.java @创建人：邢健  @创建日期： 2012-8-17 下午3:23:04 */
package com.promise.spring.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.promise.study.service.SpringDispatchService;
import com.promise.study.service.impl.SpringDispatchServiceImpl;

/**   
 * @类名: DispatchJob.java 
 * @包名: com.promise.spring.quartz 
 * @描述: TODO 
 * @作者: xingjian xingjian@yeah.net   
 * @日期:2012-8-17 下午3:23:04 
 * @版本: V1.0   
 */
public class DispatchJob implements Job {

	private SpringDispatchService sds = new SpringDispatchServiceImpl();
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		sds.printLog();
	}

}
