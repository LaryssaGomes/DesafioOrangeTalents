package com.orangetalents.api.validation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import com.orangetalents.api.validation.validators.UniqueCpfValidator;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = UniqueCpfValidator.class)
@Target({ElementType.FIELD}) 
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueCpf {
	
    String message() default "CPF is already registered in the system";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
    
}