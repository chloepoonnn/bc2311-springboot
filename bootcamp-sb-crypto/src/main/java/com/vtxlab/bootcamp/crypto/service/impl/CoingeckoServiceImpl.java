package com.vtxlab.bootcamp.crypto.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.crypto.infra.GetUrl;
import com.vtxlab.bootcamp.crypto.infra.Scheme;
import com.vtxlab.bootcamp.crypto.model.dto.jph.Coingecko;
import com.vtxlab.bootcamp.crypto.service.CoingeckoService;

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
  public List<Coingecko> getData(String currency) {
    System.out.println("get list");
    String url = GetUrl.url(Scheme.HTTPS, domain, basePath, endpoint, currency);
    System.out.println("done get list : " + url);

    Coingecko[] coingecko = restTemplate.getForObject(url, Coingecko[].class);
    Objects.requireNonNull(coingecko, "coingecko is null");
    List<Coingecko> coingeckos =
        Arrays.asList(coingecko);
    System.out.println("done get list 2 : " + url);
    System.out.println(coingeckos.get(0));

    return coingeckos;
  }

}
