package com.orangetalents.api.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient( name= "vehicle", url = "https://parallelum.com.br/fipe/api/v1")
public interface VehicleClient {
	
	@GetMapping("/{type}/marcas")
	List<VehicleSimple> searchTypeBrand(@PathVariable("type") String type);
	
	@GetMapping("/{type}/marcas/{brandCode}/modelos")
	VehicleModel searchBrandModelVehicle(@PathVariable("type") String type, @PathVariable("brandCode") String brandCode);
	
	@GetMapping("/{type}/marcas/{brandCode}/modelos/{modelVehicleCode}/anos")
	List<VehicleSimple> searchModelVehicleYear(@PathVariable("type") String type, @PathVariable("brandCode") String brandCode, @PathVariable("modelVehicleCode") Integer modelVehicleCode);
	
	@GetMapping("/{type}/marcas/{brandCode}/modelos/{modelVehicleCode}/anos/{yearCode}")
	VehicleValue searchYearValue(@PathVariable("type") String type, @PathVariable("brandCode") String brandCode, @PathVariable("modelVehicleCode") Integer modelVehicleCode, @PathVariable("yearCode")  String yearCode);
	
}
