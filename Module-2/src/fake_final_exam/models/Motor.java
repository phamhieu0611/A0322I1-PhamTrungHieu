package fake_final_exam.models;

import fake_final_exam.service.impl.MotorImpl;
import fake_final_exam.utils.ReadWrite;

import java.util.List;
import java.util.Scanner;

public class Motor extends Vehicle{
    private static Scanner scanner = new Scanner(System.in);
    private static MotorImpl motorServicec = new MotorImpl();
    private static List<String> hangSanXuat = new MotorImpl().sendData();
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

    @Override
    public void add() {
        try {
            System.out.println("nhap vao bien kiem soat: ");
            String bks = scanner.nextLine();
            System.out.println("nhap vao so tuong ung voi hang: ");
            motorServicec.displaySomething();
            int so = Integer.parseInt(scanner.nextLine());
            String hang = null;
            if (so > 0 || so < hangSanXuat.size()){
                hang = hangSanXuat.get(so);
            }
            System.out.println("nhap vao nam san xuat: ");
            String namSX = scanner.nextLine();
            System.out.println("nhap vao chu so huu: ");
            String chu = scanner.nextLine();
            System.out.println("nhap vao cong suat: ");
            double congSuat = Double.parseDouble(scanner.nextLine());
            Motor motor = new Motor(bks, hang, namSX, chu, congSuat);
            ReadWrite.addMotor(motor);
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }
}
