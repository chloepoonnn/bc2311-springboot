package com.vtxlab.bootcamp.bootcampsbforum.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Comments {

  private int postId;

  private int id;

  private String name;

  private String email;

  private String body;

}
