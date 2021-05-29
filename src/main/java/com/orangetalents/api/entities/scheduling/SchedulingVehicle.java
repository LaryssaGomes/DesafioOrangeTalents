package com.orangetalents.api.entities.scheduling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.orangetalents.api.entities.Vehicle;
import com.orangetalents.api.repositories.VehicleRepository;

public class SchedulingVehicle {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	// Executado de segunda a sexta meia-noite e 1 minuto
	@Scheduled(cron = "0 1 0 ? * MON-FRI")
	public void run() {
		// Todos os dados da tabela vehicle
		List<Vehicle> vehicle = vehicleRepository.findAll();
		
		// Obtendo dia da semana atual
		String dayWeek = new SimpleDateFormat("EEEE").format(new Date());
		
		// Percorrendo os dados de vehicle
		for(Vehicle updateCaster: vehicle) {
			// Verificando se e ou não dia de rodizio 
		     if(updateCaster.getDayRotation().equals(dayWeek)) {
		    	 updateCaster.setActiveRotation(true);
		     }else {
		    	 updateCaster.setActiveRotation(false);
		     }
		 }
	    
	}
}
