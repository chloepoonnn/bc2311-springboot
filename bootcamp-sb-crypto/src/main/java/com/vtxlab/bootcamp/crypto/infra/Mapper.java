package com.vtxlab.bootcamp.crypto.infra;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.crypto.entity.CoingeckoEntity;
// import com.vtxlab.bootcamp.crypto.entity.CoingeckoEntity;
import com.vtxlab.bootcamp.crypto.model.dto.CoingeckoDTO;
import com.vtxlab.bootcamp.crypto.model.dto.jph.Coingecko;

@Component
public class Mapper {
  @Autowired
  private ModelMapper modelMapper;

  public CoingeckoDTO mapDTO(Coingecko coingecko) {
    // CoingeckoDTO coingeckoDTO = modelMapper.map(coingecko, CoingeckoDTO.class);
    return CoingeckoDTO.builder()//
        .id(coingecko.getId())//
        .symbol(coingecko.getSymbol())//
        .name(coingecko.getName())//
        .image(coingecko.getImage())//
        .currentPrice(coingecko.getCurrentPrice())//
        .marketCapRank(coingecko.getMarketCapRank())//
        .marketCap(coingecko.getMarketCap())//
        .high24h(coingecko.getHigh24h())//
        .low24h(coingecko.getLow24h())//
        .priceChangePercentage24h(coingecko.getPriceChangePercentage24h())//
        .totalVolume(coingecko.getTotalVolume())//
        .build();
  }

  public CoingeckoEntity mapEntity(Coingecko coingecko) {
    CoingeckoEntity coingeckoEntity =
        modelMapper.map(coingecko, CoingeckoEntity.class);
    if (coingecko.getRoi() != null) {
      coingeckoEntity.setTimes(coingecko.getRoi().getTimes());
      coingeckoEntity.setCurrency(coingecko.getRoi().getCurrency());
      coingeckoEntity.setPercentage(coingecko.getRoi().getPercentage());
    }
    return coingeckoEntity;
  }

  public CoingeckoDTO mapEntityToDTO(CoingeckoEntity coingeckoEntity) {
    CoingeckoDTO coingeckoDTO =
        modelMapper.map(coingeckoEntity, CoingeckoDTO.class);
    return coingeckoDTO;

  }
}
