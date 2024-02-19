package com.vtxlab.bootcamp.bootcampsbforum.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.vtxlab.bootcamp.bootcampsbforum.infra.ResourceNotFound;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Scheme;
import com.vtxlab.bootcamp.bootcampsbforum.infra.Syscode;
import com.vtxlab.bootcamp.bootcampsbforum.infra.getUrl;
import com.vtxlab.bootcamp.bootcampsbforum.model.User;
import com.vtxlab.bootcamp.bootcampsbforum.repository.UserRepository;
import com.vtxlab.bootcamp.bootcampsbforum.service.PostsService;
import com.vtxlab.bootcamp.bootcampsbforum.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class UserJsonPlaceHolder implements UserService {

  @Value(value = "${api.jph.domain}")
  private String domain;
  @Value(value = "${api.jph.endpoints.user}")
  private String userEndpoint;

  @Autowired
  private PostsService postsService;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private UserRepository userRepository;

  @PersistenceContext // similar to autowired
  private EntityManager entityManager;


  @Override
  public List<User> getUsers() {
    RestTemplate restTemplate = new RestTemplate();
    String userurl = getUrl.url(Scheme.HTTPS, domain, userEndpoint);
    User[] users = restTemplate.getForObject(userurl, User[].class);
    return Arrays.stream(users)//
        .collect(Collectors.toList());
  }

  @Override
  public User getUser(int userId) {
    // RestTemplate restTemplate = new RestTemplate();
    // String userurl = getUrl.url(Scheme.HTTPS, domain, userEndpoint);
    // List<User> usersList =
    // Arrays.stream(restTemplate.getForObject(userurl, User[].class))//
    // .collect(Collectors.toList());
    // return usersList.stream().filter(e -> e.getId() == userId).findAny().get();
    Optional<User> userPostDTO = this.getUsers().stream() //
        .filter(e -> e.getId() == userId) //
        .findFirst();
    if (userPostDTO.isPresent())
      return userPostDTO.get();
    throw new ResourceNotFound(Syscode.NOTFOUND);
  }


  @Override
  public List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> getUsersByAddrLatGreaterThan(
      Double latitude) {
    return userRepository.findAllByAddrLatGreaterThan(latitude);
  }

  @Override
  public Long countUserByName(String prefix) {
    return userRepository.countUserByNameStartWith(prefix);
  }

  @Override
  public List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> getAllByEmailOrPhone(
      String email, String phone, Sort sort) {
    return userRepository.findAllByEmailOrPhone(email, phone, sort);
  }

  public List<com.vtxlab.bootcamp.bootcampsbforum.entity.User> getAllByEmailOrPhone(
      String email, String phone) {
    Sort sort = Sort.by("email").ascending().and(Sort.by("phone").ascending());
    return userRepository.findAllByEmailOrPhone(email, phone, sort);
  }

  @Override
  @Transactional
  public void updateUserEmailById(Long id, String email) {
    userRepository.updateUser(id, email);
  }

  @Override
  @Transactional
  public com.vtxlab.bootcamp.bootcampsbforum.entity.User updateUserById(Long userId,
      com.vtxlab.bootcamp.bootcampsbforum.entity.User newUser) {

    // entityManager.find() -> select
    com.vtxlab.bootcamp.bootcampsbforum.entity.User oldUser = entityManager
        .find(com.vtxlab.bootcamp.bootcampsbforum.entity.User.class, userId);

    oldUser.setId(newUser.getId());
    oldUser.setName(newUser.getName());
    oldUser.setAddrLat(newUser.getAddrLat());
    oldUser.setAddrLong(newUser.getAddrLong());
    oldUser.setEmail(newUser.getEmail());
    oldUser.setPhone(newUser.getPhone());
    oldUser.setStreet(newUser.getStreet());
    oldUser.setCity(newUser.getCity());
    oldUser.setSuite(newUser.getSuite());
    oldUser.setZipcode(newUser.getZipcode());
    oldUser.setCName(newUser.getCName());
    oldUser.setCCatchPhrase(newUser.getCCatchPhrase());
    oldUser.setCBusService(newUser.getCBusService());

    entityManager.merge(oldUser); // update
    return oldUser;
    // // update
    // entityManager.flush();
    // entityManager.clear();
    // // select again to check if update is successful
    // com.vtxlab.bootcamp.bootcampsbforum.entity.User updatedUser = entityManager.find(com.vtxlab.bootcamp.bootcampsbforum.entity.User.class, userId);
    // }

  }
}
