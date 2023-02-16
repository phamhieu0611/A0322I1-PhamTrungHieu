package com.exam.examdemo.repository;

import com.exam.examdemo.model.Classnum;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepo extends PagingAndSortingRepository<Classnum, Integer> {
}
