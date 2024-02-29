package com.vtxlab.bootcamp.bootcampsbfinnhub.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.dto.QuoteDTO;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.dto.StockDTO;

public interface FinnhubRedisService {
  StockDTO getStockDTO(String key)
      throws JsonProcessingException;

  QuoteDTO getQuoteDTO(String key)
      throws JsonProcessingException;
}
