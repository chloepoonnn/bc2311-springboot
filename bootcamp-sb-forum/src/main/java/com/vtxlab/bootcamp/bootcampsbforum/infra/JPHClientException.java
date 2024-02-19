package com.vtxlab.bootcamp.bootcampsbforum.infra;

public class JPHClientException extends BusinessRunTimeException {

  public JPHClientException(Syscode syscode) {
    super(syscode);
  }
  
}

