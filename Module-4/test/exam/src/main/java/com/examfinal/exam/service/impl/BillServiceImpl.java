package com.examfinal.exam.service.impl;

import com.examfinal.exam.model.Bill;
import com.examfinal.exam.repository.BillRepository;
import com.examfinal.exam.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    BillRepository billRepository;

    @Override
    public void update(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public Page<Bill> search(Pageable pageable, Date searchVal, Date searchVal2) {
        return billRepository.findBillByPublishDateBetween(pageable, searchVal, searchVal2);
    }

    @Override
    public Bill findById(Integer id) {
        return billRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Bill> findAll(Pageable pageable) {
        return billRepository.findAll(pageable);
    }

    @Override
    public void delete(Integer id) {
        billRepository.deleteById(id);
    }
}
