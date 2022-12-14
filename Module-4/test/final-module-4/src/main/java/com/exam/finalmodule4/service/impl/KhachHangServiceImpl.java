package com.exam.finalmodule4.service.impl;

import com.exam.finalmodule4.model.Khachhang;
import com.exam.finalmodule4.repository.KhachHangRepository;
import com.exam.finalmodule4.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public Iterable<Khachhang> danhsach() {
        return khachHangRepository.findAll();
    }
}
