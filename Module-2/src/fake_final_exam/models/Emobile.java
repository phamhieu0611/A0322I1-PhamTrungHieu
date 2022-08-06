package fake_final_exam.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Emobile extends Vehicle{
    private static final String EMOBILE_CSV= "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam\\data\\emobile.csv";
    private String kieuXe;
    private int soChoNgoi;

    public Emobile() {
    }

    public Emobile(String bienKiemSoat, String hangSanXuat, String namSanXuat, String chuSoHuu, String kieuXe, int soChoNgoi) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.kieuXe = kieuXe;
        this.soChoNgoi = soChoNgoi;
    }

    public String getKieuXe() {
        return kieuXe;
    }

    public void setKieuXe(String kieuXe) {
        this.kieuXe = kieuXe;
    }

    public int getSoChoNgoi() {
        return soChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        this.soChoNgoi = soChoNgoi;
    }

    @Override
    public String toString() {
        return "Emobile: " + super.toString() +
                "kieuXe='" + kieuXe + '\'' +
                ", soChoNgoi=" + soChoNgoi;
    }

    public static void some(Emobile emobile){
        try {
            FileWriter fileWriter = new FileWriter(EMOBILE_CSV, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            buffWrite.write(emobile.getBienKiemSoat()+","+emobile.getHangSanXuat()+","+emobile.getNamSanXuat()+","+emobile.getChuSoHuu()+","+emobile.getKieuXe()+","+emobile.getSoChoNgoi());
            buffWrite.newLine();
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
    }

    @Override
    void delete() {

    }

    @Override
    void find() {

    }
}
