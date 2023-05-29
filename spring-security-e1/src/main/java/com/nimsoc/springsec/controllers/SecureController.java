package com.nimsoc.springsec.controllers;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

  @GetMapping("/hello")
  public String hello() {
    //TODO - list user authorities
    //var u = SecurityContextHolder.getContext().getAuthentication();
    //u.getAuthorities().stream().forEach(a -> System.out.println(a.getAuthority()));
    return "hello man!";
  }
}
