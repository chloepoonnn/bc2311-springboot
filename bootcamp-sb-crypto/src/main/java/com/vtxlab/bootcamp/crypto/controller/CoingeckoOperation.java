package com.vtxlab.bootcamp.crypto.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.bootcamp.crypto.model.dto.CoingeckoDTO;

public interface CoingeckoOperation {

  
@GetMapping(value = "/coins")
List<CoingeckoDTO> getCoinList(@RequestParam String coin);
}
