/*@文件名: StudentService.java  @创建人: 邢健   @创建日期: 2011-9-8 上午10:55:02*/
package com.promise.study.service;

import java.util.List;

import com.promise.study.domain.Student;
import com.promise.study.domain.StudentPK;

/**   
 * @接口名: StudentService.java 
 * @包名: com.promise.study.service.impl 
 * @描述: student service
 * @作者: 邢健 xingjian@yeah.net   
 * @日期: 2011-9-8 上午10:55:02 
 * @版本 V1.0   
 */
public interface StudentService {

	/**
	 * 保存学生
	 * @param student
	 * @return
	 */
	public boolean saveStudent(Student student);
	/**
	 * 编辑学生
	 * @param student
	 * @return
	 */
	public boolean editStudent(Student student);
	/**
	 * 删除学生
	 * @param student
	 * @return
	 */
	public boolean deleteStudent(Student student);
	/**
	 * 获取学生
	 * @return
	 */
	public Student getStudentByID(StudentPK studentPK);
	/**
	 * 批量保存学生
	 * @param list
	 * @return
	 */
	public List<Student> saveStudents(List<Student> list);
}
