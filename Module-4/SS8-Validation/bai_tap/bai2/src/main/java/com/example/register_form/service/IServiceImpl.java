package com.example.register_form.service;

import com.example.register_form.model.User;
import com.example.register_form.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IServiceImpl implements IService{
    @Autowired
    IRepository iRepository;
    @Override
    public void save(User user) {
        iRepository.save(user);
    }
}
