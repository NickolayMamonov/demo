package com.example.demo.services;

import com.example.demo.models.Category;
public interface CategoryService {
    void register(Category category);
    Category findCategory(int id);
}
