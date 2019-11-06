package com.gestao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gestao.models.Jogador;
import com.gestao.repository.JogadorRepository;

@Controller @RequestMapping("jogadores")
public class JogadorController 
{
	@Autowired
	private JogadorRepository jogadores;
	
	@GetMapping()
	public ModelAndView getJogadores()
	{
		ModelAndView mv = new ModelAndView("ListaJogadores.html");
		
		mv.addObject("jogadores", jogadores.findAll());
		mv.addObject(new Jogador());
		
		return mv;
	}
	
	@PostMapping()
	public String addJogador(Jogador c)
	{
		this.jogadores.save(c);
		return("redirect:/jogadores");
	}
	
	@GetMapping("/excluir/{id}")
	public String delJogador(@PathVariable long id)
	{
		this.jogadores.deleteById(id);;
		return("redirect:/jogadores");
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView altJogadores(@PathVariable long id)
	{
		ModelAndView mv = new ModelAndView("ListaJogadores.html");
		
		mv.addObject("jogadores", this.jogadores.findAll());
		mv.addObject("jogador", this.jogadores.findById(id));
		
		return mv;
	}
}
