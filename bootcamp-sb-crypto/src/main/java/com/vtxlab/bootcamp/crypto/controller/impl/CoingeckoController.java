package com.vtxlab.bootcamp.crypto.controller.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.crypto.controller.CoingeckoOperation;
import com.vtxlab.bootcamp.crypto.infra.CoinCurrency;
import com.vtxlab.bootcamp.crypto.infra.Mapper;
import com.vtxlab.bootcamp.crypto.model.dto.CoingeckoDTO;
// import com.vtxlab.bootcamp.crypto.service.CoingeckoRedisService;
import com.vtxlab.bootcamp.crypto.service.CoingeckoService;

@RestController
@CrossOrigin(origins = "http://localhost:8080",
    methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping(value = "/crypto/coingecko/api/v1")
public class CoingeckoController implements CoingeckoOperation {

  @Autowired
  private CoingeckoService coingeckoService;

  @Autowired
  private Mapper mapper;

  // @Autowired
  // private CoingeckoRedisService coingeckoRedisService;

  @Autowired
  private ModelMapper modelMapper;

  private boolean checkCoin(String coin) {
    return Arrays.stream(CoinCurrency.values())
        .anyMatch(e -> e.name().toLowerCase().equals(coin.toLowerCase()));
  }


  @Override
  public List<CoingeckoDTO> getCoinList(String currency, String coin) {
    // if (this.checkCoin(coin)) {
    // return coingeckoService.getData(currency).stream().map(e -> mapper.mapDTO(e))
    // .collect(Collectors.toList());
    // } else {
    // throw new InvalidInputException(ExceptionEnum.INVALID_INPUT);
    // }
    return coingeckoService.getData(currency).stream()
        .map(e -> modelMapper.map(e, CoingeckoDTO.class))
        .collect(Collectors.toList());

  }

  // @Override
  // public CoingeckoDTO getCoinListFromRedis(@RequestParam String key)
  // throws JsonProcessingException {
  // return coingeckoRedisService.getCoingeckoDTO(key); //.getCoinList(key);
  // }

}
