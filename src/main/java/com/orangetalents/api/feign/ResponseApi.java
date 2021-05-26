package com.orangetalents.api.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.orangetalents.api.entities.Vehicle;
import com.orangetalents.api.exceptions.VehicleApiFipeNotFoundException;

@RestController
public class ResponseApi {
	
	@Autowired
	private VehicleClient vehicleClient;

	public String seachApi (Vehicle vehicle) throws VehicleApiFipeNotFoundException{
		
		// Obtendo codigo da marca do veículo
		String type = vehicle.getType();
		
		VehicleSimple vehicleBrand =  vehicleClient.searchTypeBrand(type)
				.stream()
				.filter(b -> b.getNome().equalsIgnoreCase(vehicle.getBrand()))
				.findFirst()
				.orElseThrow(() -> new VehicleApiFipeNotFoundException("Marca "+ vehicle.getBrand()+", não foi encontrado"));

		String brandCode = vehicleBrand.getCodigo();
		
		// Obtendo codigo do modelo do veículo
		VehicleModel.Model model = vehicleClient.searchBrandModelVehicle(type, brandCode).getModelos()
				.stream()
				.filter(m -> m.getNome().equalsIgnoreCase(vehicle.getModelVehicle()))
				.findFirst()
				.orElseThrow(() -> new VehicleApiFipeNotFoundException("Modelo de veículo "+ vehicle.getModelVehicle()+", não foi encontrado"));
		
		Integer modelVehicleCode = model.getCodigo();
		
		// Obtendo codigo de ano do veículo
		VehicleSimple vehicleSimple = vehicleClient.searchModelVehicleYear(type, brandCode, modelVehicleCode)
				.stream()
				.filter(v -> (v.getCodigo().substring(0, v.getCodigo().length()-2)).equals(vehicle.getYear()))
				.findFirst()
				.orElseThrow(() -> new VehicleApiFipeNotFoundException("Veículo do ano " + vehicle.getYear() + ", não foi encontrado"));
		
		String yearCode = vehicleSimple.getCodigo();
		
		// Obtendo valor do veículo
		VehicleValue value = vehicleClient.searchYearValue(type, brandCode, modelVehicleCode, yearCode);
		String valueVehicle = value.getValor();
		
		return valueVehicle;
	}
}
