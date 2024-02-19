package com.vtxlab.bootcamp.bootcampsbforum.infra;

public enum Scheme {
  HTTPS, HTTP,;

  public String lowerCaseName() {
    return this.name().toLowerCase();
  }
}
