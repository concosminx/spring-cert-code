package com.nimsoc.springsec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {

  @GetMapping("/")
  public String index() {
    return "index.html";
  }

  @PostMapping("/smth")
  public String doSmth() {
    System.out.println(":)");
    return "index";
  }

}
