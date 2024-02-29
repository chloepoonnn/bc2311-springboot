package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.bootcamp.bootcampsbforum.mapper.GovMapper;
import com.vtxlab.bootcamp.bootcampsbforum.model.Comments;
import com.vtxlab.bootcamp.bootcampsbforum.model.User;
import com.vtxlab.bootcamp.bootcampsbforum.service.CommentService;
import com.vtxlab.bootcamp.bootcampsbforum.service.ForumDatabaseService;
import com.vtxlab.bootcamp.bootcampsbforum.service.GovService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;

@Service
public class GovServiceHolder implements GovService {

  @Autowired
  private UserService userService;

  @Autowired
  private ForumDatabaseService forumDatabaseService;

  @Autowired
  private CommentService commentService;
  @Autowired
  private GovMapper govMapper;
  // private GovMapper govMapper = new GovMapper();

  @Override
  public List<User> getUsers() {
    // Call JPH
    List<User> users = userService.getUsers();
    // Clear DB
    forumDatabaseService.deleteAllUsers();
    // save all
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity> userEntities =
        users.stream()//
            .map(e -> govMapper.mapEntity(e))//
            .collect(Collectors.toList());
    forumDatabaseService.saveUsers(userEntities);
    // return
    return users;
  }

  @Override
  public User getUser(int id) {
    User user = userService.getUser(id);
    if (user != null) {
      // convert dto user to entitiy user
      forumDatabaseService.saveUser(govMapper.mapEntity(user));
    }
    return user;
  }

  @Override
  public Comments getComment(String email) {
    Comments comments = commentService.getComment(email);
    if (comments != null) {
      // convert dto user to entitiy user
      forumDatabaseService.saveComment(govMapper.mapCommentsEntity(comments));
    }
    return comments;
  }

  public List<Comments> getComments() {
    // Call JPH
    List<Comments> comments = commentService.getComments();
    // Clear DB
    forumDatabaseService.deleteAllUsers();
    // save all
    List<com.vtxlab.bootcamp.bootcampsbforum.entity.CommentsEntity> commentsEntities =
        comments.stream()//
            .map(e -> govMapper.mapCommentsEntity(e))//
            .collect(Collectors.toList());
    forumDatabaseService.saveComments(commentsEntities);
    // return
    return comments;
  }
}

