package com.vtxlab.bootcamp.crypto.exception;

public class InvalidOpeartionException extends RuntimeException {
  private int code;

  public InvalidOpeartionException(ExceptionEnum exceptionEnum) {
    super(exceptionEnum.getMessage());
    this.code = exceptionEnum.getCode();
  }
}
