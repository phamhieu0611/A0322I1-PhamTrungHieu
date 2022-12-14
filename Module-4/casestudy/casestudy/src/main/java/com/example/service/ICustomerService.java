package com.example.service;

import com.example.model.contract.AttachFacility;
import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
       List<Customer> findAll();

       void save (Customer customer);

       Page<Customer> searchCustomer(String nameSearch, String emailSearch, String addressSearch, Pageable pageable);

       Page<Customer> searchCustomer2( String nameSearch,
                                       String emailSearch,
                                       String customerType, Pageable pageable);


       void deleteLogical(Integer id);

       void update(Customer customer);

       Optional<Customer> findById(Integer id);

       List<AttachFacility> searchId(int idSearch);
}
