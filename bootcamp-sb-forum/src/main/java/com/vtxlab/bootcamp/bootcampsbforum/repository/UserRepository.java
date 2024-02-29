package com.vtxlab.bootcamp.bootcampsbforum.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vtxlab.bootcamp.bootcampsbforum.entity.UserEntity;

// Hibernate (implementation class)
// Objective: Implement JPA interface

@Repository // Bean
public interface UserRepository extends JpaRepository<UserEntity, Long> {

  // select * from users where username = ?
  UserEntity findByUsername(String username);

  List<UserEntity> findAllByEmailAndPhone(String email, String phone);

  List<UserEntity> findAllByEmailOrPhone(String email, String phone, Sort sort);

  // JPQL
  // use hibernate(from springboot -> communicate with SQL product)
  // @Query("SELECT e FROM Users e WHERE CAST(e.addrLat AS double) > :lat")
  // List<User> findAllByAddrLatGreaterThan(@Param("lat") Double latitude);
  //JPQL follow .class name  , just java
  @Query("SELECT e FROM User e WHERE CAST(e.addrLat AS double) > :lat")
  List<UserEntity> findAllByAddrLatGreaterThan(@Param("lat") Double latitude);

  // Native SQL
  // problem? : not every SQL product have the same syntax for query
  //nativeQuery =true , foloow table name
  @Query(
      value = "SELECT count(1) FROM USERS u WHERE lower(u.name) LIKE lower(concat(:prefix,'%')) ",
      nativeQuery = true)
  Long countUserByNameStartWith(@Param("prefix") String prefix);

  // JPQL
  // @Modifying
  // @Query("UPDATE User u SET u.email = :e=newEmail WHERE u.id = :userId")
  // void updateUser(@Param("userId") Long id, @Param("newEmail") String email);

  
  @Modifying
  @Query("UPDATE User u SET u.email = :newEmail WHERE u.id = :userId")
  void updateUser(@Param("userId") Long id, @Param("newEmail") String email);


  @Modifying
  @Query("DELETE FROM User u WHERE u.id = :userId")
  void deleteUser(@Param("userId") Long id);


}
