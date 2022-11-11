package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IServiceImpl implements IService{

    @Autowired
    IRepository iRepository;

    @Override
    public List<Blog> findAll() {
        return iRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        iRepository.save(blog);
    }

    @Override
    public Blog findById(int id) {
        return iRepository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        iRepository.update(blog);
    }

    @Override
    public void delete(Blog blog) {
        iRepository.delete(blog);
    }
}
