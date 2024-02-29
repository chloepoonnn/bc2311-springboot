package com.vtxlab.bootcamp.bootcampsbfinnhub.exception;

import org.apache.coyote.BadRequestException;

public class ApiError extends BadRequestException {
  private int code;

  public ApiError(int code, String message) {
    super(message);
    this.code = code;
  }
}
