package com.vtxlab.bootcamp.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.model.CoinData;
import com.vtxlab.bootcamp.service.ApiService;

public class CoinDataService implements ApiService<CoinData> {

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<CoinData> fetchData() {
    String apiUrl =
        "https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=1005page=1&sparkline=false&locale=en";
    CoinData[] coinData = restTemplate.getForObject(apiUrl, CoinData[].class);
    return Arrays.stream(coinData).collect(Collectors.toList()); // convert to List
  }

}
