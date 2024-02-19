package com.vtxlab.bootcamp.bootcampsbcalculator.infra.exception;

import com.vtxlab.bootcamp.bootcampsbcalculator.infra.EnumSyscode;

public class DividedByZeroException extends ArithmeticException {
  public DividedByZeroException(EnumSyscode syscode) {
    super(syscode.getMessage());
  }
}
