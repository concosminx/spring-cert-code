package com.nimsoc.springsec.services;

import com.nimsoc.springsec.entities.User;
import com.nimsoc.springsec.repositories.UserRepository;
import com.nimsoc.springsec.security.SecurityUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) /*throws UsernameNotFoundException*/ {
    var userByUsername = userRepository.findUserByUsername(username);
    return userByUsername.map(SecurityUser::new)
        .orElseThrow(() -> new UsernameNotFoundException("Username not found " + username));
  }
}
