package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import org.springframework.data.domain.Sort;
import com.vtxlab.bootcamp.bootcampsbforum.dto.UserPostRequestDTO;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.User;

public interface UserService {

  List<User> getUsers();

  User getUser(int index);

  List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> getAllByEmailOrPhone(
      String email, String phone, Sort sort);

  List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> getUsersByAddrLatGreaterThan(
      Double latitude);

  Long countUserByName(String prefix);

  void updateUserEmailById(Long id, String email);

  public com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity updateUserById(
      Long userId, com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity newUser);

      public UserEntity save(UserPostRequestDTO userPostRequestDTO);
}
