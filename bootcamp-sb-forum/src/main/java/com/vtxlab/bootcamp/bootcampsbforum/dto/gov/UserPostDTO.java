package com.vtxlab.bootcamp.bootcampsbforum.dto.gov;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPostDTO {
  private int id;
  
  private String username;

  private String email;

  private String phone;

  @JsonProperty(value = "posts")
  private List<PostDTO> postDTOs;
}
