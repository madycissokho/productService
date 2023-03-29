package com.saraya.productService.controller;

import com.saraya.productService.model.Product;
import com.saraya.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
     ProductService proService;

    @CrossOrigin(origins = "*")
    @GetMapping("/products")
    public List<Product> findAll(){
        return proService.findAll();
    }
    @GetMapping("/product/{name}")
    public ResponseEntity<Product> findByName(@PathVariable String name){
        return new ResponseEntity<Product>(proService.findByName(name), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Product> createProduct(@RequestBody Product p){
        return new ResponseEntity<Product>(proService.saveProduct(p), HttpStatus.CREATED);
    }
    @PutMapping("/product/{pid}")
    public ResponseEntity<Product> updateProduct(@PathVariable int pid, @RequestBody Product pr){
        return new ResponseEntity<Product>(proService.updateProduct(pid, pr),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{pid}")
    public ResponseEntity<String> deleteProduct(@PathVariable int pid){
        return new ResponseEntity<String>(proService.deleteProduct(pid), HttpStatus.OK);

    }
}
