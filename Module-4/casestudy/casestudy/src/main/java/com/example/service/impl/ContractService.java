package com.example.service.impl;

import com.example.model.contract.Contract;
import com.example.repository.contract.IContractRepository;
import com.example.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {

    @Autowired
    public IContractRepository iContractRepository;

    @Override
    public Page<Contract> searchContract(String nameCustomer, Pageable pageable) {
//        return iContractRepository.searchContract("%"+nameCustomer+"%",pageable);
        return iContractRepository.searchContract(nameCustomer,pageable);
    }

    @Override
    public void save(Contract contract) {
        iContractRepository.save(contract);
    }
}
