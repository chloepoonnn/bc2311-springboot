package com.vtxlab.bootcamp.crypto.infra;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiRes<T> {
  private int code;

  private String message;

  private T data;


}
