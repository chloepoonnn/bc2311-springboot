package com.vtxlab.bootcamp.bootcampsbcalculator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculationService;

@WebMvcTest(CalculationService.class)
public class CalculationServiceTest {
@Autowired
private MockMvc mockMvc;

@MockBean
private CalculationService calculationService;

@Test
  void testDoOperation() throws Exception {
    String returnValue = "20";
    Mockito.when(calculationService.doOperation("12", "8", "add"))
        .thenReturn(returnValue);
    mockMvc
        .perform(get("/api/vi/calculation/x/{x}/y/{y}/operation/{operation}",
            "12", "8", "add"))//
        .andExpect(status().isOK()) //
        .andExpect(content().string(returnValue)) //
        .andDo(print()); //
  }
}
