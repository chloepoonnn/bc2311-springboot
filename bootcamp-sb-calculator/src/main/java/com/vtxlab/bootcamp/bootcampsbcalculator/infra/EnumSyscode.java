package com.vtxlab.bootcamp.bootcampsbcalculator.infra;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum EnumSyscode {
  OK("OK.", "000000"), //
  INVALID_INPUT("Invalid input.", "000001"), //
  INVALID_OPERATION("Invalid operation.", "000002"), //
  DIVIDEDBYZERO_EXCEPTION("The input cannot be 0.", "000003"), //
  INVALID_NUMBER_INPUT("The Number Input is Invalid", "000004");

  private String message;
  private String code;
}
