package services;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

  /*
  public void hello(String name) {
    System.out.println("Hello, " + name);
    //throw new RuntimeException("Forced runtime exception here");
  }*/

  public String hello(String name) {
    String msg = "Hello, " + name;
    System.out.println(msg);
    return msg;
  }

}
