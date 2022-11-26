package com.example.thuc_hanhphone.service;

import com.example.thuc_hanhphone.model.SmartPhone;
import com.example.thuc_hanhphone.repository.ISmartPhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SmartphoneService implements ISmartPhoneService{
    @Autowired
    ISmartPhoneRepository iSmartPhoneRepository;
    @Override
    public Iterable<SmartPhone> findAll() {
        return iSmartPhoneRepository.findAll();
    }

    @Override
    public Optional<SmartPhone> findById(int id) {
        return iSmartPhoneRepository.findById(id);
    }

    @Override
    public SmartPhone save(SmartPhone smartPhone) {
        return iSmartPhoneRepository.save(smartPhone);
    }

    @Override
    public void remove(int id) {
        iSmartPhoneRepository.deleteById(id);
    }
}
