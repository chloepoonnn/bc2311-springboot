package com.vtxlab.bootcamp.crypto.service;

import java.util.List;
import com.vtxlab.bootcamp.crypto.model.dto.jph.Coingecko;
import lombok.Getter;


public interface CoingeckoService {

  List<Coingecko> getData();

}
