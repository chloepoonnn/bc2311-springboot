package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.UserOperation;
import com.vtxlab.bootcamp.bootcampsbforum.dto.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.User;
import com.vtxlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping(value = "/api/v1")

public class UserController implements UserOperation {

  @Autowired
  private UserService userService;

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<User> getUsers() {
    return userService.getUsers();
  }


  @Override
  public ApiResp<Long> countUserByName(String prefix) {
    return ApiResp.<Long>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userService.countUserByName(prefix)) //
        .build();
  }

  @Override
  public ApiResp<List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity>> getUsersByLatGtrThan(
      String latitude) {
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> users =
        userService.getUsersByAddrLatGreaterThan(0.0);
    return ApiResp.<List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity>>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(users) //
        .build();
  }

  @Override
  public ApiResp<List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity>> getUsersByEmailAndPhone(
      String email, String phone) {
    Sort sortByEmailDesc = Sort.by("email").ascending();
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> users =
        userService.getAllByEmailOrPhone(email, phone, sortByEmailDesc);
    return ApiResp.<List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity>>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(users) //
        .build();
  }


  @Override
  public ApiResp<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> updateUser(
      @PathVariable Long userId,
      @RequestBody com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity user) {

    return ApiResp.<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userService.updateUserById(userId, user)) //
        .build();
  }

  @PostMapping(value = "/user")
  @ResponseStatus(value = HttpStatus.OK)
  public ApiResp<UserEntity> save(UserPostRequestDTO userRequestDTO) {
    return ApiResp.<UserEntity>builder() //
        .ok() //
        .data(userService.save(userRequestDTO)) //
        .build();
  }

}
