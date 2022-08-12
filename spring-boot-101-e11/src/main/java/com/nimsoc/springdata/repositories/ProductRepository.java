package com.nimsoc.springdata.repositories;

import com.nimsoc.springdata.entities.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

  public Product findProductByName(String name);

  @Query("SELECT p FROM Product p where p.name = :name ")
  public Product findWithName(String name);


  public List<Product> findProductsByName(String name, Sort sort); // or Pageable with Sort (not both!)

}
