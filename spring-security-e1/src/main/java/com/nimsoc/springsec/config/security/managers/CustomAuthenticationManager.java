package com.nimsoc.springsec.config.security.managers;

import com.nimsoc.springsec.config.security.providers.CustomAuthenticationProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

//TODO - custom authentication
//@Component
@AllArgsConstructor
public class CustomAuthenticationManager implements AuthenticationManager {

  //private final CustomAuthenticationProvider provider;
  private final String key;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    var provider = new CustomAuthenticationProvider(key);
    if (provider.supports(authentication.getClass())) {
      return provider.authenticate(authentication);
    }

    throw new BadCredentialsException("Oops!");
  }
}
