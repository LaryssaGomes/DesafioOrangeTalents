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
	
	@Scheduled(cron = "0 1 0 ? * MON-FRI")// Executado de segunda a sexta meia-noite e 1 minuto
	public void run() {
		List<Vehicle> vehicle = vehicleRepository.findAll();
		String dayWeek = new SimpleDateFormat("EEEE").format(new Date());
		for(Vehicle updateCaster: vehicle) {
		     if(updateCaster.getDayRotation().equals(dayWeek)) {
		    	 updateCaster.setActiveRotation(true);
		     }
		 }
	    
	}
}
