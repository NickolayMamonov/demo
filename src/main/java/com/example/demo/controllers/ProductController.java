package com.example.demo.controllers;

import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;
@RestController
public class ProductController {
    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;
    public ProductController(ProductRepository repository,CategoryRepository categoryRepository){
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/products")
    Iterable<Product> all() {
        return repository.findAll();
    }

    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }

    @GetMapping("/products/{id}")
    Product one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Integer id) {
        repository.deleteById(id);
    }
    @GetMapping("/products/bycategory/{id}")
    Iterable<Product> findByCategory(@PathVariable Integer id) {
        return repository.findByCategory(categoryRepository.findById(id).get());
    }


}
