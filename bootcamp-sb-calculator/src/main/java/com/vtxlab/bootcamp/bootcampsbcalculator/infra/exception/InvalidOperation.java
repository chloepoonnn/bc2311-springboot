package com.vtxlab.bootcamp.bootcampsbcalculator.infra.exception;

import com.vtxlab.bootcamp.bootcampsbcalculator.infra.EnumSyscode;

public class InvalidOperation extends BusinessException {
  public InvalidOperation(EnumSyscode syscode) {
    super(syscode);
  }
}
