package com.orangetalents.api.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Definindo url da api e o nome de referência 
@FeignClient( name= "vehicle", url = "https://parallelum.com.br/fipe/api/v1")
public interface VehicleClient {
	
	// Método usando tipo de veículo
	@GetMapping("/{type}/marcas")
	List<VehicleSimple> searchTypeBrand(@PathVariable("type") String type);
	
	// Método usando tipo e codigo da marca
	@GetMapping("/{type}/marcas/{brandCode}/modelos")
	VehicleModel searchBrandModelVehicle(@PathVariable("type") String type, 
			@PathVariable("brandCode") String brandCode);
	
	// Método usando tipo, codigo da marca e codigo do modelo
	@GetMapping("/{type}/marcas/{brandCode}/modelos/{modelVehicleCode}/anos")
	List<VehicleSimple> searchModelVehicleYear(@PathVariable("type") String type, 
			@PathVariable("brandCode") String brandCode, 
			@PathVariable("modelVehicleCode") Integer modelVehicleCode);
	
	//Método usando tipo, codigo da marca, codigo do modelo e codigo do ano
	@GetMapping("/{type}/marcas/{brandCode}/modelos/{modelVehicleCode}/anos/{yearCode}")
	VehicleValue searchYearValue(@PathVariable("type") String type, 
			@PathVariable("brandCode") String brandCode, 
			@PathVariable("modelVehicleCode") Integer modelVehicleCode, 
			@PathVariable("yearCode")  String yearCode);
	
}
