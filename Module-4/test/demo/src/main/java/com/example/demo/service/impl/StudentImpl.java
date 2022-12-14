package com.example.demo.service.impl;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void create(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void update(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public Page<Student> findAndPaging(Pageable pageable) {
        return studentRepo.findAll(pageable);
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    @Override
    public Page<Student> searchByNameOrcName(Pageable pageable, String searchVal) {
        return studentRepo.findByStudentNameContainingOrPhoneNumberContainingOrClassroom_ClassroomNameContaining(pageable, searchVal, searchVal, searchVal);
    }
}
