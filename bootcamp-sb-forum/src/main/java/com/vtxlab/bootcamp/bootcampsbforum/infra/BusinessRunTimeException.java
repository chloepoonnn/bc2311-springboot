package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.Getter;

@Getter
public class BusinessRunTimeException extends RuntimeException {
  private String code;

  public BusinessRunTimeException(Syscode sysCode) {
    super(sysCode.getMessage());
    this.code = sysCode.getCode();
  }

  // BusinessRunTimeException -> RuntimeException -> Exception -> Throwable
  // Subclass of Throwable:
  // 1. "throw" an object of this subclass
  // 2. catch the object thrown by method
}
