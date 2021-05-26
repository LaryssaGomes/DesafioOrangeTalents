package com.orangetalents.api.feign;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VehicleValue {

	@JsonProperty("Valor")
	private String valor;

	public VehicleValue() {
    }

    public String getValor() {
        return valor;
	}

}
