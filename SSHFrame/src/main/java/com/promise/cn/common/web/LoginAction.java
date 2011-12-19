/*@文件名: LoginAction.java  @创建人: 邢健   @创建日期: 2011-12-19 下午01:46:28*/
package com.promise.cn.common.web;

import com.promise.cn.common.domain.PBUser;
import com.promise.cn.common.service.PBUserService;

/**   
 * @类名: LoginAction.java 
 * @包名: com.promise.cn.common.web 
 * @描述: loginaction 
 * @作者: 邢健 xingjian@dhcc.com.cn   
 * @日期: 2011-12-19 下午01:46:28 
 * @版本 V1.0   
 */
public class LoginAction {

	private String userName;
	
	private String password;
	
	private PBUserService pbUserService;
	
	public String checkLogin(){
		PBUser pbUser = pbUserService.getPBUserByUserNameAndPWD(userName, password);
		if(null!=pbUser){
			return "success";
		}
		return "failture";
	}

	public void setPbUserService(PBUserService pbUserService) {
		this.pbUserService = pbUserService;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}
	
}
