package com.orangetalents.api.exceptions;

import java.util.Date;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(VehicleApiFipeNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(
			VehicleApiFipeNotFoundException ex, 
			WebRequest request) 
	{
		// Capturando os dados do erro
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
	        request.getDescription(false));
		// Realizando o retorno 404
	    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
