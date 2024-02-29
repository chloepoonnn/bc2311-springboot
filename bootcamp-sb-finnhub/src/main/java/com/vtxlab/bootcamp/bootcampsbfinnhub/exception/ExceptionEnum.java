package com.vtxlab.bootcamp.bootcampsbfinnhub.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ExceptionEnum {
  OK(000000, "OK"), //
  INVALID_INPUT(99999, "Invalid Symbol"), //
  // Api error
  API_ERROR(10000, "API error");
  //

  private int code;
  private String message;

}

