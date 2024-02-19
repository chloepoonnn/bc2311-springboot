package com.vtxlab.bootcamp.bootcampsbfakedatabase.service;

import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public interface CatDatabaseService {

  Cat getCatFromStaticMemory(int index);

  Cat[] getCats();
  
  Cat setCatToStaticMemory(int index, Cat cat);

  Cat updateCatFromStaticMemory(int idx, Cat cat);

  Boolean deleteCatFromStaticMemory(int idx);

  Cat patchCatName(int idx, String name);

  Cat patchCatAge(int idx, int age);
}
