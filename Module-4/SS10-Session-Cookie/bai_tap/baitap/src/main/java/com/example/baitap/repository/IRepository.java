package com.example.baitap.repository;

import com.example.baitap.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRepository extends PagingAndSortingRepository<Product, Long> {
}
