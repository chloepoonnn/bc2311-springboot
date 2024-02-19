package com.vtxlab.bootcamp.bootcampsbfakedatabase.database;

import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;

public class CatDatabase {

  private static Cat[] cats;

  private static final int dbLength = 10;

  static {
    cats = new Cat[dbLength];
    cats[0] = new Cat("John", 2);
    cats[1] = new Cat("Mary", 1);
  }

  public static Cat[] getCats() {
    return cats;
  }

  public static Cat getCat(int index) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();
    return cats[index];
  }

  public static Cat setCat(int index, Cat cat) {
    if (index < 0 || index > dbLength - 1)
      throw new IllegalArgumentException();
    cats[index] = cat;
    return cat;
  }

  public static Cat deleteCat(int idx) {
    Cat deleted = cats[idx]; // remove the pointer -> it will disappear eventually in the heep memory
    cats[idx] = null;
    return deleted;
  }

  public static Cat updateCat(int idx, Cat cat) {
    if (idx <= dbLength)
      cats[idx] = cat;
    return cats[idx];
  }

  public static Cat patchCatName(int idx, String name) {
    if (idx <= dbLength)
      cats[idx].setName(name);
    return cats[idx];
  }

  public static Cat patchCatAge(int idx, int age) {
    if (idx <= dbLength)
      cats[idx].setAge(age);
    return cats[idx];
  }
}
