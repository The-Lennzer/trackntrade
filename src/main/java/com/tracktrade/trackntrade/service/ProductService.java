package com.tracktrade.trackntrade.service;

import com.tracktrade.trackntrade.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}
