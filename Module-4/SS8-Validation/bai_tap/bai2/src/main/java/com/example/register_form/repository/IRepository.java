package com.example.register_form.repository;

import com.example.register_form.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository extends JpaRepository<User, Integer> {
}
