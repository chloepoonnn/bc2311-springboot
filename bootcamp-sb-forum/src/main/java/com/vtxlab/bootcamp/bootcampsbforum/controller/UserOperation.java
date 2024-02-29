package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ApiResp;
import com.vtxlab.bootcamp.bootcampsbforum.model.User;

public interface UserOperation {

  @GetMapping(value = "/getusers")
  List<User> getUsers();

  // @GetMapping(value = "/users/byName")
  // com.vtxlab.bootcamp.bootcampsbforum.entity.User findByUsername(
  // @RequestParam(value = "username") String username);

  @GetMapping(value = "/users/count")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResp<Long> countUserByName(@RequestParam(value = "prefix") String prefix);

  @GetMapping(value = "/users/lat/{lat}")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResp<List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity>> getUsersByLatGtrThan(
      @PathVariable(value = "lat") String latitude);

  @GetMapping(value = "/users/email/{email}/phone/{phone}")
  @ResponseStatus(value = HttpStatus.OK)
  ApiResp<List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity>> getUsersByEmailAndPhone(
      @PathVariable String email, @PathVariable String phone);


  @PutMapping
  @ResponseStatus(value = HttpStatus.OK)
  ApiResp<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> updateUser(@PathVariable Long userId,
      @RequestBody com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity email);
}
