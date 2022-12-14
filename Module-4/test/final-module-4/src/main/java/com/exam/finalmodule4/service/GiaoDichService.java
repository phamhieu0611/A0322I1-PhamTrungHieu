package com.exam.finalmodule4.service;

import com.exam.finalmodule4.model.Giaodich;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GiaoDichService {
    void taomoi(Giaodich giaodich);
    Page<Giaodich> timkiemtheotenkhachhangorloaigiaodich(Pageable pageable, String timkiem);
    void xoa(Integer id);
}
