package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.model.Comments;

public interface CommentService {
  List<Comments> getComments();

  Comments getComment(String email);
}
