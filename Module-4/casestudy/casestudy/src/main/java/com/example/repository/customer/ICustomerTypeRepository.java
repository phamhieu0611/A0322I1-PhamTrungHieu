package com.example.repository.customer;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Integer> {


}
