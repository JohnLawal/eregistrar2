package com.jlawal.demo.eregistrarlab.repository;

//import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jlawal.demo.eregistrarlab.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
