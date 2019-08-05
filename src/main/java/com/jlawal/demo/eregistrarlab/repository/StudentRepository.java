package com.jlawal.demo.eregistrarlab.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jlawal.demo.eregistrarlab.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Modifying
	@Query("update Student s set " + "s.studentNumber = ?1 ," + "s.firstName = ?2 ," + "s.middleName = ?3 ,"
			+ "s.lastName = ?4 ," + "s.cgpa = ?5 ," + "s.enrollmentDate = ?6 ," + "s.isInternational = ?7 ,"
			+ "where s.studentId = ?8 ")
	void update(Student student, String studentNumber, String firstName, String middleName, String lastName,
			Double cgpa, LocalDate enrollmentDate, Boolean isInternational);
}
