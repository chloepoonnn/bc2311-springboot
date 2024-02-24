package com.vtxlab.bootcamp.bootcampsbforum.poly;
public class Cat implements Swimable, Flyable {
  @Override
  public void fly() {

  }

  @Override
  public void swim() {

  }

  public static void main(String[] args) {
    Cat cat = new Cat();
    Swimable swimableCat = cat;
    Flyable flyable = cat;
  }
}
