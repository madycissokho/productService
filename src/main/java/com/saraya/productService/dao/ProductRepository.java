package com.saraya.productService.dao;

import com.saraya.productService.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product,Integer> {
   Optional<Product>  findByPname(String pname);
}
