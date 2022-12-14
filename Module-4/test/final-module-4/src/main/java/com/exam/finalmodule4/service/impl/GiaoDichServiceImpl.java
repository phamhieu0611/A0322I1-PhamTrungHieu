package com.exam.finalmodule4.service.impl;

import com.exam.finalmodule4.model.Giaodich;
import com.exam.finalmodule4.repository.GiaoDichRepository;
import com.exam.finalmodule4.service.GiaoDichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GiaoDichServiceImpl implements GiaoDichService {
    @Autowired
    private GiaoDichRepository giaoDichRepository;
    @Override
    public void taomoi(Giaodich giaodich) {
        giaoDichRepository.save(giaodich);
    }

    @Override
    public Page<Giaodich> timkiemtheotenkhachhangorloaigiaodich(Pageable pageable, String timkiem) {
        return giaoDichRepository.findByKhachhang_TenKhachHangContaining(pageable, timkiem);
    }

    @Override
    public void xoa(Integer id) {
        giaoDichRepository.deleteById(id);
    }
}
