package com.nimsoc.spring.controllers;

import com.google.common.io.ByteStreams;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Map;

@RestController
public class HelloController {

  @PostMapping(value = "/test")
  public String test(@RequestHeader(value = "a") String a,
                     @RequestHeader(value = "b") String b,
                     @RequestBody String body) {
    return "Hello! " + a + " / " + b + " with body: " + body;
  }


  @GetMapping(value = "/all")
  public Map<String, String> getHeaders(@RequestHeader Map<String, String> headers) {
    return headers;
  }

  @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
  public byte[] file() {
    InputStream resourceAsStream = this.getClass().getResourceAsStream("sample.pdf");
    byte[] bytes = new byte[0];
    try {
      bytes = ByteStreams.toByteArray(resourceAsStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return bytes;
  }

}
