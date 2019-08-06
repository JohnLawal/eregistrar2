package com.jlawal.demo.eregistrarlab.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "students", uniqueConstraints = @UniqueConstraint(columnNames = { "studentNumber" }))
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;

	@NotBlank(message = "Please enter the Student's Number")
	@Column(nullable = false, unique = true)
	private String studentNumber;

	@NotBlank(message = "Please enter the Student's First Name")
	@Column(nullable = false)
	private String firstName;

	private String middleName;

	@NotBlank(message = "Please enter the Student's Last Name")
	@Column(nullable = false)
	private String lastName;

	private Double cgpa;

	@NotNull(message = "Please enter the Enrollment Date")
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate enrollmentDate;

	@NotNull(message = "Please specify the Nationality")
	@Column(nullable = false)
	private Boolean isInternational;

	public Student() {

	}

	public Student(String studentNumber, String firstName, String middleName, String lastName, Double cgpa,
			LocalDate enrollmentDate, Boolean isInternational) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.enrollmentDate = enrollmentDate;
		this.isInternational = isInternational;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public Boolean getIsInternational() {
		return isInternational;
	}

	public void setIsInternational(Boolean isInternational) {
		this.isInternational = isInternational;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentNumber=" + studentNumber + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", cgpa=" + cgpa + ", enrollmentDate="
				+ enrollmentDate + ", isInternational=" + isInternational + "]";
	}

}
