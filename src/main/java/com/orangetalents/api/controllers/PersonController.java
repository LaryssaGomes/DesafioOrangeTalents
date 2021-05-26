package com.orangetalents.api.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.api.dto.PersonDTO;
import com.orangetalents.api.entities.Person;
import com.orangetalents.api.mapper.PersonMapper;
import com.orangetalents.api.repositories.PersonRepository;

@RestController 
@RequestMapping(value = "/persons")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	private final PersonMapper personMapper = PersonMapper.get();
	
	public PersonController(PersonRepository eventRepository) {
		this.personRepository = eventRepository;
	}
	// Criando person
	@PostMapping // Definindo método post
	@ResponseBody 
	public  ResponseEntity<PersonDTO> create(@Valid @RequestBody PersonDTO personDTO) {
		//De personDTO para a entidade person
		System.out.print("----------------------------------------------------");
		Person personToSave = personMapper.entity(personDTO);
		personRepository.save(personToSave);//Salvando dado
		return new ResponseEntity<>(personDTO , HttpStatus.CREATED);//retornando
	}
	
	@GetMapping("/{id}/list")// Definindo método GET
	public ResponseEntity<Optional<Person>> find(@PathVariable long id){
		// Buscando person
		Optional<Person> person = this.personRepository.findById(id);
		
		return new ResponseEntity<>(person , HttpStatus.OK);
	} 
}

