package QuanLyTaiKhoanNganHang.utils;



import QuanLyTaiKhoanNganHang.model.TaiKhoanTietKiem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFileTaiKhoanTietKiem {
    public static List<String> docFile(String path) {
        List<String> stringList = new ArrayList<>();
        try {
            File file = new File(path);
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

    public static List<TaiKhoanTietKiem> docFileTaiKhoanTietKiem(String path) {
        List<String> stringList = docFile(path);
        List<TaiKhoanTietKiem> taiKhoanTietKiemList = new ArrayList<>();
        String[] info;
        for (String string : stringList) {
            info = string.split(",");
            taiKhoanTietKiemList.add(new TaiKhoanTietKiem(Integer.parseInt(info[0]), info[1], info[2], info[3],
                    Double.parseDouble(info[4]),info[5],Double.parseDouble(info[6]),Integer.parseInt(info[7])));
        }
        return taiKhoanTietKiemList;
    }

    public static void ghiFile(String path, String data) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ghiFileTaiKhoanTietKiem(String path, List<TaiKhoanTietKiem> taiKhoanTietKiemList) {
        StringBuilder data = new StringBuilder();
        for (TaiKhoanTietKiem taiKhoanTietKiem :taiKhoanTietKiemList) {
            data.append(taiKhoanTietKiem.getInfor());
        }
        ghiFile(path, data.toString());
    }
}
