package com.vtxlab.bootcamp.bootcampsbforum.entity;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@Getter
@Setter
@Builder

public class PostEntity implements Serializable {

  private static final long serialVersionUID = 1L;
  // @ToString // serialization issue
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String body;

  @ManyToOne
  @JoinColumn(name = "user_id") // table colum name (FK)
  @JsonBackReference
  private UserEntity user; // Object reference

}

// heap
// UserEntity userEntity = new UserEntity();
// postEntities.setUser(userEntity);
// userEntity.setPosts(postEntity);


