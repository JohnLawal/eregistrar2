package com.jlawal.demo.eregistrarlab.controller;

import com.jlawal.demo.eregistrarlab.utility.AppStrings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@GetMapping(value = { "/", "/eregistrar", "eregistrar", "/eregistrar/home", "eregistrar/home" })
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageTitle", "Welcome To eRegistrar");
		modelAndView.setViewName(AppStrings.HOME_PAGE.val());
		return modelAndView;
	}

}
