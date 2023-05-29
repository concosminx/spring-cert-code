package com.nimsoc.springsec.repositories;

import com.nimsoc.springsec.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

  @Query(" select u from User u where u.username = :username ")
  Optional<User> findUserByUsername(String username);
}
