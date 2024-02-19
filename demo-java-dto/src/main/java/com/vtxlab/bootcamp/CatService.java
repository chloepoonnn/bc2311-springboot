package com.vtxlab.bootcamp;

import java.util.ArrayList;
import java.util.List;
import com.vtxlab.bootcamp.model.Cat;

public class CatService {

  public Cat getCat() {
    return new Cat("Tom", 9);
  }

  public List<Cat> getCats() {
    List<Cat> cats = new ArrayList<>();
    cats.add(new Cat("Tom", 9));
    cats.add(new Cat("Jerry", 8));
    cats.add(new Cat("Jack", 3));
    cats.add(new Cat("Micky", 5));
    return cats;
  }

  // public List<Cat> callJPH() {
  // return List.of(new Cat("Tom", 9), new Cat("Jerry", 8));
  // }

  public List<Cat> getCatList() throws Exception {
    List<Cat> cats = new ArrayList<>();
    try {
      cats = callJPH();
    } catch (Exception e) {
      throw new Exception();
    }
    return cats;
  }

  public Cat getCatList2(int index) throws Exception {
    if (index < 0)
      throw new IllegalAccessException();
    List<Cat> cats = new ArrayList<>();
    try {
      cats = callJPH();
      if (cats != null && cats.size() != 0 && index < cats.size())
        return cats.get(index);
      throw new Exception();
    } catch (Exception e) {
      throw new Exception();
    }
  }

  public List<Cat> callJPH() throws Exception {
    return List.of(new Cat("Tom", 9), new Cat("Jerry", 8));
  }
}
