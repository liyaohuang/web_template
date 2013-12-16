package com.b5m.opsupport.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.b5m.opsupport.bean.model.Student;
import com.b5m.opsupport.dao.Student2Dao;
import com.b5m.opsupport.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	private Student2Dao student2Dao;

	@Resource
	public void setStudentDao(Student2Dao student2Dao) {
		this.student2Dao = student2Dao;
	}
	
	public Student selectStudent(long id){
		return student2Dao.selectStudent(id);
	}
	   
	public void insertStudent(Student student){
		student2Dao.insertStudent(student);
	}
}
