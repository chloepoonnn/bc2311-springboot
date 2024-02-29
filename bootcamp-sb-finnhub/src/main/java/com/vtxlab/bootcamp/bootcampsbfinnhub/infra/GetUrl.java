package com.vtxlab.bootcamp.bootcampsbfinnhub.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class GetUrl {
  public static String url(Scheme scheme, String domain, String basePath,
      String endpoint, String token, String symbol) {
    return UriComponentsBuilder.newInstance() //
        .scheme(scheme.lowercaseName()) // .scheme("https")
        .host(domain) //
        .path(basePath)//
        .path(endpoint) //
        .queryParam("symbol", symbol) //
        .queryParam("token", token)//
        .toUriString(); // handle special character, such as : / \
  }
 // https://finnhub.io/api/v1/stock/profile2?symbol=AAPL&token=cnaqit1r01ql0f8ae3f0cnaqit1r01ql0f8ae3fg
}


