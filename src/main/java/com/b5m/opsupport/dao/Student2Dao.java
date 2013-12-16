package com.b5m.opsupport.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.b5m.opsupport.bean.model.Student;

//整合mybatis + spring: 采用接口org.apache.ibatis.session.SqlSession的实现类org.mybatis.spring.SqlSessionTemplate
@Repository
public class Student2Dao {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public Student selectStudent(Long id){
		return sqlSessionTemplate.selectOne("com.b5m.opsupport.dao.StudentDao.selectStudent", id);  
	}
	   
	public void insertStudent(Student student){
		this.sqlSessionTemplate.insert("com.b5m.opsupport.dao.StudentDao.insertStudent", student);
	}
}
