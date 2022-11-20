package com.example.thuchanh3.service;

import com.example.thuchanh3.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Optional<Product> findById(Long id);
}
