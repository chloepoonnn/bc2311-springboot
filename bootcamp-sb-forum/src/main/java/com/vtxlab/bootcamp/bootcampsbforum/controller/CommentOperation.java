package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.vtxlab.bootcamp.bootcampsbforum.model.Comments;

public interface CommentOperation {
  @GetMapping(value = "/getcomments")
  List<Comments> getComments();
}
