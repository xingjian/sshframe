/*@文件名: SpringDispatchServiceImpl.java  @创建人: 邢健   @创建日期: 2011-9-16 下午1:21:42*/
package com.promise.study.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.promise.study.service.SpringDispatchService;

/**   
 * @类名: SpringDispatchServiceImpl.java 
 * @包名: com.promise.study.service.impl 
 * @描述: spring掉图服务接口 
 * @作者: 邢健 xingjian@yeah.net   
 * @日期: 2011-9-16 下午1:21:42 
 * @版本 V1.0   
 */
public class SpringDispatchServiceImpl implements SpringDispatchService{

	public int count = 0;
	/**
	 * 打印日志
	 */
	@Override
	public void printLog() {
		System.out.println("第"+count+"次打印日志!"+(new SimpleDateFormat("yyyy-MM-dd HHmmss")).format(new Date()));
		count++;
	}

}
