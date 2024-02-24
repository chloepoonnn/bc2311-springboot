package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.GovOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.UserDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserCommentDTO;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.UserPostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.CommentService;
import com.vtxlab.bootcamp.bootcampsbforum.service.GovService;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostsService;

@RestController
@RequestMapping(value = "/gov/api/v1")
public class GovController implements GovOperation {

  @Autowired
  private GovService govService;

  @Autowired
  private PostsService postService;

  @Autowired
  private CommentService commentService;
  // @Autowired
  // private GovMapper govMapper;

  @Autowired
  private ModelMapper modelMapper;

  @Override
  public ApiResp<List<UserPostDTO>> getUsers() {
    List<UserPostDTO> userPostDTOs = govService.getUsers().stream()//
        .map(e -> {
          List<PostDTO> postDTOs = postService.getPosts().stream()//
              .filter(p -> p.getId() == e.getId())//
              .map(p -> {
                return PostDTO.builder()//
                    .id(p.getId())//
                    .title(p.getTitle())//
                    .body(p.getBody())//
                    .build();
              }).collect(Collectors.toList());

          return UserPostDTO.builder()//
              .id(e.getId())//
              .username(e.getUsername())//
              .email(e.getEmail())//
              .phone(e.getPhone())//
              .postDTOs(postDTOs)//
              .build();
        }).collect(Collectors.toList());

    return ApiResp.<List<UserPostDTO>>builder()//
        .code(Syscode.OK.getCode())//
        .message(Syscode.OK.getMessage())//
        .data(userPostDTOs)//
        .build();
  }

  @Override
  public ApiResp<UserPostDTO> getUser(int userId) {
    // 1. User Service
    // 2. Post Service
    // 3. relate the user and post
    // 4. set DTO object and return

    User user = govService.getUser(userId); // call JPH + save DB

    List<PostDTO> postDTOs = postService.getPosts().stream()//
        .filter(e -> e.getId() == userId)//
        .map(e -> {
          return PostDTO.builder()//
              .id(e.getId())//
              .title(e.getTitle())//
              .body(e.getBody())//
              .build();
        }).collect(Collectors.toList());

    UserPostDTO userPostDTO = UserPostDTO.builder()//
        .id(user.getId())//
        .email(user.getEmail())//
        .phone(user.getPhone())//
        .postDTOs(postDTOs)//
        .build();

    return ApiResp.<UserPostDTO>builder()//
        .code(Syscode.OK.getCode())//
        .message(Syscode.OK.getMessage())//
        .data(userPostDTO)//
        .build();
    // Optional<UserPostDTO> userPostDTO = userService.getUsers().stream() //
    // .filter(e -> e.getId() == userId) //
    // .map(e -> {
    // List<Posts> posts = postService.getPosts();
    // return GovMapper.map(e, posts);
    // }).findFirst();
  }

  @Override
  public ApiResp<List<UserCommentDTO>> getUserComments(int email) {
    User user = govService.getUser(email);

    List<UserCommentDTO> userCommentDTOs = commentService.getComments().stream()
        .filter(e -> e.getEmail() == user.getEmail())
        .map(comment -> modelMapper.map(comment, UserCommentDTO.class))
        .collect(Collectors.toList());

    return ApiResp.<List<UserCommentDTO>>builder() // Amended return type
        .code(Syscode.OK.getCode()).message(Syscode.OK.getMessage())
        .data(userCommentDTOs).build();
  }





  @Override
  public String testNPE() {
    String s = null;
    return s.concat("hello");
  }

  @Override
  public UserDTO testModelMapper() {
    User user = User.builder()//
        .id(3)//
        .email("abc@gmail.com")//
        .phone("98765498")//
        .username("JackLau")//
        .name("Jack")//
        .build();
    return modelMapper.map(user, UserDTO.class);
  }


  // @Override
  // public ApiResp<UserPostDTO> getUser2(String userId) throws ResourceNotFound {
  // // TODO Auto-generated method stub
  // throw new UnsupportedOperationException("Unimplemented method 'getUser2'");
  // }

}
