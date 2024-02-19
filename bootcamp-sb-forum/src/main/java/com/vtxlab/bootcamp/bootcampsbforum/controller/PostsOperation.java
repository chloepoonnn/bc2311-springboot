package com.vtxlab.bootcamp.bootcampsbforum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.vtxlab.bootcamp.bootcampsbforum.model.Posts;

public interface PostsOperation {
  @GetMapping(value = "/getposts")
  List<Posts> getPosts();
}
