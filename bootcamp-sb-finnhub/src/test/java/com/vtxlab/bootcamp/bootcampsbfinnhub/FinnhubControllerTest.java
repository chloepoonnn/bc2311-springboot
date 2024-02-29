// package com.vtxlab.bootcamp.bootcampsbfinnhub;

// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;
// import com.vtxlab.bootcamp.bootcampsbfinnhub.model.jph.Quote;
// import com.vtxlab.bootcamp.bootcampsbfinnhub.model.jph.Stock;
// import com.vtxlab.bootcamp.bootcampsbfinnhub.service.FinnhubService;

// @SpringBootTest
// @AutoConfigureMockMvc
// public class FinnhubControllerTest {
//   @Autowired
//   private MockMvc mockMvc;

//   @MockBean
//   private FinnhubService finnhubService;

//   @BeforeEach
//   private void setUp() {
//     MockitoAnnotations.openMocks(this);
//   }

//   @Test
//   void testGetQuote() throws Exception {
//     Quote quote = Quote.builder()//
//         .currentPrice(234.23d)//
//         .change(234.234d)//
//         .percentageChange(5678.456d)//
//         .highPriceOfTheDay(23.543d)//
//         .lowPriceOfTheDay(62.987d)//
//         .openPriceOfTheDay(456.876d)//
//         .previousClosePrice(8765.456d)//
//         .timeStamp(345678L)//
//         .build();

//     when(finnhubService.getquote("TSLA")).thenReturn(quote);

//     mockMvc.perform(get("/stock/finnhub/api/v1/quote?symbol=AAPL"))//
//         .andExpect(status().isOk())//
//         .andExpect(jsonPath("$.syscode").value("000000"))//
//         .andExpect(jsonPath("$.message").value("OK"))//
//         .andExpect(jsonPath("$.data.c").value(234.23d))//
//         .andExpect(jsonPath("$.data.d").value(234.234d))
//         .andExpect(jsonPath("$.data.dp").value(5678.456d))
//         .andExpect(jsonPath("$.data.h").value(23.543d))//
//         .andExpect(jsonPath("$.data.l").value(62.987d))//
//         .andExpect(jsonPath("$.data.o").value(456.876d))//
//         .andExpect(jsonPath("$.data.pc").value(8765.456d))//
//         .andExpect(jsonPath("$.data.t").value(345678L));
//   }

//   @Test
//   void testGetStock() throws Exception {
//     Stock stock = Stock.builder()//
//         .country("USA")//
//         .currency("USD")//
//         .estimateCurrency("USD")//
//         .exchange("NASDAQ NMS - GLOBAL MARKET")//
//         .finnhubIndustry("Technology")//
//         .ipo("1980-12-12")//
//         .logo(
//             "https://static2.finnhub.io/file/publicpublicdatany/finnhubimage/stock_logo/AAPL.svg")//
//         .marketCapitalization(2889947.90582d)//
//         .name("Apple Inc")//
//         .phone("14089961010")//
//         .shareOutstanding(15441.88)//
//         .ticker("AAPL")//
//         .weburl("http://www.apple.com/")//
//         .build();

//     when(finnhubService.getStock("AAPL")).thenReturn(stock);

//     mockMvc.perform(get("/stock/finnhub/api/v1/profile2?symbol=AAPL"))//
//     .andExpect(status().isOk())//
//     .andExpect(jsonPath("$.syscode").value("000000"))//
//     .andExpect(jsonPath("$.message", "OK"))//
//     .and
//   }
// }


