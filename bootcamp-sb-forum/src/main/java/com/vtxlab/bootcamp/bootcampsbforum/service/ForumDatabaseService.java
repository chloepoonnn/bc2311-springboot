package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.entity.CommentsEntity;
import com.vtxlab.bootcamp.bootcampsbforum.entity.User;
import com.vtxlab.bootcamp.bootcampsbforum.model.Comments;

public interface ForumDatabaseService {

  List<User> saveUsers(List<User> users);

  void deleteAllUsers();
  
  User saveUser(User user);

  List<CommentsEntity> saveComments(List<CommentsEntity> commentsEntities);
  
  void deleteAllComments();

  CommentsEntity saveComment(CommentsEntity comments);
}
