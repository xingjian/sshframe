/*@文件名: Student.java  @创建人: 邢健   @创建日期: 2011-9-8 上午10:55:02*/
package com.promise.study.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;

/**   
 * @类名: Student.java 
 * @包名: com.promise.study.domain 
 * @描述: 测试例子,采用复合主键 
 * @作者: 邢健 xingjian@yeah.net   
 * @日期: 2011-9-8 上午10:55:02 
 * @版本 V1.0   
 */
public class Student implements Serializable{
	
	private StudentPK studentPK;//复合主键
	
	private String name;
	
	private String address;
	
	private int age;

	@EmbeddedId
	public StudentPK getStudentPK() {
		return studentPK;
	}

	public void setStudentPK(StudentPK studentPK) {
		this.studentPK = studentPK;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
