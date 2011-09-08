/*@文件名: StudentService.java  @创建人: 邢健   @创建日期: 2011-9-8 上午10:57:07*/
package com.promise.study.service;

import com.promise.study.domain.Student;
import com.promise.study.domain.StudentPK;

/**   
 * @类名: StudentService.java 
 * @包名: com.promise.study.service.impl 
 * @描述: student service 接口 
 * @作者: 邢健 xingjian@yeah.net   
 * @日期: 2011-9-8 上午10:57:07 
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
	 * 编辑
	 * @param student
	 * @return
	 */
	public boolean editStudent(Student student);
	/**
	 * 删除
	 * @param student
	 * @return
	 */
	public boolean deleteStudent(Student student);
	/**
	 * 获取学生
	 * @return
	 */
	public boolean getStudentByID(StudentPK studentPK);
}
