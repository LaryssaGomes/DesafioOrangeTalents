package com.orangetalents.api.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;


import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.orangetalents.api.validation.annotations.UniqueCpf;
import com.orangetalents.api.validation.annotations.UniqueEmail;


public class PersonDTO implements Serializable{

	private static final long serialVersionUID = 1L;


	@NotBlank(message = "The field 'cpf' cannot be empty/null")
    @CPF(message = "The field 'cpf' should be valid")
	@UniqueCpf
    private String cpf;

    @NotBlank(message = "The field 'email' cannot be empty/null")
    @Email(message = "The field 'email' should be valid")
    @UniqueEmail
    private String email;
    
    @NotBlank(message = "The field 'name' cannot be empty/null")
    private String name;
    
    @NotNull(message = "The field 'birthday' cannot be null")
    @Past(message = "The field 'birthday' should be valid")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate birthDay;
    
    private VehicleDTO vehicle;
    
    // Getters and setters
    
	public VehicleDTO getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleDTO vehicle) {
		this.vehicle = vehicle;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthday(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
    
}
