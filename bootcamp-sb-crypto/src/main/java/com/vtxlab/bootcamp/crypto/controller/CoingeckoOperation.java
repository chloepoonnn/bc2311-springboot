package com.vtxlab.bootcamp.crypto.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.vtxlab.bootcamp.crypto.model.dto.CoingeckoDTO;

public interface CoingeckoOperation {

  @GetMapping(value = "/coins")
  List<CoingeckoDTO> getCoinList(@RequestParam String currency, @RequestParam(required = false) String coin);

//   @GetMapping(value = "/redis/coins")
//   CoingeckoDTO getCoinListFromRedis(@RequestParam String key)
//       throws JsonProcessingException;
}
