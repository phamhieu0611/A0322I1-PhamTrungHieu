package com.example.blog_update.service;

import com.example.blog_update.model.Blog;
import com.example.blog_update.model.Category;

import java.util.List;

public interface CategoryService {
    Iterable<Category> findAll();

    Category findById(int id);

}
