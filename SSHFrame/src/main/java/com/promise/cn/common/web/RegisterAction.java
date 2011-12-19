/*@文件名: RegisterAction.java  @创建人: 邢健   @创建日期: 2011-12-19 下午03:18:01*/
package com.promise.cn.common.web;

import com.promise.cn.common.domain.PBUser;
import com.promise.cn.common.service.PBUserService;

/**   
 * @类名: RegisterAction.java 
 * @包名: com.promise.cn.common.web 
 * @描述: TODO(用一句话描述该文件做什么) 
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-19 下午03:18:01 
 * @版本 V1.0   
 */
public class RegisterAction {

	private PBUser pbUser;
	
	private PBUserService pbUserService;
	
	public String savePBUser(){
		String retString = pbUserService.savePBUser(pbUser);
		if(retString.equals("1")){
			return "success";
		}
		return "failture";
	}

	public void setPbUser(PBUser pbUser) {
		this.pbUser = pbUser;
	}

	public void setPbUserService(PBUserService pbUserService) {
		this.pbUserService = pbUserService;
	}

	public PBUser getPbUser() {
		return pbUser;
	}
	
}
