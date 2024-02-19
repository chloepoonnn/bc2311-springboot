package com.vtxlab.bootcamp.crypto.controller.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.crypto.controller.CoingeckoOperation;
import com.vtxlab.bootcamp.crypto.exception.ExceptionEnum;
import com.vtxlab.bootcamp.crypto.exception.InvalidInputException;
import com.vtxlab.bootcamp.crypto.infra.CoinCurrency;
import com.vtxlab.bootcamp.crypto.infra.Mapper;
import com.vtxlab.bootcamp.crypto.model.dto.CoingeckoDTO;
import com.vtxlab.bootcamp.crypto.service.CoingeckoService;

@RestController
@RequestMapping(value = "/crypto/coingecko/api/v1")
public class CoingeckoController implements CoingeckoOperation {

  @Autowired
  private CoingeckoService coingeckoService;

  @Autowired
  private Mapper mapper;

  private boolean checkCoin(String coin) {
    return Arrays.stream(CoinCurrency.values())
        .anyMatch(e -> e.name().toLowerCase().equals(coin.toLowerCase()));
  }


  @Override
  public List<CoingeckoDTO> getCoinList(String coin) {
    if (this.checkCoin(coin)) {
      return coingeckoService.getData().stream().map(e -> mapper.mapDTO(e))
          .collect(Collectors.toList());
    } else {
      throw new InvalidInputException(ExceptionEnum.INVALID_INPUT);
    }
  }

}
