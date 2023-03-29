package com.saraya.productService.service;

import com.saraya.productService.dao.ProductRepository;
import com.saraya.productService.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository prodRepo;

    public List<Product> findAll(){
        return (List<Product>) prodRepo.findAll();
    }
 public Product findByName(String pname){
        return prodRepo.findByPname(pname)
                .orElseThrow(()->new RuntimeException("Product Not Found"));
 }
 public Product saveProduct(Product p){
        return  prodRepo.save(p);
 }
 public Product updateProduct(int pid,Product pr){
        Product existing = prodRepo.findById(pid)
                .orElseThrow(()->new RuntimeException("No Product Available with ID"+ pid));

        if (pr.getPname()!=null)
            existing.setPname(pr.getPname());
        if (pr.getPrice()!=null)
            existing.setPrice(pr.getPrice());
        if (pr.getQuantity()!=null)
            existing.setQuantity(pr.getQuantity());
        return prodRepo.save(existing);
 }
 public String deleteProduct(int pid){
     Product existing = prodRepo.findById(pid)
             .orElseThrow(()->new RuntimeException("No Product Available with ID"+ pid));
     prodRepo.deleteById(pid);
     return "Product Deleted";

 }


}
