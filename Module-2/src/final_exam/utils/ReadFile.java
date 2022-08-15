package final_exam.utils;

import final_exam.models.ThanhToan;
import final_exam.models.TietKiem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public static List<String> docFile(String filePath) {
        List<String> stringList = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    public static List<TietKiem> docFileTietKiem(String path) {
        List<String> stringList = docFile(path);
        List<TietKiem> tietKiemList = new ArrayList<>();
        String[] temp;
        TietKiem tietKiem;
        for (String string : stringList) {
            temp = string.split(",");
           int id = Integer.parseInt(temp[0]);
        String maTaiKhoan = temp[1];
        String chuTaiKhoan = temp[2];
        String ngayTao = temp[3];
        double tien = Double.parseDouble(temp[4]);
        String ngayGui = temp[5];
        double laiSuat = Double.parseDouble(temp[6]);
        int kyHan = Integer.parseInt(temp[7]);
        tietKiem = new TietKiem(id, maTaiKhoan, chuTaiKhoan, ngayTao, tien, ngayGui, laiSuat, kyHan);
        tietKiemList.add(tietKiem);
        }
        return tietKiemList;
    }

    public static List<ThanhToan> docFileThanhToan(String path) {
        List<String> stringList = docFile(path);
        List<ThanhToan> thanhToanList = new ArrayList<>();
        String[] temp;
        for (String string : stringList) {
            temp = string.split(",");
            thanhToanList.add(new ThanhToan(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3],
                    Integer.parseInt(temp[4]),Double.parseDouble(temp[5])));
        }
        return thanhToanList;
    }
}
