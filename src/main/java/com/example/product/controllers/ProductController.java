package com.example.product.controllers;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.models.Product;
import com.example.product.services.ProductServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductServiceInterface productServiceInterface;

    // Get all the Products
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }

    //Get a Product with I'd
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return productServiceInterface.getSingleProduct(id);
    }

    //Add a Product
    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto){
        return new Product();
    }

    //Update a Product
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id,@RequestBody ProductRequestDto productRequestDto){
        return new Product();
    }

    // Delete a Product
    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id){
        return true;
    }
}
