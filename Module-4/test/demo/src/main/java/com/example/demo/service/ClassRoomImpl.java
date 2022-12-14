package com.example.demo.service;

import com.example.demo.model.Classroom;
import com.example.demo.repository.ClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomImpl implements ClassroomService{
    @Autowired
    ClassroomRepo classroomRepo;

    @Override
    public Iterable<Classroom> listAll() {
        return classroomRepo.findAll();
    }
}
