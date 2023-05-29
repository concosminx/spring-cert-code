package com.nimsoc.springsec.security;

import com.nimsoc.springsec.entities.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {

  private final Authority authority;

  @Override
  public String getAuthority() {
    return authority.getName();
  }
}
