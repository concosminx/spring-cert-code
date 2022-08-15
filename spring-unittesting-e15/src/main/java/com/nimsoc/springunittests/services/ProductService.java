package com.nimsoc.springunittests.services;

import com.nimsoc.springunittests.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<String> getProductNamesWithEvenNumberOfChars() {
        return productRepository.getProductNames().stream().filter(x -> x.length() % 2 == 0).collect(Collectors.toList());
    }

}
