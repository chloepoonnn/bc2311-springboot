package com.vtxlab.bootcamp.bootcampsbfinnhub.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbfinnhub.exception.ExceptionEnum;
import com.vtxlab.bootcamp.bootcampsbfinnhub.exception.InvalidInputException;
import com.vtxlab.bootcamp.bootcampsbfinnhub.infra.GetUrl;
import com.vtxlab.bootcamp.bootcampsbfinnhub.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.jph.Quote;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.jph.Stock;
import com.vtxlab.bootcamp.bootcampsbfinnhub.service.FinnhubService;

@Service
public class FinnhubServiceImpl implements FinnhubService {
  @Value(value = "${api.domain}")
  private String domain;

  @Value(value = "${api.base_path}")
  private String basePath;

  @Value(value = "${api.endpoint.quote}")
  private String endpoint1;

  @Value(value = "${api.endpoint.profile2}")
  private String endpoint2;

  @Value(value = "${api.symbol}")
  private String symbol;

  @Value(value = "${api.token}")
  private String token;

  @Autowired
  private RestTemplate restTemplate;

  private String getSymbol(String sym) {

    List<String> symbols = Arrays.asList(symbol.split(","));
    System.out.println("Sym=" + sym);
    if (symbols.contains(sym))
      return sym;
    else
      throw new InvalidInputException(ExceptionEnum.INVALID_INPUT);
  }

  @Override
  public Quote getquote(String sym) {
    String url = GetUrl.url(Scheme.HTTPS, domain, basePath, endpoint1, token,
        getSymbol(sym));
    return restTemplate.getForObject(url, Quote.class);
  }

  @Override
  public Stock getStock(String sym) {
    String url = GetUrl.url(Scheme.HTTPS, domain, basePath, endpoint2, token,
        getSymbol(sym));
    return restTemplate.getForObject(url, Stock.class);
  }


  // @Override
  // public List<CompanyProfile> getCompanyProfile(String symbol) {



  // }
}

