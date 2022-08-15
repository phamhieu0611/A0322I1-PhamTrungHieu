package QuanLyTaiKhoanNganHang.utils;



import QuanLyTaiKhoanNganHang.model.TaiKhoanThanhToan;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DocGhiFileTaiKhoanThanhToan {
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

    public static List<TaiKhoanThanhToan> docFileTaiKhoanThanhToan(String path) {
        List<String> stringList = docFile(path);
        List<TaiKhoanThanhToan> taiKhoanThanhToanList = new ArrayList<>();
        String[] info;
        for (String string : stringList) {
            info = string.split(",");
            taiKhoanThanhToanList.add(new TaiKhoanThanhToan(Integer.parseInt(info[0]), info[1], info[2], info[3],
                    Integer.parseInt(info[4]),Double.parseDouble(info[5])));
        }
        return taiKhoanThanhToanList;
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

    public static void ghiFileTaiKhoanThanhToan(String path, List<TaiKhoanThanhToan> taiKhoanThanhToanList) {
        StringBuilder data = new StringBuilder();
        for (TaiKhoanThanhToan taiKhoanThanhToan :taiKhoanThanhToanList) {
            data.append(taiKhoanThanhToan.getInfor());
        }
        ghiFile(path, data.toString());
    }
}
