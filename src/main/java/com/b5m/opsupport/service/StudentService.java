package com.b5m.opsupport.service;

import com.b5m.opsupport.bean.model.Student;

public interface StudentService {
	public Student selectStudent(long id);
	   
	public void insertStudent(Student student);
}
