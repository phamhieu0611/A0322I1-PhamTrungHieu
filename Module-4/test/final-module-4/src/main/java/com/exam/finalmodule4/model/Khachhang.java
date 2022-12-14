package com.exam.finalmodule4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Khachhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private String email;

    @OneToMany(mappedBy = "khachhang")
    @JsonBackReference
    private Set<Giaodich> khachhangSet;

    public Khachhang() {
    }

    public Integer getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(Integer maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Giaodich> getKhachhangSet() {
        return khachhangSet;
    }

    public void setKhachhangSet(Set<Giaodich> khachhangSet) {
        this.khachhangSet = khachhangSet;
    }
}
