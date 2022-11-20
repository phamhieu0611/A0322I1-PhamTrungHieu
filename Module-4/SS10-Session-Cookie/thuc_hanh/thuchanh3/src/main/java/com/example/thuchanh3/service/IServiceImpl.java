package com.example.thuchanh3.service;

import com.example.thuchanh3.model.Product;
import com.example.thuchanh3.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IServiceImpl implements IProductService{

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
