package com.examfinal.exam.service.impl;

import com.examfinal.exam.model.Product;
import com.examfinal.exam.repository.ProductRepository;
import com.examfinal.exam.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Iterable<Product> listAll() {
        return productRepository.findAll();
    }
}
