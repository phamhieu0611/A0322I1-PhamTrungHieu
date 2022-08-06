package fake_final_exam.models;


import fake_final_exam.service.impl.TruckImpl;
import fake_final_exam.utils.ReadWrite;

import java.util.List;
import java.util.Scanner;


public class Truck extends Vehicle{
    private double taiTrong;
    private static Scanner scanner = new Scanner(System.in);
    private static TruckImpl truckService = new TruckImpl();
    private static List<String> hangSanXuat = new TruckImpl().sendData();



    public Truck(String bienKiemSoat, String hangSanXuat, String namSanXuat, String chuSoHuu, double taiTrong) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.taiTrong = taiTrong;
    }

    public Truck() {
    }

    @Override
    public void add() {
        try {
            System.out.println("nhap vao bien kiem soat: ");
            String bks = scanner.nextLine();
            System.out.println("nhap vao so tuong ung voi hang: ");
            truckService.displaySomething();
            String hang = null;
            int so = Integer.parseInt(scanner.nextLine());
            if (so > 0 || so < hangSanXuat.size()){
                hang = hangSanXuat.get(so);
            }
            System.out.println("nhap vao nam san xuat: ");
            String namSX = scanner.nextLine();
            System.out.println("nhap vao chu so huu: ");
            String chu = scanner.nextLine();
            System.out.println("nhap vao tai trong: ");
            double taiTrong = Double.parseDouble(scanner.nextLine());
            Truck truck = new Truck(bks, hang, namSX, chu, taiTrong);
            ReadWrite.addTruck(truck);
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    public double getTaiTrong() {
        return taiTrong;
    }

    public void setTaiTrong(double taiTrong) {
        this.taiTrong = taiTrong;
    }

    @Override
    public String toString() {
        return "Truck: " + super.toString() +
                "taiTrong=" + taiTrong;
    }
}
