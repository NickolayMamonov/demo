package com.example.demo.services.impl;
import com.example.demo.models.Category;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void register(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findCategory(int id) {
        return categoryRepository.findById(id).get();
    }
}
