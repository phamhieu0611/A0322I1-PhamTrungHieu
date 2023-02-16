package com.exam.examdemo.repository;

import com.exam.examdemo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Page<Student> findByNameContainingOrClassnum_ClassNameContainingOrClassnum_TeacherContaining(
            Pageable pageable, String name, String classname, String teacher);
}
