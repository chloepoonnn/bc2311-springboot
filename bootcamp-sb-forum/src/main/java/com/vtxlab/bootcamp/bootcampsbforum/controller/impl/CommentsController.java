package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.CommentOperation;
import com.vtxlab.bootcamp.bootcampsbforum.model.Comments;
import com.vtxlab.bootcamp.bootcampsbforum.service.CommentService;

@RestController
@RequestMapping(value = "/api/v1")
public class CommentsController implements CommentOperation {

  @Autowired
  private CommentService commentService;

  @Override
  public List<Comments> getComments() {
    return commentService.getComments();
  }

}
