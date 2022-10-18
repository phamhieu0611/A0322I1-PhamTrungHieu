package mvc.model;

import java.util.Date;

public class PhongTro {
    private int ma_phong_tro;
    private String ma_tro;
    private String ten_nguoi_thue;
    private int so_dien_thoai;
    private Date ngay_thue;
    private String ma_thanh_toan;
    private String ghi_chu;

    public String getMa_tro() {
        return ma_tro;
    }

    public void setMa_tro(String ma_tro) {
        this.ma_tro = ma_tro;
    }

    public PhongTro(String ma_tro, String ten_nguoi_thue, int so_dien_thoai, Date ngay_thue, String ma_thanh_toan, String ghi_chu) {
        this.ma_tro = ma_tro;
        this.ten_nguoi_thue = ten_nguoi_thue;
        this.so_dien_thoai = so_dien_thoai;
        this.ngay_thue = ngay_thue;
        this.ma_thanh_toan = ma_thanh_toan;
        this.ghi_chu = ghi_chu;
    }

    public PhongTro(int ma_phong_tro, String ma_tro, String ten_nguoi_thue, int so_dien_thoai, Date ngay_thue, String ma_thanh_toan, String ghi_chu) {
        this.ma_phong_tro = ma_phong_tro;
        this.ma_tro = ma_tro;
        this.ten_nguoi_thue = ten_nguoi_thue;
        this.so_dien_thoai = so_dien_thoai;
        this.ngay_thue = ngay_thue;
        this.ma_thanh_toan = ma_thanh_toan;
        this.ghi_chu = ghi_chu;
    }

    public PhongTro() {
    }

    public String getGhi_chu() {
        return ghi_chu;
    }

    public void setGhi_chu(String ghi_chu) {
        this.ghi_chu = ghi_chu;
    }

    public int getMa_phong_tro() {
        return ma_phong_tro;
    }

    public void setMa_phong_tro(int ma_phong_tro) {
        this.ma_phong_tro = ma_phong_tro;
    }

    public String getTen_nguoi_thue() {
        return ten_nguoi_thue;
    }

    public void setTen_nguoi_thue(String ten_nguoi_thue) {
        this.ten_nguoi_thue = ten_nguoi_thue;
    }

    public int getSo_dien_thoai() {
        return so_dien_thoai;
    }

    public void setSo_dien_thoai(int so_dien_thoai) {
        this.so_dien_thoai = so_dien_thoai;
    }

    public Date getNgay_thue() {
        return ngay_thue;
    }

    public void setNgay_thue(Date ngay_thue) {
        this.ngay_thue = ngay_thue;
    }

    public String getMa_thanh_toan() {
        return ma_thanh_toan;
    }

    public void setMa_thanh_toan(String ma_thanh_toan) {
        this.ma_thanh_toan = ma_thanh_toan;
    }
}
