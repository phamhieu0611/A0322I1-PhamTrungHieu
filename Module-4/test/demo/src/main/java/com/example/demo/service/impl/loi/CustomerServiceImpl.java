package com.example.demo.service.impl.loi;

import com.example.demo.model.loi.Customer;
import com.example.demo.repository.loi.CustomerRepo;
import com.example.demo.service.loi.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepo customerRepo;
    @Override
    public Iterable<Customer> listAll() {
        return customerRepo.findAll();
    }
}
