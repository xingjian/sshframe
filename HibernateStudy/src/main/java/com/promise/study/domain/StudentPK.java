/*@�ļ���: StudentPK.java  @������: �Ͻ�   @��������: 2011-9-8 ����11:25:48*/
package com.promise.study.domain;

import java.io.Serializable;

/**   
 * @����: StudentPK.java 
 * @����: com.promise.study.domain 
 * @����: Student������
 * @����: �Ͻ� xingjian@yeah.net   
 * @����: 2011-9-8 ����11:25:48 
 * @�汾 V1.0   
 */
public class StudentPK implements Serializable{
	
	private String stCode;//ѧ������
	
	private String stNum;//���
	
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
