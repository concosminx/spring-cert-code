package com.nimsoc.springsec.config.security.providers;

import com.nimsoc.springsec.config.security.authentication.CustomAuthentication;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

//@Component
@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

  private final String key;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    CustomAuthentication ca = (CustomAuthentication) authentication;
    String headerKey = ca.getKey();
    if (key.equals(headerKey)) {
      return new CustomAuthentication(true, null);
    }

    throw new BadCredentialsException("Oops!");
  }

  @Override
  public boolean supports(Class<?> authentication) {
    //how the manager knows that this is supported
    return CustomAuthentication.class.equals(authentication);
  }
}
