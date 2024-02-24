package com.vtxlab.bootcamp.bootcampsbforum.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Comments")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class CommentsEntity {
  @Column(name = "POST_ID") // for db column name, not for field name.
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long postId;

  private int id;

  private String name;

  private String email;

  private String body;
}
