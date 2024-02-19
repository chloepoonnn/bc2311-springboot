package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.UserOperation;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.model.User;
import com.vtxlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;


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
  public ApiResp<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>> getUsersByLatGtrThan(
      String latitude) {
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> users =
        userService.getUsersByAddrLatGreaterThan(0.0);
    return ApiResp.<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(users) //
        .build();
  }

  @Override
  public ApiResp<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>> getUsersByEmailAndPhone(
      String email, String phone) {
    Sort sortByEmailDesc = Sort.by("email").ascending();
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> users =
        userService.getAllByEmailOrPhone(email, phone, sortByEmailDesc);
    return ApiResp.<List<com.vtxlab.bootcamp.bootcampsbforum.entity.User>>builder() //
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(users) //
        .build();
  }


  @Override
  public ApiResp<com.vtxlab.bootcamp.bootcampsbforum.entity.User> updateUser(
      @PathVariable Long userId,
      @RequestBody com.vtxlab.bootcamp.bootcampsbforum.entity.User user) {

    return ApiResp.<com.vtxlab.bootcamp.bootcampsbforum.entity.User>builder() //  
        .code(Syscode.OK.getCode()) //
        .message(Syscode.OK.getMessage()) //
        .data(userService.updateUserById(userId, user)) //
        .build();
  }


}
