package com.example.baitap1.repository;

import com.example.baitap1.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository extends PagingAndSortingRepository<Product, Long> {
}
