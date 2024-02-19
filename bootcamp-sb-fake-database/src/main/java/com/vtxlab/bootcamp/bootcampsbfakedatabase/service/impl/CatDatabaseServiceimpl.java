package com.vtxlab.bootcamp.bootcampsbfakedatabase.service.impl;

import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.database.CatDatabase;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;

@Service
public class CatDatabaseServiceimpl implements CatDatabaseService {

  // Objectives of Service
  // 1. Data source
  // 2. The service you are going to provide

  @Override
  public Cat getCatFromStaticMemory(int index) {
    return CatDatabase.getCat(index);
  }

  @Override
  public Cat[] getCats() {
    return CatDatabase.getCats();
  }


  @Override
  public Cat setCatToStaticMemory(int index, Cat cat) {
    return CatDatabase.setCat(index, cat);
  }

  @Override
  public Boolean deleteCatFromStaticMemory(int idx) {
    return CatDatabase.deleteCat(idx) != null;
  }

  @Override
  public Cat updateCatFromStaticMemory(int idx, Cat cat) {
    if (getCatFromStaticMemory(idx) == null)
      return null;
    return CatDatabase.updateCat(idx, cat);
  }

  @Override
  public Cat patchCatName(int idx, String name) {
    Cat cat = getCatFromStaticMemory(idx);
    if (cat == null)
      return null;
    return CatDatabase.patchCatName(idx, name);
  }

  @Override
  public Cat patchCatAge(int idx, int age) {
    return CatDatabase.patchCatAge(idx, age);
  }
}
