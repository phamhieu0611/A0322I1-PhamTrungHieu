package com.example.service.impl;

import com.example.model.Test;
import com.example.model.contract.ContractDetail;
import com.example.repository.customer.ICustomerRestRepository;
import com.example.service.ICustomerRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerRestService implements ICustomerRestService {

    @Autowired
    private ICustomerRestRepository iCustomerRestRepository;
    @Override
    public List<ContractDetail> showAttach(int idSearch) {
        return iCustomerRestRepository.showAttach(idSearch);
    }
}
