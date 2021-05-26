package com.orangetalents.api.exceptions;

public class VehicleApiFipeNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public VehicleApiFipeNotFoundException(String exception ) {
        super(exception);
    }
}
