package com.exam.examdemo.service.impl;

import com.exam.examdemo.model.Student;
import com.exam.examdemo.repository.StudentRepo;
import com.exam.examdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Override
    public void create(Student student) {
        studentRepo.save(student);
    }

    @Override
    public Page<Student> search(Pageable pageable, String searchVal) {
        return studentRepo.findByNameContainingOrClassnum_ClassNameContainingOrClassnum_TeacherContaining(
                pageable, searchVal, searchVal, searchVal
        );
    }

    @Override
    public void delete(int id) {
        studentRepo.deleteById(id);
    }
}
