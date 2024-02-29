package com.vtxlab.bootcamp.bootcampsbfinnhub.infra;

public enum Scheme {
  HTTPS, //
  HTTP,;

  public String lowercaseName() {
    return this.name().toLowerCase();
  }
}
