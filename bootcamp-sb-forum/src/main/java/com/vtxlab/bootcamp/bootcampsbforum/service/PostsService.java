package com.vtxlab.bootcamp.bootcampsbforum.service;

import java.util.List;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.model.Posts;

public interface PostsService {

  List<Posts> getPosts();

  // List<PostDTO> getPostByUserid(int userId);
}
