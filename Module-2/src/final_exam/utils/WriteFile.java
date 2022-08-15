package final_exam.utils;

import final_exam.models.ThanhToan;
import final_exam.models.TietKiem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    public static void ghiFile(String path, String data) {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ghiFileThanhToan(String path, List<ThanhToan> taiKhoanThanhToanList) {
        StringBuilder data = new StringBuilder();
        for (ThanhToan taiKhoanThanhToan :taiKhoanThanhToanList) {
            data.append(taiKhoanThanhToan.layThongTin());
        }
        ghiFile(path, data.toString());
    }

    public static void ghiFileTietKiem(String path, List<TietKiem> taiKhoanTietKiemList) {
        StringBuilder data = new StringBuilder();
        for (TietKiem taiKhoanTietKiem :taiKhoanTietKiemList) {
            data.append(taiKhoanTietKiem.layThongTin());
        }
        ghiFile(path, data.toString());
    }
}
