package com.exam.finalmodule4.repository;

import com.exam.finalmodule4.model.Khachhang;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends PagingAndSortingRepository<Khachhang, Integer> {
}
