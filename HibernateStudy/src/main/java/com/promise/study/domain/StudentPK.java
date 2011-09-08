/*@文件名: StudentPK.java  @创建人: 邢健   @创建日期: 2011-9-8 上午11:25:48*/
package com.promise.study.domain;

import java.io.Serializable;

/**   
 * @类名: StudentPK.java 
 * @包名: com.promise.study.domain 
 * @描述: Student类主键
 * @作者: 邢健 xingjian@yeah.net   
 * @日期: 2011-9-8 上午11:25:48 
 * @版本 V1.0   
 */
public class StudentPK implements Serializable{
	
	private String stCode;//学生编码
	
	private String stNum;//编号
	
	public String getStCode() {
		return stCode;
	}
	public void setStCode(String stCode) {
		this.stCode = stCode;
	}
	public String getStNum() {
		return stNum;
	}
	public void setStNum(String stNum) {
		this.stNum = stNum;
	}
	
}
