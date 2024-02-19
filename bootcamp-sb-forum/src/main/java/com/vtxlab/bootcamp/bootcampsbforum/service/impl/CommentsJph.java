package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.infra.getUrl;
import com.vtxlab.bootcamp.bootcampsbforum.model.Comments;
import com.vtxlab.bootcamp.bootcampsbforum.service.CommentService;

@Service
public class CommentsJph implements CommentService {

  @Value(value = "${api.jph.domain}")
  private String domain;
  @Value(value = "${api.jph.endpoints.comment}")
  private String commentEndpoint;

  @Override
  public List<Comments> getComments() {
    RestTemplate restTemplate = new RestTemplate();
    String url = getUrl.url(Scheme.HTTP,domain, commentEndpoint);
    Comments[] comments = restTemplate.getForObject(url, Comments[].class);
    return Arrays.stream(comments).collect(Collectors.toList());
  }
  }



