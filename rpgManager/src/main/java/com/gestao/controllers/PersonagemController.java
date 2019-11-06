package com.gestao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.models.Personagem;
import com.gestao.repository.CampanhaRepository;
import com.gestao.repository.ClasseRepository;
import com.gestao.repository.JogadorRepository;
import com.gestao.repository.PersonagemRepository;

@Controller @RequestMapping("personagens")
public class PersonagemController 
{
	@Autowired
	private PersonagemRepository personagens;
	@Autowired
	private JogadorRepository jogadores;
	@Autowired
	private ClasseRepository classes;
	@Autowired
	private CampanhaRepository campanhas;
	
	@GetMapping()
	public ModelAndView getPersonagens()
	{
		ModelAndView mv = new ModelAndView("ListaPersonagens.html");
		
		mv.addObject("personagens", personagens.findAll());
		mv.addObject("jogadores", jogadores.findAll());
		mv.addObject("classes", classes.findAll());
		mv.addObject("campanhas", campanhas.findAll());
		mv.addObject(new Personagem());
		
		return mv;
	}
	
	@PostMapping()
	public String addPersonagem(Personagem c)
	{
		this.personagens.save(c);
		return("redirect:/personagens");
	}
	
	@GetMapping("/excluir/{id}")
	public String delPersonagem(@PathVariable long id)
	{
		this.personagens.deleteById(id);;
		return("redirect:/personagens");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView altPersonagens(@PathVariable long id)
	{
		ModelAndView mv = new ModelAndView("ListaPersonagens.html");
		
		mv.addObject("personagens", this.personagens.findAll());
		mv.addObject("jogadores", jogadores.findAll());
		mv.addObject("classes", classes.findAll());
		mv.addObject("campanhas", campanhas.findAll());
		mv.addObject("personagem", this.personagens.findById(id));
		
		return mv;
	}
}
