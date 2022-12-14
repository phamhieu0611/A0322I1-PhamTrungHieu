package com.example.demo.repository.loi;

import com.example.demo.model.loi.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepo extends JpaRepository<Contract, Integer> {
    Page<Contract> findByCustomer_CustomerNameContaining(Pageable pageable, String searchCus);
}
