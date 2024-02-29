package com.vtxlab.bootcamp.bootcampsbforum.annotation;

import java.util.Objects;
import com.vtxlab.bootcamp.bootcampsbforum.dto.UserIdRQTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserIdValidator
    implements ConstraintValidator<UserIdCheck, UserIdRQTO> {

  @Override
  public boolean isValid(UserIdRQTO dto, ConstraintValidatorContext context) {
    if (!Objects.nonNull(dto))
      return false;
    try {
      Integer i = Integer.valueOf(dto.getId());
      return i > 0;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  // false -> Spring Program throw ConstraintViolationException -> GEH -> API Response
}
