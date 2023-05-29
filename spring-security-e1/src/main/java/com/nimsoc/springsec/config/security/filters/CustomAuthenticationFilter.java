package com.nimsoc.springsec.config.security.filters;


import com.nimsoc.springsec.config.security.authentication.CustomAuthentication;
import com.nimsoc.springsec.config.security.managers.CustomAuthenticationManager;
import lombok.AllArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
@AllArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter { //TODO to be sure it's called one time only

  //private final CustomAuthenticationManager customAuthenticationManager;
  private final String key;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    //1. create an authentication object which is not yet authenticated
    //2. delegate the authentication object to the manager
    //3. get back the authentication from the manager
    //4. if the object is authenticated then send request to the next filter in the chain

    String headerKey = request.getHeader("key");
    CustomAuthentication ca = new CustomAuthentication(false, headerKey);
    CustomAuthenticationManager customAuthenticationManager = new CustomAuthenticationManager(key);

    if ("null".equals(headerKey) || headerKey == null) {
      filterChain.doFilter(request, response);
    } else {
      try {
        var a = customAuthenticationManager.authenticate(ca);
        if (a.isAuthenticated()) {
          SecurityContextHolder.getContext().setAuthentication(a);
          filterChain.doFilter(request, response); //only when the authentication worked
        } else {
          response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
      } catch (AuthenticationException exc) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      }
    }


  }


}
