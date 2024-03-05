package com.vtxlab.bootcamp.crypto.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.crypto.infra.GetUrl;
import com.vtxlab.bootcamp.crypto.infra.Scheme;
import com.vtxlab.bootcamp.crypto.model.dto.jph.Coingecko;
import com.vtxlab.bootcamp.crypto.service.CoingeckoService;
import lombok.extern.slf4j.Slf4j;

@Service
public class CoingeckoServiceImpl implements CoingeckoService {
  @Value(value = "${api.domain}")
  private String domain;

  @Value(value = "${api.base_path}")
  private String basePath;

  @Value(value = "${api.endpoint}")
  private String endpoint;

  @Autowired
  private RestTemplate restTemplate;


  @Override
  public List<Coingecko> getDataFromApi(String currency, String id) {
    List<Coingecko> rawData = getCoinMarket(currency).stream()
        .filter(coin -> id.contains(coin.getId()))
        .collect(Collectors.toList());
    return rawData;
  }

  @Override
  public List<Coingecko> getCoinMarket(String currency) {
    String url = GetUrl.url(Scheme.HTTPS, domain, basePath, endpoint, currency);
    return Arrays.asList(restTemplate.getForObject(url, Coingecko[].class));
  }

  @Override
  public List<String> getCoinList(String currency, String id) {
    return this.getCoinMarket(currency).stream().map(Coingecko::getId)//
        .collect(Collectors.toList());
  }
}
