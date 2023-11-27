package es.anaya.spring.web.s04.customvalidator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;

@Documented
@Constraint(validatedBy = IdValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IdConstraint {
    String message() default "Invalid DNI";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}