package com.vtxlab.bootcamp.bootcampsbfinnhub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.bootcampsbfinnhub.infra.ApiRes;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.dto.QuoteDTO;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.dto.StockDTO;

public interface FinnhubOperation {
    @GetMapping("/quote")
    @ResponseStatus(HttpStatus.OK)
    ApiRes<QuoteDTO> getQuote(@RequestParam String symbol);

    @GetMapping("/profile")
    @ResponseStatus(HttpStatus.OK)
    ApiRes<StockDTO> getStock(@RequestParam String symbol);

    @GetMapping(value = "/redis/quote")
    QuoteDTO getQuoteDTObyRedis(@RequestParam String key)
            throws JsonProcessingException;

    @GetMapping(value = "/redis/profile")
    StockDTO getStockDTObyRedis(@RequestParam String key)
            throws JsonProcessingException;

}
