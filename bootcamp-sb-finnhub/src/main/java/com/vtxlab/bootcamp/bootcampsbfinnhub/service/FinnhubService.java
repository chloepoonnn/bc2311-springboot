package com.vtxlab.bootcamp.bootcampsbfinnhub.service;

import com.vtxlab.bootcamp.bootcampsbfinnhub.model.jph.Quote;
import com.vtxlab.bootcamp.bootcampsbfinnhub.model.jph.Stock;

public interface FinnhubService {

  public Quote getquote(String symbol);

  public Stock getStock(String symbol);

  // List<CompanyProfile> getCompanyProfile(String symbol);

}
