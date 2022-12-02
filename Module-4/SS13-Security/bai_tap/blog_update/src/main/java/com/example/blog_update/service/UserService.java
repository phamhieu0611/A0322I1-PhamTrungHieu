package com.example.blog_update.service;

import com.example.blog_update.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
}
