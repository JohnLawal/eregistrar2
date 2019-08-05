package com.jlawal.demo.eregistrarlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jlawal.demo.eregistrarlab.model.Student;
import com.jlawal.demo.eregistrarlab.service.StudentService;
import com.jlawal.demo.eregistrarlab.utility.AppStrings;

import javax.validation.Valid;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = { "/eregistrar/students/list", "/eregistrar/students/list" })
	public ModelAndView listStudents() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageTitle", "List of Registered Students");
		modelAndView.addObject("students", studentService.getAllRegisteredStudents());
		modelAndView.setViewName(AppStrings.STUDENT_LIST_PAGE.val());
		return modelAndView;
	}

	@GetMapping(value = { "/eregistrar/students/new", "eregistrar/students/new" })
	public String displayNewStudentForm(Model model) {
		model.addAttribute("pageTitle", "Register A New Student");
		model.addAttribute("student", new Student());
		return AppStrings.NEW_STUDENT_PAGE.val();
	}

	@PostMapping(value = { "/eregistrar/students/new", "eregistrar/students/new" })
	public String addNewStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
			Model model) {
		System.out.println(student);
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return AppStrings.NEW_STUDENT_PAGE.val();
		}
		
		studentService.saveStudent(student);
		return "redirect:/" + AppStrings.SITE_ROOT.val() + AppStrings.STUDENT_LIST_PAGE.val();
	}
	
	@GetMapping(value = { "/eregistrar/students/edit/{studentId}", "eregistrar/students/edit/{studentId}" })
	public String editStudent(@PathVariable Long studentId, Model model) {
		Student student = studentService.getStudentById((Long) studentId);
		if (student != null) {
			model.addAttribute("pageTitle", "Edit Student");
			model.addAttribute("student", student);
			return AppStrings.EDIT_STUDENT_PAGE.val();
		}
		return "redirect:/" + AppStrings.SITE_ROOT.val() + AppStrings.STUDENT_LIST_PAGE.val();
	}

	@PostMapping(value = { "/eregistrar/students/edit", "eregistrar/students/edit" })
	public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return AppStrings.EDIT_STUDENT_PAGE.val();
		}
		studentService.saveStudent(student);
		return "redirect:/" + AppStrings.SITE_ROOT.val() + AppStrings.STUDENT_LIST_PAGE.val();
	}

	@GetMapping(value = { "/eregistrar/students/delete/{studentId}", "/eregistrar/students/delete/{studentId}" })
	public String deleteStudent(@PathVariable Long studentId, Model model) {
		studentService.deleteStudentById(studentId);
		return "redirect:/" + AppStrings.SITE_ROOT.val() + AppStrings.STUDENT_LIST_PAGE.val();
	}

}
