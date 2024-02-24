package com.vtxlab.bootcamp.bootcampsbforum.entity;

import java.io.Serializable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
  private String userId;
}


