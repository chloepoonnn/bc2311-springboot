package com.vtxlab.bootcamp.bootcampsbfinnhub.model.jph;

import lombok.Builder;

@Builder
public class Stock {
  private String country;
  private String currency;
  private String estimateCurrency;
  private String exchange;
  private String finnhubIndustry;
  private String ipo;
  private String logo;
  private Double marketCapitalization;
  private String name;
  private String phone;
  private Double shareOutstanding;
  private String ticker;
  private String weburl;
}
