package com.vtxlab.bootcamp.bootcampsbforum.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.vtxlab.bootcamp.bootcampsbforum.dto.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.UserPostRequestDTO.PostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.CommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.PostEntity;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.Comments;
import com.vtxlab.bootcamp.bootcampsbforum.model.Posts;
import com.vtxlab.bootcamp.bootcampsbforum.model.User;

// When server starts, Spring ensure modelMapper is ready before creating GovMapper object
@Component
public class GovMapper {

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private PostMapper postMapper;

  @Autowired
  private PostEntity postEntity;

  public UserDTO map(User user) {
    return this.modelMapper.map(user, UserDTO.class);
  }

  public com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity mapEntity(
      User user) {
    return com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity.builder()//
        .name(user.getName()) //
        .username(user.getUsername()).website(user.getWebsite())//
        .addrLat(user.getAddress().getGeo().getLatitude())//
        .addrLong(user.getAddress().getGeo().getLongitude())//
        .email(user.getEmail()) //
        .phone(user.getPhone()) //
        .street(user.getAddress().getStreet())//
        .city(user.getAddress().getCity())//
        .suite(user.getAddress().getSuite())//
        .zipcode(user.getAddress().getZipcode())//
        .cName(user.getCompany().getName())//
        .cCatchPhrase(user.getCompany().getCatchPhrase())//
        .cBusService(user.getCompany().getBusService())//
        .build();
  }

  public com.vtxlab.bootcamp.bootcampsbforum.entity.CommentsEntity mapCommentsEntity(
      Comments comment) {
    return this.modelMapper.map(comment,
        com.vtxlab.bootcamp.bootcampsbforum.entity.CommentsEntity.class);
  }


  public UserPostDTO map(User user, List<Posts> posts) {

    List<PostDTO> postDTOs = posts.stream() //
        .filter(e -> e.getUserId() == user.getId()) //
        .map(e -> {
          return PostDTO.builder() //
              .id(e.getId()) //
              .title(e.getTitle()) //
              .body(e.getBody())//
              .build();
        }).collect(Collectors.toList());

    return UserPostDTO.builder() //
        .id(user.getId()) //
        .username(user.getUsername()) //
        .email(user.getEmail()) //
        .phone(user.getPhone()) //
        .postDTOs(postDTOs) //
        .build();
  }

  public UserEntity mapEntity(UserPostRequestDTO dto) {

    UserEntity userEntity = modelMapper.map(dto, UserEntity.class);
    // List<PostRequestDTO> postRequestDTO = dto.getPosts();

    List<PostEntity> postEntities = dto.getPosts().stream() //
        .map(e -> {
          PostEntity postEntity = PostEntity.builder().title(e.getTitle())
              .body(e.getBody()).build();
          postEntity.setUser(userEntity);
          return postEntity;
        }).collect(Collectors.toList());
    userEntity.setPosts(postEntities);
    return userEntity;
  }

  // ModelMapper mm = new ModelMapper();

  // ModelMapper mm = new ModelMapper();
  // map all fields by attributes names
  // UserPostDTO userPostDTO = this.modelMapper.map(user, UserPostDTO.class);
  // userPostDTO.setPostDTOs(postDTOs);
  // return userPostDTO;


  public UserCommentDTO mapToUserCommentDTO(User user,
      List<Comments> comments) {

    List<CommentDTO> commentDTOs = comments.stream() //
        .filter(e -> e.getEmail() == user.getEmail()) //
        .map(e -> {
          return CommentDTO.builder() //
              .id(e.getId()) //
              .name(e.getName()) //
              .email(e.getEmail()) //
              .body(e.getBody()) //
              .build();
        }).collect(Collectors.toList());

    return UserCommentDTO.builder() //
        .id(user.getId()) //
        .username(user.getName()) //
        .email(user.getEmail()) //
        .build();

  }
}
