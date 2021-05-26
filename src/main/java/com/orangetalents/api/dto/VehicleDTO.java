package com.orangetalents.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class VehicleDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotNull(message = "The field 'brand' cannot be null")
	private String brand;

	@NotNull(message = "The field 'modelVehicle' cannot be null")
	private String modelVehicle;
	
	@NotNull(message = "The field 'year' cannot be null") 
	private String year;

	@NotNull(message = "The field 'tipy' cannot be null")
	private String type;

	private String value;
	  
	private String dayRotation;

	private Boolean activeRotation = false;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModelVehicle() {
		return modelVehicle;
	}

	public void setModelVehicle(String modelVehicle) {
		this.modelVehicle = modelVehicle;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDayRotation() {
		return dayRotation;
	}

	public void setDayRotation(String dayRotation) {
		this.dayRotation = dayRotation;
	}

	public Boolean getActiveRotation() {
		return activeRotation;
	}

	public void setActiveRotation(Boolean activeRotation) {
		this.activeRotation = activeRotation;
	}

	
}
