package com.vtxlab.bootcamp;

import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.vtxlab.bootcamp.crypto.controller.CoingeckoOperation;
import com.vtxlab.bootcamp.crypto.exception.ExceptionEnum;
import com.vtxlab.bootcamp.crypto.model.dto.jph.Coingecko;
import com.vtxlab.bootcamp.crypto.service.CoingeckoService;

@WebMvcTest(CoingeckoOperation.class)
public class CryptoControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private CoingeckoService coingeckoService;

  @Test
  void testGetCoinList() throws Exception {
    Coingecko btc = Coingecko.builder().id("bitcoin").symbol("btc")
        .name("Bitcoin").currentPrice(50000).build();
    Coingecko eth = Coingecko.builder().id("ethereum").symbol("eth")
        .name("Ethereum").currentPrice(3000).build();
    List<Coingecko> testData = new ArrayList<>(List.of(btc, eth));
    when(coingeckoService.getData("usd", "btc,eth"))
        .thenReturn(testData);
    // Call the controller method
    mockMvc.perform(get("/crypto/coingecko/api/v1?currency=usd&ids=btc,eth"))//
        .andExpect(status().isOk())//
        .andExpect(jsonPath("$.syscode").value(ExceptionEnum.OK.getMessage()))//
        .andExpect(jsonPath("$.message").value(ExceptionEnum.OK.getMessage()))//
        .andExpect(jsonPath("$.data").isArray())//
        .andExpect(jsonPath("$.data[0].id").value("bitcoin"))//
        .andExpect(jsonPath("$.data[0].symbol").value("btc"))//
        .andExpect(jsonPath("$.data[0].name").value("Bitcoin"))//
        .andExpect(jsonPath("$.data[0].currentPrice").value(50000))//
        .andExpect(jsonPath("$.data[1].id").value("ethereum"))//
        .andExpect(jsonPath("$.data[1].symbol").value("eth"))//
        .andExpect(jsonPath("$.data[1].name").value("Ethereum"))//
        .andExpect(jsonPath("$.data[1].currentPrice").value(3000));

  }
}
