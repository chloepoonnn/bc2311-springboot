package com.vtxlab.bootcamp.bootcampsbfinnhub.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuoteDTO {

  private Double currentPrice;

  private Double change;

  private Double percentageChnage;

  private Double highPriceOfTheDay;

  private Double lowPriceOfTheDay;

  private Double openPriceOfTheDay;

  private Double previousClosePrice;

  private Long timeStamp;
}
