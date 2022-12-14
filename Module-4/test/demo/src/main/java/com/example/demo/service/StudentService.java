package com.example.demo.service;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {
    void create(Student student);
    void update(Student student);
    void delete(Integer id);
    Student findById(Integer id);
    Page<Student> findAndPaging(Pageable pageable);
    List<Student> findAll();
    Page<Student> searchByNameOrcName(Pageable pageable, String searchVal);

}
