package com.examfinal.exam.repository;

import com.examfinal.exam.model.TypeProduct;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProductRepository extends PagingAndSortingRepository<TypeProduct, Integer> {
}
