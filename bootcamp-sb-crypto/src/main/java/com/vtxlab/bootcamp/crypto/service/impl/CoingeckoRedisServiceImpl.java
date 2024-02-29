// package com.vtxlab.bootcamp.crypto.service.impl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.vtxlab.bootcamp.crypto.infra.RedisHelper;
// import com.vtxlab.bootcamp.crypto.model.dto.CoingeckoDTO;
// import com.vtxlab.bootcamp.crypto.service.CoingeckoRedisService;

// @Service
// public class CoingeckoRedisServiceImpl implements CoingeckoRedisService {

//   @Autowired
//   private RedisHelper redisHelper;

//   @Override
//   public CoingeckoDTO getCoingeckoDTO(String key)
//       throws JsonProcessingException {
//     return redisHelper.get(key, CoingeckoDTO.class);
//   }
// }
