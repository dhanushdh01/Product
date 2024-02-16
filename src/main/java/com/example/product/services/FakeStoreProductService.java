package com.example.product.services;

import com.example.product.dtos.ProductResponseDto;
import com.example.product.models.Category;
import com.example.product.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductServiceInterface{
    @Autowired
    RestTemplate restTemplate ;
    public Product getProductFromResponseDto(ProductResponseDto productResponseDto){
        Product product = new Product();
        product.setId(productResponseDto.getId());
        product.setName(productResponseDto.getTitle());
        product.setPrice(productResponseDto.getPrice());
        product.setDescription(productResponseDto.getDescription());
        product.setImage(productResponseDto.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(productResponseDto.getCategory());
        return product;
    }
    @Override
    public Product getSingleProduct(long id){
        // I should pass this "I'd" to fakestore and get the details of this "I'd" product.
        // https://fakestoreapi.com/products/1


        ProductResponseDto response = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, ProductResponseDto.class);

        return getProductFromResponseDto(response);
    }
}
