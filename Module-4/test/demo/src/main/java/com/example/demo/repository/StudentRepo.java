package com.example.demo.repository;

import com.example.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    Page<Student> findByStudentNameContainingOrPhoneNumberContainingOrClassroom_ClassroomNameContaining(
            Pageable pageable, String nameSearch, String phoneSearch, String cNameSearch);
}
