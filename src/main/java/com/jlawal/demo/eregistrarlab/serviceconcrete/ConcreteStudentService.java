package com.jlawal.demo.eregistrarlab.serviceconcrete;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jlawal.demo.eregistrarlab.model.Student;
import com.jlawal.demo.eregistrarlab.repository.StudentRepository;
import com.jlawal.demo.eregistrarlab.service.StudentService;

@Transactional
@Service
public class ConcreteStudentService implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllRegisteredStudents() {
		return studentRepository.findAll(Sort.by("firstName"));
	}
	

	@Override
	public Student getStudentById(Long studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}

	@Override
	public void saveStudent(Student student) {
		try {
			studentRepository.save(student);
		}catch(ConstraintViolationException ex) {
			System.out.print("constraint error");
			throw ex; 
		}
		
	}

	@Override
	public void deleteStudent(Student student) {
		studentRepository.delete(student);
	}

	@Override
	public void deleteStudentById(Long studentId) {
		studentRepository.deleteById(studentId);
	}

}
