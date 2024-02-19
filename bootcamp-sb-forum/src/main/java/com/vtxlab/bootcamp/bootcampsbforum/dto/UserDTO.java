package com.vtxlab.bootcamp.bootcampsbforum.dto;

import lombok.Getter;
import lombok.Setter;

// User -> UserDto (ignore some fields)
@Getter
@Setter
public class UserDTO {
  private int id;
  private String email;
  private String phone;
}
