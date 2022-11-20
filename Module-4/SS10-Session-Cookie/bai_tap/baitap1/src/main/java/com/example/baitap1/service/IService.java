package com.example.baitap1.service;

import com.example.baitap1.model.Product;

import java.util.Optional;

public interface IService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
