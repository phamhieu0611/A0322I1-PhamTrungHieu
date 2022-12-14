package com.exam.finalmodule4.repository;

import com.exam.finalmodule4.model.Giaodich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiaoDichRepository extends JpaRepository<Giaodich, Integer> {
    Page<Giaodich> findByKhachhang_TenKhachHangContaining
            (Pageable pageable, String timkiem);
}
