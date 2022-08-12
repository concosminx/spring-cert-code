package com.nimsoc.spring.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  public void addProduct(String name) {
    this.jdbcTemplate.update("INSERT INTO  product (name, price) VALUES (?, ?) ", name, 1);
  }
}
