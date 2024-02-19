package com.vtxlab.bootcamp.bootcampsbcalculator.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@Builder
public class RequestCounting {
  private String x;

  private String y;

  private String operation;
}
