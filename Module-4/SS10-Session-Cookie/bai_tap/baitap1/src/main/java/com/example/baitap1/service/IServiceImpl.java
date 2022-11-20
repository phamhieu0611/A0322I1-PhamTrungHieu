package com.example.baitap1.service;


import com.example.baitap1.model.Product;
import com.example.baitap1.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IServiceImpl implements IService{

    @Autowired
    private IRepository iRepository;

    @Override
    public Iterable<Product> findAll() {
        return iRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iRepository.findById(id);
    }
}
