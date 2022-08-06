package fake_final_exam.service.impl;

import fake_final_exam.controller.Maincontroller;
import fake_final_exam.models.Truck;
import fake_final_exam.service.Vehicle;
import fake_final_exam.utils.ReadWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckImpl implements Vehicle {
    private static final String TRUCK_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam\\data\\truck.csv";
    private static Scanner scanner = new Scanner(System.in);
    public static List<Truck> truckList;
    private static List<String> hangSanXuat = new ArrayList<>();

    static {
        hangSanXuat.add("cac hang san xuat:");
        hangSanXuat.add("1-Mercedes-German");
        hangSanXuat.add("2-Toyota-Japan");
        hangSanXuat.add("3-Huyndai-Japan");
        hangSanXuat.add("4-Vinfast-VietNam");
    }

    public static List<String> sendData(){
        return hangSanXuat;
    }

    public static void displaySomething(){
        for (String s:hangSanXuat){
            System.out.println(s);
        }
    }

    @Override
    public void display() {
        truckList = ReadWrite.readTruckFile(TRUCK_CSV);
        if (truckList.size() != 0){
            for (Truck truck: truckList){
                System.out.println(truck.toString());
            }
        }if (truckList.size() == 0){
            System.out.println("The list Empty.");
        }
    }

    @Override
    public void delete() {
        display();
        System.out.println("Nhap vao bien so muon xoa: ");
        String bienSo = scanner.nextLine();
        try {
            for (Truck truck: truckList){
                if (bienSo.equalsIgnoreCase(truck.getBienKiemSoat())){
                    int select = 0;
                    System.out.println("Ban co chac chan muon xoa hay khong? ");
                    System.out.println("1. co");
                    System.out.println("2. khong");
                    select = Integer.parseInt(scanner.nextLine());
                    switch (select){
                        case 1:
                            truckList.remove(truck);
                            System.out.println("Done!");
                            ReadWrite.writeAfterDeleteTruck(truckList);
                            break;
                        case 2:
                            Maincontroller.mainController();
                            break;
                    }
                }
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    @Override
    public void find() {
        System.out.println("Nhap vao bien so muon tim kiem: ");
        String bienSo = scanner.nextLine();
        try {
            for (Truck truck: truckList){
                if (bienSo.equalsIgnoreCase(truck.getBienKiemSoat())){
                    System.out.println(truck);
                }
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }
}
