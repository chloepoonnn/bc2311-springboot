package com.vtxlab.bootcamp.bootcampsbforum.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;

@Documented
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserIdValidator.class)
@ReportAsSingleViolation
public @interface UserIdCheck {

  public String message() default "Invalid User Id. Please try again.";

  public Class<?>[] groups() default {};

  public Class<? extends Payload>[] payload() default {};
  
}
