// package com.vtxlab.bootcamp;

// import java.util.ArrayList;
// import java.util.List;
// import org.junit.jupiter.api.Test;
// import org.mockito.Mockito;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;
// import com.vtxlab.bootcamp.crypto.controller.CoingeckoOperation;
// import com.vtxlab.bootcamp.crypto.model.dto.CoingeckoDTO;
// import com.vtxlab.bootcamp.crypto.service.CoingeckoService;

// @WebMvcTest(CoingeckoOperation.class)
// public class CryptoControllerTest {
//   @Autowired
//   private MockMvc mockMvc;

//   @MockBean
//   private CoingeckoService coingeckoService;

//   @Test
//   void testGetCoinList() throws Exception {
//     List<CoingeckoDTO> returnCoingecko = new ArrayList<>();
//     returnCoingecko.add(CoingeckoDTO.builder()//
//     .id("btc")//
//     .symbol("btc")//
//     .name("Bitcoin"))
//     .image("Bitcoin")
//     .currentPrice();
//     Mockito.when()

//   }
// }
