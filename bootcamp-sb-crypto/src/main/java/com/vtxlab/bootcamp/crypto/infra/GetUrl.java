package com.vtxlab.bootcamp.crypto.infra;

import org.springframework.web.util.UriComponentsBuilder;

public class GetUrl {
  public static String url(Scheme scheme, String domain, String basePath,
      String endpoint, String currency) {
    return UriComponentsBuilder.newInstance() //
        .scheme(scheme.lowercaseName()) // .scheme("https")
        .host(domain) //
        .path(basePath)//
        .path(endpoint) //
        .queryParam("vs_currency", GetUrl.checkCurrency(currency)) //
        .queryParam("order", "cap_desc")//
        .queryParam("per_page", "100") //
        .queryParam("page", "1") //
        .queryParam("sparkline", "false")//
        .queryParam("locale", "en")//
        .toUriString(); // handle special character, such as : / \
  }

  public static String checkCurrency(String currency) {
    for (Currency c : Currency.values()) {
      if (c.name().toLowerCase().equals(currency))
        return currency;
    }
    return Currency.USD.name().toLowerCase();
  }
}

