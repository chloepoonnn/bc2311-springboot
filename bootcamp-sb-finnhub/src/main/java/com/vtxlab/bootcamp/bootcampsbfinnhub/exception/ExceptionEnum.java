package com.vtxlab.bootcamp.crypto.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ExceptionEnum {
  OK(000000, "OK"), //
  INVALID_INPUT(9, "Invalid input"), //
  INVALID_OPERATION(10, "Invalid operation"), //
  // Api error
  API_ERROR(100, "API error");
  //

  private int code;
  private String message;

}

