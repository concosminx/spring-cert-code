package com.nimsoc.springsec.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    //by default search autogenerated password in logs
    //user:21fac9ec-8f11-4e8d-9c71-75cb919c14fc (a new password is generated on each run)

    @GetMapping("/hello")
    public String hello() {
        return "Hello!";
    }

}
