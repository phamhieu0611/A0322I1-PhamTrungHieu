package fake_final_exam2.utils;


import fake_final_exam2.models.GiangVien;
import fake_final_exam2.models.HocSinh;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<HocSinh> readHocSinhFile(String filePath) {
        List<HocSinh> hocSinhList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            HocSinh hocSinh;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                String name = temp[0];
                String date = temp[1];
                String gender = temp[2];
                String lop = temp[3];
                String diem = temp[4];
                hocSinh = new HocSinh(name, date, gender, lop, diem);
                hocSinhList.add(hocSinh);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hocSinhList;
    }

    public static List<GiangVien> readGiangVienFile(String filePath) {
        List<GiangVien> giangVienList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            GiangVien giangVien;
            while ((line = bufferedReader.readLine()) != null) {
                temp = line.split(",");
                String name = temp[0];
                String date = temp[1];
                String gender = temp[2];
                String chuyenMon = temp[3];
                giangVien = new GiangVien(name, date, gender, chuyenMon);
                giangVienList.add(giangVien);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return giangVienList;
    }
}
