package com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.DatabaseOperation;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@RestController // (@Controller + @ResponseBody)
// create object of this class, and put it into spring context
// @RestController is combination of @Controller and @ResponseBody
@RequestMapping(value = "/api/v1")
public class DatabaseController implements DatabaseOperation {

  // Before Server Start
  @Autowired // dependency injection 自動裝配
  // @Autowired(required = false) -> allow the server to work although it is nullpointer,
  // default successful injection -> can run
  // assign create new object -> when called jau put new object into the place i assigned
  // if no @Autowired -> Nullpointer
  private CatDatabaseService catDatabaseService; // object reference



  @Override
  public Cat getCat(int index) {
    // return new CatDatabaseService().getCatFromStaticMemory(index)
    return catDatabaseService.getCatFromStaticMemory(index);
  }

  @Override
  public List<Cat> getCats() {
    return Arrays.stream(catDatabaseService.getCats())//
        .collect(Collectors.toList());
  }


  @Override
  public Cat getCat2(int index) {
    return catDatabaseService.getCatFromStaticMemory(index);
  }

  @Override
  public void setCat(int index, String name, int age) {
    catDatabaseService.setCatToStaticMemory(index, new Cat(name, age));
  }

  @Override
  public Cat createCat(int idx, Cat cat) {
    return catDatabaseService.setCatToStaticMemory(idx, cat);
  }

  @Override
  public Boolean deleteCat(int idx) {
    return catDatabaseService.deleteCatFromStaticMemory(idx);
  }

  @Override
  public Cat updateCat(int idx, Cat cat) {
    return catDatabaseService.updateCatFromStaticMemory(idx, cat);
  }

  @Override
  public Cat patchCatName(int idx, String name) {
    return catDatabaseService.patchCatName(idx, name);
  }

  @Override
  public Cat patchCatAge(int idx, int age) {
    return catDatabaseService.patchCatAge(idx, age);
  }
}


