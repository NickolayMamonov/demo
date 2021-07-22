package com.example.demo.init;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.services.CategoryService;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {
        categoryService.register(new Category("Appliances"));
        Category category = categoryService.findCategory(1);
        productService.add(new Product("dishwasher",category,5000));


    }
}
