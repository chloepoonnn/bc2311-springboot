package com.vtxlab.bootcamp.crypto.service;

import java.util.List;
import com.vtxlab.bootcamp.crypto.model.dto.jph.Coingecko;

public interface CoingeckoService {

  List<Coingecko> getData(String currency);

}
