package com.springmybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.springmybatis.pojo.Student;

public class StudentDaoImpl extends SqlSessionDaoSupport implements StudentDao {

	// 根据id查询用户信息
	@Override
	public Student findStudentById(int id) {
		// 创建SqlSession
		SqlSession sqlSession = this.getSqlSession();

		// 根据id查询用户
		Student student = sqlSession.selectOne("test.findStudentById", id);

		return student;
	}

	// 根据用户名称返回用户列表
	@Override
	public List<Student> findAllStudent(String name) throws Exception {
		// 创建SqlSession
		SqlSession sqlSession = this.getSqlSession();
		// 根据用户名称返回用户列表
		List<Student> students = sqlSession.selectList("test.findAllStudent", name);

		return students;
	}

	// 插入用户
	@Override
	public void insertStudent(Student student) throws Exception {
		// 创建SqlSession
		SqlSession sqlSession = this.getSqlSession();
		// 插入用户
		sqlSession.insert("test.insertStudent", student);
		sqlSession.commit();

	}

}
