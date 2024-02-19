package com.vtxlab.bootcamp.bootcampsbcalculator.infra.exception;

import com.vtxlab.bootcamp.bootcampsbcalculator.infra.EnumSyscode;

public class BusinessException extends Exception {

  private String code;

  public BusinessException(EnumSyscode syscode) {
    super(syscode.getMessage());
    this.code = syscode.getCode();
  }
}

