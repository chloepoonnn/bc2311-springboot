package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.Getter;

@Getter

public enum Syscode {
  OK("000000", "OK."), //
  NOTFOUND("100000", "NOT FOUND."), //
  USER_NOT_EXIST("500000", "USER_NOT_EXIST"), //
  No_Such_Element("500001", "NoSuchElement"), //
  JPH_NOT_AVALIABLE("100001", "Json Place Holder API is unavaliable"),
  // runtime exception
  REST_CLIENT_EXCEPTION("900001", "RestClient Exception."), //
  NPE_EXCEPTION("200002", "NPE EXCEPTION"), //
  GENERAL_EXCEPTION("999999", "GENERAL EXCEPTION"), //
  REQUEST_PARAM_EXCEPTION("900002", "Invaild Request Parameter or Body.");

  private String code;

  private String message;

  private Syscode(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
