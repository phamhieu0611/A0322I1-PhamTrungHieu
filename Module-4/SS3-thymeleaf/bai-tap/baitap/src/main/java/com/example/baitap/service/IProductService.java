package com.example.baitap.service;

import com.example.baitap.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void addNew (Product product);

    void updateProduct(Product product) throws Exception;

    void delete(int id) throws Exception;

    Product findById(int id) throws Exception;

    List<Product> findByName(String nameSearch);
}
