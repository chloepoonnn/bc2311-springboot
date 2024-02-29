package com.vtxlab.bootcamp.bootcampsbfinnhub.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StockDTO {
  private String name;

  private String ticker;

  @JsonProperty("Current_Price")
  private Double currentPrice;
  @JsonProperty("Change")
  private Double change;
  @JsonProperty("Percent_Change")
  private Double percentChange;
  @JsonProperty("High_Price_Of_The_Day")
  private Double highPrice;
  @JsonProperty("Low_Price_Of_The_Day")
  private Double lowPrice;
  @JsonProperty("Open_Price_Of_The_Day")
  private Double openPrice;
  @JsonProperty("Previous_Close_Price")
  private Double closePrice;
}
