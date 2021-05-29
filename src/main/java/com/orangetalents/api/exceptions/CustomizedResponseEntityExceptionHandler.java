package com.orangetalents.api.exceptions;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	//Reescrevendo metodo
	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
    		MethodArgumentNotValidException ex, 
    		HttpHeaders headers,  
    		HttpStatus status, 
    		WebRequest request) {
		// Lista de erros object
        List<ErrorObject> errors = getErrors(ex);
        //Criando Error 
        ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
        return new ResponseEntity<>(errorResponse, status);
    }
	//Adicionando dados a errorResponde
    private ErrorResponse getErrorResponse(
    		MethodArgumentNotValidException ex, 
    		HttpStatus status, 
    		List<ErrorObject> errors) {
        return new ErrorResponse("Requisição possui campos inválidos", 
        		status.value(),
                status.getReasonPhrase(), 
                ex.getBindingResult().getObjectName(), 
                errors);
    }

    // Adicionando elementos a lista de erros object
    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(error.getDefaultMessage(), 
                		error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());
    }
	
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
