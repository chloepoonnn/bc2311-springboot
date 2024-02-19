package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbforum.dto.gov.PostDTO;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.infra.getUrl;
import com.vtxlab.bootcamp.bootcampsbforum.model.Posts;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostsService;

@Service
public class PostsJph implements PostsService {

  @Value(value = "${api.jph.domain}")
  private String domain;
  @Value(value = "${api.jph.endpoints.post}")
  private String postsEndpoint;

  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<Posts> getPosts() {
   RestTemplate restTemplate = new RestTemplate();
    String postUrl = getUrl.url(Scheme.HTTPS, domain, postsEndpoint);

    // try {
    Posts[] posts = restTemplate.getForObject(postUrl, Posts[].class);
    return Arrays.stream(posts) //
        .collect(Collectors.toList());
    // } catch (RestClientException e) {
    // throw new JPHClientException(Syscode.JPH_NOT_AVALIABLE);
    // }

  }

  // @Override
  // public List<PostDTO> getPostByUserid(int userId) {
  //   // TODO Auto-generated method stub
  //   throw new UnsupportedOperationException("Unimplemented method 'getPostByUserid'");
  // }


}

