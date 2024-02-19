package com.vtxlab.bootcamp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.vtxlab.bootcamp.dto.CatDto;
import com.vtxlab.bootcamp.model.Cat;

public class CatController {

  public CatDto getCat() {
    Cat cat = new CatService().getCat();
    String description =
        "Cat Name: " + cat.getName() + ", Cat Age: " + cat.getAge();
    CatDto catDto = new CatDto(description, "Apple");
    return catDto;
  }

  public Map<String, Integer> getCats() {
    // call getCats()
    List<Cat> catList = new CatService().getCats();
    Map<String, Integer> catMap = new HashMap<>();
    catMap = catList.stream()
        .collect(Collectors.toMap(e -> e.getName(), e -> e.getAge()));
    return catMap;
  }

  public List<Cat> getCatList() {
    try{
          return new CatService().getCats();
    } catch (Exception e) {
      return null;
    }
  }
}
