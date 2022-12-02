package com.example.blog_update.service;

import com.example.blog_update.model.Blog;
import com.example.blog_update.model.Category;
import com.example.blog_update.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    BlogRepository blogRepository;

    @Override
    public Blog getBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> getList() {
        Iterable<Blog> iterable = blogRepository.findAll();
        List<Blog> blogList = new ArrayList<>();
        for (Blog blog: iterable){
            blogList.add(blog);
        }
        return blogList;
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlogById(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByName(String name) {
        return blogRepository.findByBlogNameContains(name);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Optional<Blog> findBlogById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public List<Blog> findBlogsByCategory(Category category) {
        return blogRepository.findBlogsByCategory(category);
    }
}
