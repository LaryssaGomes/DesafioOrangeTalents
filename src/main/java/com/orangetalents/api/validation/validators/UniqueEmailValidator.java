package com.orangetalents.api.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.orangetalents.api.repositories.PersonRepository;
import com.orangetalents.api.validation.annotations.UniqueEmail;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String>{
	
	@Autowired
    private PersonRepository personRepository;
	
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return !personRepository.findByEmail(email).isPresent();
    }

}
