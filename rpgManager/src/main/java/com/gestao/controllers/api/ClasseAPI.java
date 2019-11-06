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

import com.gestao.models.Classe;
import com.gestao.repository.ClasseRepository;

@RestController
@RequestMapping("/api/classes")
public class ClasseAPI {
	
	@Autowired
	private ClasseRepository classes;
	
	//Create
	@PostMapping
	public ResponseEntity<?> saveClasse(Classe entity) {
	     return new ResponseEntity<Classe> (classes.save(entity), HttpStatus.OK);
	}
	
	//Read
	@GetMapping
	public List<Classe> getAllClasses(){ return this.classes.findAll(); }
	@GetMapping("/{id}")
	public Optional<Classe> getClasse(@PathVariable("id") Long id)
	{
		return this.classes.findById(id);
	}

	//Update
	@PutMapping("/{id}")
	public ResponseEntity<?> updateClasse(@PathVariable("id") Long id, Classe entity) 
	{
		Optional<Classe> c = classes.findById(id);
		
		if (!c.isPresent()) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		if(entity.getId() != id)
		{
			return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
		}
		
		classes.save(entity);
		return new ResponseEntity<Classe>(classes.save(entity), HttpStatus.OK);
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteClasse(@PathVariable("id") Long id) 
	{
		Optional<Classe> c = classes.findById(id);
		
		if (c == null) 
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		classes.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
