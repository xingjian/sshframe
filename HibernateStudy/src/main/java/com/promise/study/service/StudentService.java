/*@�ļ���: StudentService.java  @������: �Ͻ�   @��������: 2011-9-8 ����10:57:07*/
package com.promise.study.service;

import com.promise.study.domain.Student;
import com.promise.study.domain.StudentPK;

/**   
 * @����: StudentService.java 
 * @����: com.promise.study.service.impl 
 * @����: student service �ӿ� 
 * @����: �Ͻ� xingjian@yeah.net   
 * @����: 2011-9-8 ����10:57:07 
 * @�汾 V1.0   
 */
public interface StudentService {

	/**
	 * ����ѧ��
	 * @param student
	 * @return
	 */
	public boolean saveStudent(Student student);
	/**
	 * �༭
	 * @param student
	 * @return
	 */
	public boolean editStudent(Student student);
	/**
	 * ɾ��
	 * @param student
	 * @return
	 */
	public boolean deleteStudent(Student student);
	/**
	 * ��ȡѧ��
	 * @return
	 */
	public boolean getStudentByID(StudentPK studentPK);
}
