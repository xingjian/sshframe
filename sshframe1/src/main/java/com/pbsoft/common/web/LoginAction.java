/** @文件名: LoginAction.java @作者: 邢健  @创建日期: 2010-8-23 下午11:33:53**/
package com.pbsoft.common.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**   
 * @文件名: LoginAction.java 
 * @包名: com.pbsoft.common.web 
 * @描述: 登录Action
 * @作者: 邢健  
 * @联系： xingjian@yeah.net  
 * @日期: 2010-8-23 下午11:33:53 
 * @版本: V1.0   
 */

public class LoginAction {
	
	Log log = LogFactory.getLog(this.getClass());
	
	public String execute(){
		return "success";
	}
}
