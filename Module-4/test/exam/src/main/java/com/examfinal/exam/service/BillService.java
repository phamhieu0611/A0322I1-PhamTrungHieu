package com.examfinal.exam.service;

import com.examfinal.exam.model.Bill;
import com.examfinal.exam.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public interface BillService {
    void update(Bill bill);

    Page<Bill> search(Pageable pageable, Date searchVal, Date searchVal2);

    Bill findById(Integer id);

    Page<Bill> findAll(Pageable pageable);

    void delete(Integer id);
}
