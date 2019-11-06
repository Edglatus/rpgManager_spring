package com.gestao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.models.Classe;
import com.gestao.repository.ClasseRepository;

@Controller @RequestMapping("classes")
public class ClasseController 
{
	@Autowired
	private ClasseRepository classes;
	
	@GetMapping()
	public ModelAndView getClasses()
	{
		ModelAndView mv = new ModelAndView("ListaClasses.html");
		
		mv.addObject("classes", classes.findAll());
		mv.addObject(new Classe());
		
		return mv;
	}
	
	@PostMapping()
	public String addClasse(Classe c)
	{
		this.classes.save(c);
		return("redirect:/classes");
	}
	
	@GetMapping("/excluir/{id}")
	public String delClasse(@PathVariable long id)
	{
		this.classes.deleteById(id);;
		return("redirect:/classes");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView altClasses(@PathVariable long id)
	{
		ModelAndView mv = new ModelAndView("ListaClasses.html");
		
		mv.addObject("classes", this.classes.findAll());
		mv.addObject("classe", this.classes.findById(id));
		
		return mv;
	}
}
