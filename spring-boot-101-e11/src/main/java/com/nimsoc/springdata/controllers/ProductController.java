package com.nimsoc.springdata.controllers;

import com.nimsoc.springdata.entities.Product;
import com.nimsoc.springdata.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

  @Autowired
  ProductRepository productRepository;

  @PostMapping(value = "/add")
  public void addProduct(@RequestBody Product p) {
    productRepository.save(p);
  }

  @GetMapping(value = "/get/{name}")
  public Product getProduct(@PathVariable("name") String name) {
    //return productRepository.findProductByName(name);
    return productRepository.findWithName(name);
  }

  @GetMapping(value = "/sort")
  public List<Product> getAllSortedDescendingById() {
    return productRepository.findAll(Sort.by("id").descending());
  }

  @GetMapping(value = "/page/{page}")
  public List<Product> getProductsByPage(@PathVariable("page") int page) {
    Sort sortById = Sort.by("id").descending();
    return productRepository.findAll(PageRequest.of(page, 2, sortById)).getContent();
  }


  @GetMapping(value = "/name/{name}")
  public List<Product> getProductsByName(@PathVariable("name") String name) {
    return productRepository.findProductsByName(name, Sort.by("name").ascending());
  }

}
