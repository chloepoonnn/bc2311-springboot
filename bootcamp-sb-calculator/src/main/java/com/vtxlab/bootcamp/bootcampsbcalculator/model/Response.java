package com.vtxlab.bootcamp.bootcampsbcalculator.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Response {
  private String x;

  private String y;

  private String operation;

  private String result;
}
