package com.vtxlab.bootcamp.bootcampsbfinnhub.model.jph;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
  @JsonProperty(value = "c")
  private Double currentPrice;

  @JsonProperty(value = "d")
  private Double change;

  @JsonProperty(value = "dp")
  private Double percentageChange;

  @JsonProperty(value = "h")
  private Double highPriceOfTheDay;

  @JsonProperty(value = "l")
  private Double lowPriceOfTheDay;

  @JsonProperty(value = "o")
  private Double openPriceOfTheDay;

  @JsonProperty(value = "pc")
  private Double previousClosePrice;

  @JsonProperty(value = "t")
  private Long timeStamp;
}
