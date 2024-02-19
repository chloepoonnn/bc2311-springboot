package com.vtxlab.bootcamp.bootcampsbcalculator;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vtxlab.bootcamp.bootcampsbcalculator.controller.ClientController;
import com.vtxlab.bootcamp.bootcampsbcalculator.model.Response;
import com.vtxlab.bootcamp.bootcampsbcalculator.service.CalculationService;

@WebMvcTest(ClientController.class)
public class CalculationControllerTest {
  @Autowired
  private MockMvc mockMvc; // similar to postman

  // @Autowired // You cannot autowired service bean in WebMvcTest env.
  @MockBean
  private ClientController clientController;

  @MockBean
  private CalculationService calculationService;

  @Test
  void testCalculateByRequestParam() throws Exception {
    String returnValue = "20";
    Mockito.when(calculationService.doOperation("12", "8", "add"))
        .thenReturn(returnValue);
    mockMvc
        .perform(MockMvcRequestBuilders.get(
            "/api/vi/calculation/x/{x}/y/{y}/operation/{operation}", "12", "8",
            "add"))//
        .andExpect(MockMvcResultMatchers.status().isOk()) //
        .andExpect(MockMvcResultMatchers.content().string(returnValue)) //
        .andDo(MockMvcResultHandlers.print()); //
  }

  @Test
  void testCalculateByRequestBody() throws Exception {
    String returnValue = "20";
    String contentString = new ObjectMapper().writeValueAsString(new Response("30","10","sub",null));
    Mockito.when(calculationService.doOperation("30", "10", "sub"))//
        .thenReturn(returnValue);
    mockMvc.perform(MockMvcRequestBuilders.post("/api/vi/calculation")//
        .contentType(MediaType.APPLICATION_JSON) //
        .content(contentString)) //
        .andExpect(MockMvcResultMatchers.jsonPath("$.x").value("40")) //
        .andExpect(MockMvcResultMatchers.jsonPath("$.y").value("2")) //
        .andExpect(MockMvcResultMatchers.jsonPath("$.operation").value("div")) //
        .andExpect(MockMvcResultMatchers.status().isOk()) //
        .andExpect(MockMvcResultMatchers.content().string(returnValue)) //
        .andDo(MockMvcResultHandlers.print()); //
  }

  @Test
  void testCalculateByPathVariable() throws Exception {
    String returnValue = "20";
    Mockito.when(calculationService.doOperation("40", "2", "div"))
        .thenReturn(returnValue);

    mockMvc
        .perform(MockMvcRequestBuilders.get(
            "/api/vi/calculation/x/{x}/y/{y}/operation/{operation}", "40", "2",
            "div"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(returnValue))
        .andExpect(MockMvcResultMatchers.jsonPath("$.x").value("40"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.y").value("2"))
        .andExpect(MockMvcResultMatchers.jsonPath("$.operation").value("div"))
        .andDo(MockMvcResultHandlers.print());
  }
}
