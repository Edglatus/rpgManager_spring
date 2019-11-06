package com.gestao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController 
{
	@GetMapping("/")
	public ModelAndView getHome() { return new ModelAndView("Home"); }
	
	@GetMapping("/local")
	public ModelAndView getPlace() { return new ModelAndView("Local"); }
}
