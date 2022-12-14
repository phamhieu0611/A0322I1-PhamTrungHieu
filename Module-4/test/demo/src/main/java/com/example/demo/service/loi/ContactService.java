package com.example.demo.service.loi;

import com.example.demo.model.Student;
import com.example.demo.model.loi.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContactService {
    void create(Contract contract);
    Page<Contract> search(Pageable pageable, String searchVal);
    Contract findById(Integer id);

    void delete(Integer id);
}
