/*@文件名: StudentServiceImpl.java  @创建人: 邢健   @创建日期: 2011-9-8 上午10:55:02*/
package com.promise.study.service.impl;

import com.promise.hibernate.HibernatePersistenceService;
import com.promise.study.domain.Student;
import com.promise.study.domain.StudentPK;
import com.promise.study.service.StudentService;

/**   
 * @类名: StudentServiceImpl.java 
 * @包名: com.promise.study.service.impl 
 * @描述: student service
 * @作者: 邢健 xingjian@yeah.net   
 * @日期: 2011-9-8 上午10:55:02 
 * @版本 V1.0   
 */
public class StudentServiceImpl implements StudentService {

	public HibernatePersistenceService hibernatePersistanceService;

	/**
	 * 保存学生
	 */
	@Override
	public boolean saveStudent(Student student) {
		return hibernatePersistanceService.save(student);
	}

	/**
	 * 编辑学生
	 */
	@Override
	public boolean editStudent(Student student) {
		return hibernatePersistanceService.update(student);
	}

	/**
	 * 删除学生
	 */
	@Override
	public boolean deleteStudent(Student student) {
		return hibernatePersistanceService.delete(student);
	}

	/**
	 * 获取学生
	 */
	@Override
	public Student getStudentByID(StudentPK studentPK) {
		return (Student)hibernatePersistanceService.get(Student.class,studentPK);
	}
	
	/**
	 * 设置hibernatePersistanceService
	 * @param hibernatePersistanceService
	 */
	public void setHibernatePersistanceService(HibernatePersistenceService hps) {
		this.hibernatePersistanceService = hps;
	}

}
