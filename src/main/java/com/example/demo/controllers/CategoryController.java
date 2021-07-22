package com.example.demo.controllers;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

public class CategoryController {
    private final CategoryRepository repository;

    CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/categories")
    Iterable<Category> all() {
        return repository.findAll();
    }

    @PostMapping("/categories")
    Category newCategory(@RequestBody Category newCategory) {
        return repository.save(newCategory);
    }

    @GetMapping("/categories/{id}")
    Category one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @DeleteMapping("/categories/{id}")
    void deleteCategory(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
