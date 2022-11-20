package com.example.baitap.service;

import com.example.baitap.model.Product;

import java.util.Optional;

public interface IService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
