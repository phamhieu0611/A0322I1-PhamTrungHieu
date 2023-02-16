package com.examfinal.exam.service.impl;

import com.examfinal.exam.model.TypeProduct;
import com.examfinal.exam.repository.TypeProductRepository;
import com.examfinal.exam.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeServiceImpl implements TypeProductService {

    @Autowired
    TypeProductRepository productRepository;

    @Override
    public Iterable<TypeProduct> listAll() {
        return productRepository.findAll();
    }
}
