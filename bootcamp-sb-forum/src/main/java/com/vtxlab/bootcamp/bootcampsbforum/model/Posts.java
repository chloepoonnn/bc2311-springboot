package com.vtxlab.bootcamp.bootcampsbforum.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Posts {
  
  private int userId;

  private int id;

  private String title;

  private String body;
}
