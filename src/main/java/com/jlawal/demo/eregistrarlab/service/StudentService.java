package com.jlawal.demo.eregistrarlab.service;

import java.util.List;

import com.jlawal.demo.eregistrarlab.model.Student;

public interface StudentService {
	List<Student> getAllRegisteredStudents();

	Student getStudentById(Long studentId);
	
	void saveStudent(Student student);

	void updateStudent(Student student);

	void deleteStudent(Student student);

	public void deleteStudentById(Long studentId) ;

}
