package com.nimsoc.springdatamongo.controllers;

import com.nimsoc.springdatamongo.model.Product;
import com.nimsoc.springdatamongo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

  @Autowired
  private ProductRepository productRepository;

  @PostMapping("/add")
  public void addProduct(@RequestBody Product p) {
    productRepository.save(p);
  }

  @GetMapping("/all")
  public List<Product> getAll() {
    return productRepository.findAll();
  }
}
