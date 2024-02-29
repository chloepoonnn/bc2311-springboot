package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.entity.CommentsEntity;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;
import com.vtxlab.bootcamp.bootcampsbforum.model.Comments;

public interface ForumDatabaseService {

  List<UserEntity> saveUsers(List<UserEntity> users);

  void deleteAllUsers();
  
  UserEntity saveUser(UserEntity user);

  List<CommentsEntity> saveComments(List<CommentsEntity> commentsEntities);
  
  void deleteAllComments();

  CommentsEntity
   saveComment(CommentsEntity comments);
}
