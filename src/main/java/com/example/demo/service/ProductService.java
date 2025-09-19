package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product handlSaveProduct(Product Product) {
        return this.productRepository.save(Product);
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }


    public Product getProductById(long id){
        return this.productRepository.findById(id);
    }

    public void deleteAProduct(long id){
        this.productRepository.deleteById(id);
    }
}
