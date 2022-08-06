package fake_final_exam.models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Motor extends Vehicle{
    private static final String MOTOR_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam\\data\\motor.csv";
    private double congSuat;

    public Motor() {
    }

    public Motor(String bienKiemSoat, String hangSanXuat, String namSanXuat, String chuSoHuu, double congSuat) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.congSuat = congSuat;
    }

    public double getCongSuat() {
        return congSuat;
    }

    public void setCongSuat(double congSuat) {
        this.congSuat = congSuat;
    }

    @Override
    public String toString() {
        return "Motor: " + super.toString() +
                "congSuat=" + congSuat;
    }

    public static void some(Motor motor){
        try {
            FileWriter fileWriter = new FileWriter(MOTOR_CSV, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            buffWrite.write(motor.getBienKiemSoat()+","+motor.getHangSanXuat()+","+motor.getNamSanXuat()+","+motor.getChuSoHuu()+","+motor.getCongSuat());
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
