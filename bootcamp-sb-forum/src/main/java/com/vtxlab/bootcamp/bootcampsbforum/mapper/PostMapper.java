package com.vtxlab.bootcamp.bootcampsbforum.mapper;

import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.dto.UserPostRequestDTO.PostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;

@Component
public class PostMapper {

  public static PostEntity mapEntitiy(PostRequestDTO dto) {
    return new PostEntity(null, //
        dto.getTitle(), //
        dto.getBody(), //
        null);//
  }
  
}
