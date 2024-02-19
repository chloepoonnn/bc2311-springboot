package com.vtxlab.bootcamp.bootcampsbfakedatabase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl.DatabaseController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

// only call what i wanna call
// @SpringBootTest (full scale)
// build up a Springcontext under that spring enviornment
// etc this evn only for test controller
// Inject the web layer related bean to context only
// so, in this test env, Component scan will ignore @Service, @Configuration, etc.
// but includes controller bean, mockmvc beans, etc.

// @WebMvcTest(DatabaseController.class)
// @ContextConfiguration(classes = BootcapSbFakeDatabaseApplication.class)
@WebMvcTest(DatabaseController.class)
// @SpringBootTest


class DatabaseControllerTest {

  @Autowired
  private MockMvc mockMvc; // similar to Postman
  // have mockMvc from @WebMvcTest

  // @Autowired // Cannot @Autowired service bean in WebMvcTest env, really hv this object in this context
  // assume the context have this object
  // similar to @Mock, m call kui jau mo function
  // because Controller Bean need to autowired catDatabaseService
  @MockBean
  private CatDatabaseService catDatabaseService;

  // @MockBean
  // private String tutorName;


  @Test
  void testGetCat() throws Exception {
    // assumption
    Cat mockedReturnCat = new Cat("ABCD", 3);
    // when
    Mockito.when(catDatabaseService.getCatFromStaticMemory(1))
        .thenReturn(mockedReturnCat);
    // assert
    mockMvc.perform(get("/api/v1/cat/{idx}", "1")).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.name").value("ABCD"))
        .andExpect(jsonPath("$.age").value(3)).andDo(print()); // similar to sysout, toString()
  }

  @Test
  void testsetCatToStaticMemory() throws Exception {
    Cat mockedReturnCat = new Cat("Sally", 99);

    Mockito.when(catDatabaseService.setCatToStaticMemory(1, mockedReturnCat))
        .thenReturn(mockedReturnCat);
    mockMvc
        .perform(
            post("/api/v1/cat/{idx}", 1).contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Sally\", \"age\": 99}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.name").value("Sally"))
        .andExpect(jsonPath("$.age").value(99)).andDo(print());
  }

  @Test
  void testdeleteCatFromStaticMemory() throws Exception {

    Mockito.when(catDatabaseService.deleteCatFromStaticMemory(1))
        .thenReturn(true);
    mockMvc.perform(delete("/api/v1/cat/{idx}", 1)).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$").value(true)).andDo(print());
  }

  @Test
  void testupdateCatFromStaticMemory() throws Exception {
    Cat mockedReturnCat = new Cat("ABCD", 3);

    Mockito
        .when(catDatabaseService.updateCatFromStaticMemory(1, mockedReturnCat))
        .thenReturn(mockedReturnCat);
    mockMvc
        .perform(
            put("/api/v1/cat/{idx}", 1).contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"ABCD\", \"age\": 3}"))
        .andExpect(status().isOk()).andExpect(jsonPath("$.name").value("ABCD"))
        .andExpect(jsonPath("$.age").value(3)).andDo(print());
  }

  @Test
  void testpatchCatName() throws Exception {
    Cat mockedReturnCat = new Cat("Sally", 99);

    Mockito.when(catDatabaseService.patchCatName(1, "Sally"))
        .thenReturn(mockedReturnCat);
    mockMvc.perform(patch("/api/v1/cat/{idx}/name/{name}", 1, "Sally"))
        .andExpect(status().isOk())//
        .andExpect(jsonPath("$.name").value("Sally"))//
        .andExpect(jsonPath("$.age").value(99))//
        .andDo(print());
  }

  @Test
  void testpatchCatAge() throws Exception {
    Cat mockedReturnCat = new Cat("ABCD", 3);

    Mockito.when(catDatabaseService.patchCatAge(1, 5))
        .thenReturn(mockedReturnCat);
    mockMvc.perform(patch("/api/v1/cat/{idx}/age/{age}", 1, 5))//
        .andExpect(status().isOk())//
        .andExpect(jsonPath("$.name").value("ABCD"))//
        .andExpect(jsonPath("$.age").value(3))//
        .andDo(print());
  }

  @Test
  void testWrongPath() throws Exception {
    // wrong path
    mockMvc.perform(get("/api/v1/cat2/{idx}", "1"))
        .andExpect(status().isNotFound()).andDo(print()); // similar to sysout, toString()
  }
}

