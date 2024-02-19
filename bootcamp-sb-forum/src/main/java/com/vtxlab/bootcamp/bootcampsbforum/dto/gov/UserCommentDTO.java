package com.vtxlab.bootcamp.bootcampsbforum.dto.gov;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserCommentDTO {
  private long id;
  
  private String username;

  private String email;

  private String phone;

  @JsonProperty(value = "comments") // if dun write this thsi json column will become commentDTOs
  private List<CommentDTO> commentDTOs;

}
