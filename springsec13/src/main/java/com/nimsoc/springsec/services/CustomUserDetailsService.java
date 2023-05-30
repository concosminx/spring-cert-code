package com.nimsoc.springsec.services;


import com.nimsoc.springsec.entities.User;
import com.nimsoc.springsec.model.SecurityUser;
import com.nimsoc.springsec.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByUsername(username);
    UserDetails ud = user.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException(":("));
    return ud;
  }
}
