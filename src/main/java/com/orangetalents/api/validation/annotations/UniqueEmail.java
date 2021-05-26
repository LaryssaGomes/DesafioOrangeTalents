package com.orangetalents.api.validation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.orangetalents.api.validation.validators.UniqueEmailValidator;

@Documented
@Constraint(validatedBy = UniqueEmailValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueEmail {
	
	String message() default "E-mail is already registered in the system";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
