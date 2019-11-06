package com.gestao.controllers.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao.models.Personagem;
import com.gestao.repository.PersonagemRepository;

@RestController
@RequestMapping("/api/personagens")
public class PersonagemAPI {
	
	@Autowired
	private PersonagemRepository personagens;
	
	//Create
	@PostMapping
	public ResponseEntity<?> savePersonagem(Personagem entity) {
	     return new ResponseEntity<Personagem> (personagens.save(entity), HttpStatus.OK);
	}
	
	//Read
	@GetMapping
	public List<Personagem> getAllPersonagens(){ return this.personagens.findAll(); }
	@GetMapping("/{id}")
	public Optional<Personagem> getPersonagem(@PathVariable("id") Long id)
	{
		return this.personagens.findById(id);
	}

	//Update
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePersonagem(@PathVariable("id") Long id, Personagem entity) 
	{
		Optional<Personagem> c = personagens.findById(id);
		
		if (!c.isPresent()) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(entity.getId() != id)
		{
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
		personagens.save(entity);
		return new ResponseEntity<Personagem>(personagens.save(entity), HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePersonagem(@PathVariable("id") Long id) 
	{
		Optional<Personagem> c = personagens.findById(id);
		
		if (c == null) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		personagens.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
