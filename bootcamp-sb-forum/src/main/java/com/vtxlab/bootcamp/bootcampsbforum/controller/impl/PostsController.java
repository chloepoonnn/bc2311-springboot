package com.vtxlab.bootcamp.bootcampsbforum.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.bootcamp.bootcampsbforum.controller.PostsOperation;
import com.vtxlab.bootcamp.bootcampsbforum.model.Posts;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostsService;

@RestController
@RequestMapping(value = "/api/v1")
public class PostsController implements PostsOperation {

  @Autowired
  private PostsService postsService;

  @Override
  public List<Posts> getPosts() {
    return postsService.getPosts();
  }

}
