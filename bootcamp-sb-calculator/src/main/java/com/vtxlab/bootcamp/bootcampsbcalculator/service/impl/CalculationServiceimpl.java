package com.vtxlab.bootcamp.bootcampsbcalculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.EnumOperations;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculationService;

@Service
public class CalculationServiceimpl implements CalculationService {

  // public String getOperation(String operation) {
  // return operation.toLowerCase();
  // };

  @Override
  public String doOperation(String operation, String x, String y) {
    EnumOperations op = checkOperation(operation);

    switch (op) {

      case ADD:
        return Double.toString(Double.valueOf(x) - Double.valueOf(y));
      case SUB:
        return Double.toString(Double.valueOf(x) - Double.valueOf(y));
      case MUL:
        return Double.toString(Double.valueOf(x) * Double.valueOf(y));
      case DIV:
        BigDecimal result = BigDecimal.valueOf(Double.valueOf(x)).divide(
            BigDecimal.valueOf(Double.valueOf(y)), 5, RoundingMode.HALF_UP);
        return result.toString();
      default:
        return null;
    }
  }

  public EnumOperations checkOperation(String operation) {
    for (EnumOperations e : EnumOperations.values()) {
      if (e.name().toLowerCase().equals(operation))
        return e;
    }
    throw new IllegalArgumentException("Invalid operation: " + operation);
  }
}


