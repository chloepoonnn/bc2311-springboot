package com.vtxlab.bootcamp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class CoinData {

  private String id;

  private String image;
  @JsonProperty(value = "current_price")
  private Double currentPrice;
}
