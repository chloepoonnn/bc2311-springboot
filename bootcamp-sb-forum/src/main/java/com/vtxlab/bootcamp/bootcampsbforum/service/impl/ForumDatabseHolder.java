package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbforum.entity.CommentsEntity;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.repository.CommentsRepository;
import com.vtxlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;

@Service
public class ForumDatabseHolder implements ForumDatabaseService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CommentsRepository commentsRepository;

  @Override
  public List<UserEntity> saveUsers(List<UserEntity> users) {
    return userRepository.saveAll(users);
  }

  @Override
  public void deleteAllUsers() {
    userRepository.deleteAll();
  }

  @Override
  public UserEntity saveUser(UserEntity user) {
    return userRepository.save(user);
  }

  @Override
  public List<CommentsEntity> saveComments(List<CommentsEntity> comments) {
    return commentsRepository.saveAll(comments);
  }

  @Override
  public void deleteAllComments() {
    commentsRepository.deleteAll();
  }

  @Override
  public CommentsEntity saveComment(CommentsEntity comments) {
    return commentsRepository.save(comments);
  }
  
}
