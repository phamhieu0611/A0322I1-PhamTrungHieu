package com.example.blog_update.service;

import com.example.blog_update.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {

    Blog getBlogById(int id);
    List<Blog> getList();
    void save(Blog blog);
    void update(Blog blog);
    void deleteBlogById(int id);
    List<Blog> findByName(String name);
    Page<Blog> findAll(Pageable pageable);
}
