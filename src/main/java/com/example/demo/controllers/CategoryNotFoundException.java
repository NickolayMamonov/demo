package com.example.demo.controllers;

public class CategoryNotFoundException extends RuntimeException {
    CategoryNotFoundException(Integer id) {
        super("Could not find category " + id);
    }
}
