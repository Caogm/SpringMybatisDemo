package com.springmybatis.mapper;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springmybatis.pojo.Student;

public class StudentMapperTest {

	private ApplicationContext applicationContext;

	@Before
	public void SetupContext() {
		// 创建spring容器
		applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void testFindStudentById() throws Exception {
		StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
		Student student = studentMapper.findStudentById(2);
		System.out.println(student);
	}

	@Test
	public void testFindAllStudent() throws Exception {
		StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
		List<Student> students = studentMapper.findAllStudent("stu");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	@Test
	public void testInsertStudent() throws Exception {
		StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
		// 创建插入对象
		Student student = new Student();
		student.setName("sm插入测试2");
		student.setEmail("hjsdadk@163.com");
		student.setDob(new Date());
		studentMapper.insertStudent(student);
	}

	@Test
	public void testUpdateStudent() throws Exception {
		StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
		// 创建更改对象
		Student student = new Student();
		student.setStud_id(6);
		student.setName("sm更改测试");
		student.setEmail("hadk@163.com");
		student.setDob(new Date());
		studentMapper.updateStudent(student);
	}

	@Test
	public void testDeleteStudentById() throws Exception {
		StudentMapper studentMapper = (StudentMapper) applicationContext.getBean("studentMapper");
		studentMapper.deleteStudentById(8);
	}

}
