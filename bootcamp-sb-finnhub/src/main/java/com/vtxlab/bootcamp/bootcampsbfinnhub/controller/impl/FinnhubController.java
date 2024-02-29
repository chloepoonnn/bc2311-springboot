package com.vtxlab.bootcamp.bootcampsbfinnhub.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbfinnhub.controller.FinnhubOperation;
import com.vtxlab.bootcamp.bootcampsbfinnhub.exception.ExceptionEnum;
import com.vtxlab.bootcamp.bootcampsbfinnhub.infra.ApiRes;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.Mapper;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.dto.QuoteDTO;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.dto.StockDTO;
import com.vtxlab.bootcamp.bootcampsbfinnhub.service.FinnhubRedisService;
import com.vtxlab.bootcamp.bootcampsbfinnhub.service.FinnhubService;

@RestController
@RequestMapping(value = "/stock/finnhub/api/v1")
public class FinnhubController implements FinnhubOperation {

  @Autowired
  private FinnhubService finnhubService;

  @Autowired
  private FinnhubRedisService finnhubRedisService;

  @Override
  public ApiRes<QuoteDTO> getQuote(String symbol) {

    QuoteDTO data = Mapper.map(finnhubService.getquote(symbol));
    return ApiRes.<QuoteDTO>builder()//
        .code(ExceptionEnum.OK.getCode())//
        .message(ExceptionEnum.OK.getMessage())//
        .data(data)//
        .build();
  }

  @Override
  public ApiRes<StockDTO> getStock(String symbol) {

    StockDTO data = Mapper.map(finnhubService.getStock(symbol));
    return ApiRes.<StockDTO>builder()//
        .code(ExceptionEnum.OK.getCode())//
        .message(ExceptionEnum.OK.getMessage())//
        .data(data)//
        .build();
  }

  @Override
  public QuoteDTO getQuoteDTObyRedis(String key)
      throws JsonProcessingException {
    return finnhubRedisService.getQuoteDTO(key);
  }

  @Override
  public StockDTO getStockDTObyRedis(String key)
      throws JsonProcessingException {
    return finnhubRedisService.getStockDTO(key);
  }

}
