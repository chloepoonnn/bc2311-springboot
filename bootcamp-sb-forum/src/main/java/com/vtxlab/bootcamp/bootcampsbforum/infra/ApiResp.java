package com.vtxlab.bootcamp.bootcampsbforum.infra;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ApiResp<T> {

  private String code;

  private String message;

  private T data;
}
