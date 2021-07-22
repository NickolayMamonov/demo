package com.example.demo.services;
import com.example.demo.models.Category;
import com.example.demo.models.Product;


import java.util.List;

public interface ProductService {
    void add(Product product);
    void buy(Product product);
    Product findProduct(int id);

    List<Product> findByCategory(Category category);
}
