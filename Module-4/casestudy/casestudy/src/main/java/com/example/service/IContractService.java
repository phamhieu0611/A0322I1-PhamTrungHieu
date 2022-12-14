package com.example.service;

import com.example.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IContractService {

    Page<Contract> searchContract(String nameCustomer, Pageable pageable);

    void save (Contract contract);
}
