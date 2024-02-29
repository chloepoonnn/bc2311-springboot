package com.vtxlab.bootcamp.bootcampsbforum.infra;

public class RequestParamException extends BusinessRunTimeException {
  public RequestParamException() {
   
  }

  public RequestParamException(Syscode sysCode) {
    super(sysCode);
  }

}
