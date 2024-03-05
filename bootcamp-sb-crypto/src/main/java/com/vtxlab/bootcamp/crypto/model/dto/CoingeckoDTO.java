package com.vtxlab.bootcamp.crypto.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

// ModelMapper: Class-to-class requires @NoArgsConstructor & @Setter
// ObjectMapper: JSON-to-class (or versa)90
public class CoingeckoDTO {

  private String id;
  private String symbol;
  private String name;
  private String image;
  @JsonProperty("current_price")
  private double currentPrice;
  @JsonProperty("market_cap")
  private long marketCap;
  @JsonProperty("market_cap_rank")
  private long marketCapRank;
  @JsonProperty("high_24h")
  private double high24h;
  @JsonProperty("low_24h")
  private double low24h;
  @JsonProperty("price_change_percentage_24h")
  private double priceChangePercentage24h;
  @JsonProperty("total_volume")
  private long totalVolume;
}
