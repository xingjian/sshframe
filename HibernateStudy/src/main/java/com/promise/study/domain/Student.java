/*@�ļ���: Student.java  @������: �Ͻ�   @��������: 2011-9-8 ����10:55:02*/
package com.promise.study.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;

/**   
 * @����: Student.java 
 * @����: com.promise.study.domain 
 * @����: ��������,���ø������� 
 * @����: �Ͻ� xingjian@yeah.net   
 * @����: 2011-9-8 ����10:55:02 
 * @�汾 V1.0   
 */
public class Student implements Serializable{
	
	private StudentPK studentPK;//��������
	
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
