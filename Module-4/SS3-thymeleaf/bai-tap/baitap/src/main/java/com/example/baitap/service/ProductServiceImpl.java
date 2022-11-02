package com.example.baitap.service;

import com.example.baitap.model.Product;
import com.example.baitap.repository.IProductRepository;
import com.example.baitap.repository.ProductRepositoryImpl;

import java.util.List;

public class ProductServiceImpl implements IProductService{

    private static IProductRepository repository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void addNew(Product product) {
        repository.addNew(product);
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        repository.updateProduct(product);
    }

    @Override
    public void delete(int id) throws Exception {
        repository.delete(id);
    }

    @Override
    public Product findById(int id) throws Exception {
        return repository.findById(id);
    }

    @Override
    public List<Product> findByName(String nameSearch) {
        return repository.findByName(nameSearch);
    }
}