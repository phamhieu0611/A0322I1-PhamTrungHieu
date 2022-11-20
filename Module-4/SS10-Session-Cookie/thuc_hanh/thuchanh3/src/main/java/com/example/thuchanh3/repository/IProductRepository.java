package com.example.thuchanh3.repository;

import com.example.thuchanh3.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
}
