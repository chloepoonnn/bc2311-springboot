package com.vtxlab.bootcamp.crypto.exception;

public class InvalidInputException extends RuntimeException {
  private int code;

  public InvalidInputException(ExceptionEnum exceptionEnum) {
    super(exceptionEnum.getMessage());
    this.code = exceptionEnum.getCode();
  }
}
