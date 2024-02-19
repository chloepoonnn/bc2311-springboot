package com.vtxlab.bootcamp.crypto.infra;

public enum Scheme {
  HTTPS, //
  HTTP,;

  public String lowercaseName() {
    return this.name().toLowerCase();
  }
}
