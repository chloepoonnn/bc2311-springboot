package com.vtxlab.bootcamp.bootcampsbcalculator.service;

import com.vtxlab.bootcamp.bootcampsbcalculator.infra.EnumOperations;

public interface CalculationService {

  public String doOperation(String operation, String x, String y);

  EnumOperations checkOperation(String operation);
}
