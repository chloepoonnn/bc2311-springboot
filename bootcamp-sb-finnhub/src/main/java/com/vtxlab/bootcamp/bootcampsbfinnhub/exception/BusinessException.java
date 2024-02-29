package com.vtxlab.bootcamp.bootcampsbfinnhub.exception;


public class BusinessException extends Exception {
  private String code;

  public BusinessException(String code, String message) {
    super(message);
    this.code = code;
  }

}
