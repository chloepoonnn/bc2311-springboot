package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbforum.infra.RedisHelper;

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  ModelMapper ModelMapper() {
    return new ModelMapper();
  }

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  // @Bean
  // RedisConnectionFactory redisConnectionFactory() {
  // return new LettuceConnectionFactory();
  // }

  @Bean
  RedisHelper redisHelper(RedisConnectionFactory factory,
      ObjectMapper objectMapper) {
    return new RedisHelper(factory, objectMapper);
  }
}
