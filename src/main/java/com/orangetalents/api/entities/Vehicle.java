package com.orangetalents.api.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity 
@Table(name ="tb_vehicle") 
public class Vehicle {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false) 
	private String brand;
	
	@Column(nullable = false)
	private String modelVehicle;
	
	@Column(nullable = false)
	private String year;
	
	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private String value;
	
	private String dayRotation;

	private Boolean activeRotation = false;
	
	@ManyToOne
	@JoinColumn(name = "person_id")
	@JsonBackReference
	private Person personId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Person getPersonId() {
		return personId;
	}

	public void setPersonId(Person personId) {
		this.personId = personId;
	}
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

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
