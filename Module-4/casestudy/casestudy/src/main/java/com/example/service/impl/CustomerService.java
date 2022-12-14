package com.example.service.impl;

import com.example.model.contract.AttachFacility;
import com.example.model.customer.Customer;
import com.example.repository.customer.ICustomerRepository;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Page<Customer> searchCustomer(String nameSearch, String emailSearch, String addressSearch, Pageable pageable) {
        return iCustomerRepository.searchCustomer(nameSearch,emailSearch,addressSearch,pageable);
    }

    @Override
    public Page<Customer> searchCustomer2(String nameSearch, String emailSearch, String customerType, Pageable pageable) {
        return iCustomerRepository.searchCustomer2(nameSearch,emailSearch,customerType,pageable);
    }

    @Override
    public void deleteLogical(Integer id) {
        iCustomerRepository.deleteLogical(id);
    }

    @Override
    public void update(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Integer id) {
        return iCustomerRepository.findById(id);
    }

    @Override
    public List<AttachFacility> searchId(int idSearch) {
        return iCustomerRepository.searchId(idSearch);
    }
}
