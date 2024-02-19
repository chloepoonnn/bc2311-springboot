package com.vtxlab.bootcamp.crypto.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.crypto.infra.GetUrl;
import com.vtxlab.bootcamp.crypto.infra.Scheme;
import com.vtxlab.bootcamp.crypto.model.dto.jph.Coingecko;
import com.vtxlab.bootcamp.crypto.service.CoingeckoService;

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
  public List<Coingecko> getData() {
    String url = GetUrl.url(Scheme.HTTPS, domain, basePath, endpoint);
    Coingecko[] coingeckos = restTemplate.getForObject(url, Coingecko[].class);

    return Arrays.stream(coingeckos).collect(Collectors.toList());
  }

}
