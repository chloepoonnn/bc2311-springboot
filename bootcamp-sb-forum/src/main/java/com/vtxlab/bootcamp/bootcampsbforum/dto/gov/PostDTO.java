package com.vtxlab.bootcamp.bootcampsbforum.dto.gov;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class PostDTO {
  private int id;

  private String title;

  private String body;
}
