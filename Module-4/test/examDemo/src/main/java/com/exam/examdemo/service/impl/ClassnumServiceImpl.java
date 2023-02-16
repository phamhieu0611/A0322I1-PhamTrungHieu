package com.exam.examdemo.service.impl;

import com.exam.examdemo.model.Classnum;
import com.exam.examdemo.repository.ClassRepo;
import com.exam.examdemo.service.ClassnumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassnumServiceImpl implements ClassnumService {
    @Autowired
    ClassRepo classRepo;
    @Override
    public Iterable<Classnum> listAll() {
        return classRepo.findAll();
    }
}
