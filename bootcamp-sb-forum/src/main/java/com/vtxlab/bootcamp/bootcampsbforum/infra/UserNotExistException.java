package com.vtxlab.bootcamp.bootcampsbforum.infra;

public class UserNotExistException extends BusinessException {
  Syscode syscode;

  public UserNotExistException(Syscode syscode) {
    super(syscode);
  }

}
