package fake_final_exam2.utils;

import fake_final_exam2.models.GiangVien;
import fake_final_exam2.models.HocSinh;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    private static final String HOCSINH_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam2\\data\\hocSinh.csv";
    private static final String GIANGVIEN_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam2\\data\\giangVien.csv";


    public static void addHocSinh(String data) {
        try {
            FileWriter fileWriter = new FileWriter(HOCSINH_CSV, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            buffWrite.write(data);
            buffWrite.newLine();
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void ghiFileHocSinh(List<HocSinh> hocSinhList) {
        StringBuilder data = new StringBuilder();
        for (HocSinh hocSinh :hocSinhList) {
            data.append(hocSinh.layThongTin());
        }
        addHocSinh(data.toString());
    }

    public static void addGiangVien(String data) {
        try {
            FileWriter fileWriter = new FileWriter(GIANGVIEN_CSV, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            buffWrite.write(data);
            buffWrite.newLine();
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void ghiFileGiangVien(List<GiangVien> giangVienList) {
        StringBuilder data = new StringBuilder();
        for (GiangVien giangVien :giangVienList) {
            data.append(giangVien.layThongTin());
        }
        addGiangVien(data.toString());
    }

    public static void writeAfterDeleteHocSinh(List<HocSinh> hocSinhs) {
        try {
            FileWriter fileWriter = new FileWriter(HOCSINH_CSV, false);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            for (HocSinh hocSinh : hocSinhs) {
                buffWrite.write(hocSinh.getName()+","+hocSinh.getDate()+","+hocSinh.getGender()+","+hocSinh.getLop()+","+hocSinh.getDiem());
                buffWrite.newLine();
            }
            buffWrite.close();
        } catch (IOException e) {
            System.err.println("IOException " + e.toString());
        }
    }

    public static void writeAfterDeleteGiangVien(List<GiangVien> giangViens) {
        try {
            FileWriter fileWriter = new FileWriter(HOCSINH_CSV, false);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            for (GiangVien giangVien : giangViens) {
                buffWrite.write(giangVien.getName()+","+giangVien.getDate()+","+giangVien.getGender()+","+giangVien.getChuyenMon());
                buffWrite.newLine();
            }
            buffWrite.close();
        } catch (IOException e) {
            System.err.println("IOException " + e.toString());
        }
    }
}
