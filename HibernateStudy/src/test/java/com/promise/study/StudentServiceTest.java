/*@文件名: StudentServiceTest.java  @创建人: 邢健   @创建日期: 2011-9-9 下午2:02:16*/
package com.promise.study;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.promise.hibernate.HibernatePersistenceServiceImpl;
import com.promise.study.domain.Student;
import com.promise.study.domain.StudentPK;
import com.promise.study.service.impl.StudentServiceImpl;

/**   
 * @类名: StudentServiceTest.java 
 * @包名: com.promise.study 
 * @描述: 测试study模块
 * @作者: 邢健 xingjian@yeah.net   
 * @日期: 2011-9-9 下午2:02:16 
 * @版本 V1.0   
 */
public class StudentServiceTest {

	public StudentServiceImpl studentService;
	
	/**
	 * 初始化值studentService
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		studentService = new StudentServiceImpl();
		HibernatePersistenceServiceImpl hps = new HibernatePersistenceServiceImpl();
		studentService.setHibernatePersistanceService(hps);
	}

	/**
	 * 测试保存学生对象
	 */
	@Test
	public void testSaveStudent() {
		StudentPK pk = new StudentPK();
		pk.setStCode("001");
		pk.setStNum("031");
		Student student = new Student();
		student.setStudentPK(pk);
		student.setAddress("海淀区");
		student.setName("王小二");
		student.setAge(15);
		boolean retBoolean = studentService.saveStudent(student);
		Assert.assertTrue(retBoolean);
	}
	
	/**
	 * 测试修改学生
	 */
	@Test
	public void testUpdateStudent(){
		StudentPK pk = new StudentPK();
		pk.setStCode("001");
		pk.setStNum("031");
		Student student = new Student();
		student.setStudentPK(pk);
		student.setAddress("海淀区");
		student.setName("王小三");
		student.setAge(15);
		boolean retBoolean = studentService.editStudent(student);
		Assert.assertTrue(retBoolean);
	}
	
	/**
	 * 测试删除数据
	 */
	@Test
	public void testDeleteStudent(){
		StudentPK pk = new StudentPK();
		pk.setStCode("001");
		pk.setStNum("031");
		Student student = new Student();
		student.setStudentPK(pk);
		boolean retBoolean = studentService.deleteStudent(student);
		Assert.assertTrue(retBoolean);
	}
	
	@Test
	public void testGetStudent(){
		StudentPK pk = new StudentPK();
		pk.setStCode("001");
		pk.setStNum("031");
		Student student = studentService.getStudentByID(pk);
		Assert.assertEquals("王小二",student.getName());
	}

	@Test
	public void testLoadStudent(){
		StudentPK pk = new StudentPK();
		pk.setStCode("001");
		pk.setStNum("031");
		Student student = studentService.getStudentByID(pk);
		Assert.assertEquals("王小二",student.getName());
	}
}
