package fake_final_exam.models;

import fake_final_exam.service.impl.EmobileImpl;
import fake_final_exam.utils.ReadWrite;

import java.util.List;
import java.util.Scanner;

public class Emobile extends Vehicle{
    private static Scanner scanner = new Scanner(System.in);
    private static EmobileImpl emobileService = new EmobileImpl();
    private static List<String> hangSanXuat = new EmobileImpl().sendData();

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

    @Override
    public void add() {
        try {
            System.out.println("nhap vao bien kiem soat: ");
            String bks = scanner.nextLine();
            System.out.println("nhap vao so tuong ung voi hang: ");
            emobileService.displaySomething();
            int so = Integer.parseInt(scanner.nextLine());
            String hang = null;
            if (so > 0 || so < hangSanXuat.size()){
                hang = hangSanXuat.get(so);
            }
            System.out.println("nhap vao nam san xuat: ");
            String namSX = scanner.nextLine();
            System.out.println("nhap vao chu so huu: ");
            String chu = scanner.nextLine();
            System.out.println("nhap vao kieu xe: ");
            String kieuXe = scanner.nextLine();
            System.out.println("nhap vao so cho ngoi: ");
            int choNgoi = Integer.parseInt(scanner.nextLine());
            Emobile emobile = new Emobile(bks, hang, namSX, chu, kieuXe, choNgoi);
            ReadWrite.addEmobile(emobile);
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }
}
