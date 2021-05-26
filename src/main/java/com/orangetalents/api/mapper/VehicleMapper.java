package com.orangetalents.api.mapper;

import com.orangetalents.api.dto.VehicleDTO;
import com.orangetalents.api.entities.Vehicle;

public class VehicleMapper {

	public static VehicleMapper get() {
		return new  VehicleMapper();
	}
	
	 public Vehicle entity(VehicleDTO vehicleDTO) {
		 Vehicle vehicle = new Vehicle();

		vehicle.setBrand(vehicleDTO.getBrand());
		vehicle.setModelVehicle(vehicleDTO.getModelVehicle());
		vehicle.setType(vehicleDTO.getType());
		vehicle.setYear(vehicleDTO.getYear());
		vehicle.setDayRotation(vehicleDTO.getDayRotation());
		vehicle.setActiveRotation(vehicleDTO.getActiveRotation());
        
        return vehicle;
	 }
	 
	 public VehicleDTO dto(Vehicle vehicle) {
		 VehicleDTO dto = new VehicleDTO();

        dto.setBrand(vehicle.getBrand());
        dto.setModelVehicle(vehicle.getModelVehicle());
        dto.setType(vehicle.getType());
        dto.setYear(vehicle.getYear());
        dto.setDayRotation(vehicle.getDayRotation());
        dto.setActiveRotation(vehicle.getActiveRotation());
        
        return dto;
	 }
}
