package com.nimsoc.spring.controllers;

import com.nimsoc.spring.dto.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

//@Controller
//@ResponseBody - or replace them with @RestController
@RestController
public class HelloController {

  //@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET) or u can use the shorter syntax
  @GetMapping(value = "/hello/{name}")
  public String hello(@PathVariable("name") String name) {
    return "Hello, " + name + "!";
  }

  @PostMapping(value = "/goodbye")
  public String goodbye(@RequestBody Person person) {
    return "Goodbye, " + person.getName() + "!";
  }

  @GetMapping(value = "/get")
  public Person getPerson() {
    Person p = new Person();
    p.setName("John");
    return p;
  }

  @GetMapping(value = "/getall")
  public List<Person> getAllPersons() {
    Person p1 = new Person();
    p1.setName("John");

    Person p2 = new Person();
    p2.setName("Bill");

    return Arrays.asList(p1, p2);
  }

  @GetMapping(value = "/statustest")
  public void statusTest(HttpServletResponse response) {
    response.setStatus(HttpServletResponse.SC_NO_CONTENT);
  }
}
