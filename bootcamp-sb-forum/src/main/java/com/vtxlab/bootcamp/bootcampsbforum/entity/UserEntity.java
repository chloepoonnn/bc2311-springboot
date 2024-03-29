package com.vtxlab.bootcamp.bootcampsbforum.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class UserEntity implements Serializable {

  private static final long serialVersionUID = 3L;
  // @ToString // serialization issue
  @Column(name = "USER_ID") // for db column name, not for field name.
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String username;

  private String email;

  private String phone;

  private String website;

  @Column(name = "ADDRESS_STREET")
  private String street;

  private String suite;

  private String city;

  private String zipcode;

  @Column(name = "ADDRESS_LAT")
  private String addrLat;
  @Column(name = "ADDRESS_LNG")
  private String addrLong;

  @Column(name = "COMPANY_NAME")
  private String cName;

  @Column(name = "COMPANY_CATCH_PHRASE")
  private String cCatchPhrase;
  @Column(name = "COMPANY_BUSINESS_SERVICE")
  private String cBusService;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true) // serialization
  private List<PostEntity> posts = new ArrayList<>();
}
