package com.example.blog.repository;

import com.example.blog.model.Blog;

import java.util.List;

public interface IRepository {
    List<Blog> findAll();
    void save(Blog blog);
    Blog findById(int id);
    void update(Blog blog);
    void delete(Blog blog);
}
