package com.vtxlab.bootcamp.bootcampsbfinnhub.model;

import org.modelmapper.ModelMapper;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.dto.QuoteDTO;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.dto.StockDTO;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.jph.Quote;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.jph.Stock;

public class Mapper {

  public static QuoteDTO map(Quote quote) {
    // return QuoteDTO.builder()//
    // .currentPrice(quote.getCurrentPrice())//
    // .change(quote.getChange())//
    // .percentageChnage(quote.getPercentageChnage())//
    // .highPriceOfTheDay(quote.getHighPriceOfTheDay())//
    // .lowPriceOfTheDay(quote.getLowPriceOfTheDay())//
    // .openPriceOfTheDay(quote.getOpenPriceOfTheDay())//
    // .previousClosePrice(quote.getPreviousClosePrice())//
    // .timeStamp(quote.getTimeStamp())//
    // .build();
    return new ModelMapper().map(quote, QuoteDTO.class);
  }

  public static StockDTO map(Stock stock) {
    return new ModelMapper().map(stock, StockDTO.class);
  }
}
