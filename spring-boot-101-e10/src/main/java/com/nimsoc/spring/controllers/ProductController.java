package com.nimsoc.spring.controllers;

import com.nimsoc.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product") //applies for all endpoints
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping(value = "/add/{name}")
  public void addProduct(@PathVariable(value = "name") String name) {
    productService.addProduct(name);
  }

}
