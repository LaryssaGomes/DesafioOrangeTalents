package com.orangetalents.api.mapper;

import com.orangetalents.api.dto.PersonDTO;
import com.orangetalents.api.entities.Person;

public class PersonMapper {
	
	public static PersonMapper get() {
		return new  PersonMapper();
	}
	
	 public Person entity(PersonDTO personDTO) {
	 	Person person = new Person();

	 	person.setName(personDTO.getName());
	 	person.setCpf(personDTO.getCpf());
	 	person.setEmail(personDTO.getEmail());
	 	person.setBirthDay(personDTO.getBirthDay());

        return person;
	 }
	 
	 public PersonDTO dto(Person person) {
		 PersonDTO dto = new PersonDTO();

        dto.setName(person.getName());
        dto.setCpf(person.getCpf());
        dto.setEmail(person.getEmail());
        dto.setBirthday(person.getBirthDay());

        return dto;
	 }
}
