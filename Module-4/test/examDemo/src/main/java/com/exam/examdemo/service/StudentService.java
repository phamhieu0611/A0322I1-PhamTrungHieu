package com.exam.examdemo.service;

import com.exam.examdemo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    void create(Student student);
    Page<Student> search(Pageable pageable, String searchVal);
    void delete(int id);
}
