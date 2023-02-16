package com.example.demo.service.impl.loi;

import com.example.demo.model.loi.Contract;
import com.example.demo.repository.loi.ContactRepo;
import com.example.demo.service.loi.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    ContactRepo contactRepo;

    @Override
    public void create(Contract contract) {
        contactRepo.save(contract);
    }

    @Override
    public Page<Contract> search(Pageable pageable, String searchVal) {
        return contactRepo.findByContractIdContainingOrCustomer_CustomerNameContaining(pageable, searchVal, searchVal);
    }

    @Override
    public Contract findById(Integer id) {
        return contactRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        contactRepo.deleteById(id);
    }
}
