package com.vtxlab.bootcamp.bootcampsbforum.infra;

public class ResourceNotFound extends BusinessRunTimeException {

  public ResourceNotFound(Syscode sysCode) {
    super(sysCode);
  }

}
