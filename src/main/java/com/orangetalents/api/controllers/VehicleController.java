package com.orangetalents.api.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.api.entities.Person;
import com.orangetalents.api.entities.Vehicle;
import com.orangetalents.api.exceptions.VehicleApiFipeNotFoundException;
import com.orangetalents.api.feign.ResponseApi;
import com.orangetalents.api.dto.VehicleDTO;
import com.orangetalents.api.mapper.VehicleMapper;
import com.orangetalents.api.repositories.PersonRepository;
import com.orangetalents.api.repositories.VehicleRepository;

@RestController 
@RequestMapping(value = "/persons/{personId}/vehicle")
public class VehicleController {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	private final VehicleMapper vehicleMapper = VehicleMapper.get();
	
	// Acessando Response api
	@Autowired
	private ResponseApi responseApi;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity<Vehicle> create(@Valid @RequestBody VehicleDTO vehicleDTO, 
			@PathVariable("personId") Long personId) 
			throws VehicleApiFipeNotFoundException {
		
		Person person =  personRepository.findById(personId).orElse(null);
		
		Vehicle vehicleToSave = vehicleMapper.entity(vehicleDTO);
		vehicleToSave.setPersonId(person);
		
		// Vehicle client obtendo valor
		vehicleToSave.setValue(responseApi.seachApi(vehicleToSave));
		
		// Definindo dia de Rodizio
		vehicleToSave.setDayRotation(DayRotation(vehicleToSave.getYear()));
		
		//Definindo se e ou não dia de Rodizio
		vehicleToSave.setActiveRotation(ActiveRotation(vehicleToSave.getDayRotation()));
		vehicleRepository.save(vehicleToSave);
		return new ResponseEntity<>(vehicleToSave, HttpStatus.CREATED);//retornando
	}
	
	private String DayRotation(String year) {
		// Retirando o ultmo digito do ano e o transformando em string
		String lastNumberYear = Character.toString(year.charAt(year.length() - 1));
		String dayWeek = null;
		switch (lastNumberYear) {
			case "0":
			case "1":
				dayWeek = "segunda-feira";
				break;
			case "2":
			case "3":
				dayWeek = "terça-feira";
				break;
			case "4":
			case "5":
				dayWeek = "quarta-feira";
				break;
			case "6":
			case "7":
				dayWeek = "quinta-feira";
				break;
			case "8":
			case "9":
				dayWeek = "sexta-feira";
				break;
		}
		return dayWeek;
	}
	
	private Boolean ActiveRotation(String activeRotation) {
		//Obtendo dia da semana
		 String dayWeek = new SimpleDateFormat("EEEE").format(new Date());
		 //Verificando se está ou não ativo
		 if (dayWeek.equals(activeRotation)){
			 return true;
		 }else {
			 return false;
		 }
		
	}
	
}
