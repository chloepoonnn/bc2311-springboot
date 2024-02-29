package com.vtxlab.bootcamp.service;

import java.util.List;
import com.vtxlab.bootcamp.model.CoinData;

public interface ApiService<T> {
  List<T> fetchData();
}
