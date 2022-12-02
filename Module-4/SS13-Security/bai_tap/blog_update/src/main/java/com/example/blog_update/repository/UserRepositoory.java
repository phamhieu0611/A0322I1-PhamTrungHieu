package com.example.blog_update.repository;

import com.example.blog_update.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoory extends JpaRepository<User, Long> {
    User findByUserName(String name);
}
