package com.vtxlab.bootcamp.crypto.service;

import java.util.List;
import com.vtxlab.bootcamp.crypto.model.dto.jph.Coingecko;

public interface CoingeckoService {

  List<Coingecko> getCoinMarket(String currency);

  List<Coingecko> getDataFromApi(String currency, String id);

  public List<String> getCoinList(String currency, String id);

}
