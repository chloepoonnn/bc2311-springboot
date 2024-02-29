package com.vtxlab.bootcamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
