package com.vtxlab.bootcamp.bootcampsbcalculator.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbcalculator.controller.ClientController;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.EnumOperations;
import com.vtxlab.bootcamp.bootcampsbcalculator.infra.RequestCounting;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculationService;


@RestController
@ResponseBody
@RequestMapping(value = "/api/v1/")

public class ClientControllerimpl implements ClientController {

  @Autowired
  private EnumOperations enumOperations;

  @Autowired
  private CalculationService calculationService;

  @Override
  public String calculateByRequestParam(String x, String y, String operation) {
    return calculationService.doOperation(operation, x, y);
  }


  @Override
  public String calculateByRequestBody(RequestCounting requestCounting) {
    return calculationService.doOperation(requestCounting.getOperation(),
        requestCounting.getX(), requestCounting.getY());
  }

  @Override
  public String calculateByPathVariable(String x, String y, String operation) {
    return calculationService.doOperation(operation, x, y);
  }


}
