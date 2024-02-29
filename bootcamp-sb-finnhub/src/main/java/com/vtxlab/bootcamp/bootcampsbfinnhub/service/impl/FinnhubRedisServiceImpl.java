package com.vtxlab.bootcamp.bootcampsbfinnhub.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbfinnhub.infra.RedisHelper;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.dto.QuoteDTO;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.dto.StockDTO;
import com.vtxlab.bootcamp.bootcampsbfinnhub.service.FinnhubRedisService;

@Service
public class FinnhubRedisServiceImpl implements FinnhubRedisService {

  @Autowired
  private RedisHelper redisHelper;

  @Override
  public StockDTO getStockDTO(String key) throws JsonProcessingException {
    return redisHelper.get(key, StockDTO.class);
  }

  @Override
  public QuoteDTO getQuoteDTO(String key) throws JsonProcessingException {
    return redisHelper.get(key, QuoteDTO.class);
  }
}
