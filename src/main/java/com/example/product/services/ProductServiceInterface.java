package com.example.product.services;

import com.example.product.models.Product;
import org.springframework.stereotype.Service;

@Service
public interface ProductServiceInterface {
    public Product getSingleProduct(long id);

}
