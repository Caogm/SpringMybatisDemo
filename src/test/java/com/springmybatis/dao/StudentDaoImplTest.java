package com.springmybatis.dao;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springmybatis.pojo.Student;

public class StudentDaoImplTest {

	private ApplicationContext applicationContext;

	@Before
	public void SetupContext() {
		// 创建spring容器
		applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void testFindStudentById() throws Exception {
		// 从spring容器中获取StudentDao这个bean
		StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDao");
		Student student = studentDao.findStudentById(2);
		System.out.println(student);
	}

	@Test
	public void testFindAllStudent() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertStudent() {
		fail("Not yet implemented");
	}

}
