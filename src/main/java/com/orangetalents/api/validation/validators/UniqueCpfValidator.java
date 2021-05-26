package com.orangetalents.api.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.orangetalents.api.repositories.PersonRepository;
import com.orangetalents.api.validation.annotations.UniqueCpf;

public class UniqueCpfValidator  implements ConstraintValidator<UniqueCpf, String>{
	
	@Autowired
    private PersonRepository personRepository;

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        return !personRepository.findByCpf(cpf).isPresent();
    }
}
