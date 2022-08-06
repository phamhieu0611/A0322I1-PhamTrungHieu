package fake_final_exam.service.impl;

import fake_final_exam.controller.Maincontroller;
import fake_final_exam.models.Emobile;
import fake_final_exam.service.Vehicle;
import fake_final_exam.utils.ReadWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmobileImpl implements Vehicle {
    private static final String EMOBILE_CSV= "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam\\data\\emobile.csv";
    private static Scanner scanner = new Scanner(System.in);
    public static List<String> hangSanXuat = new ArrayList<>();
    public static List<Emobile> emobileList = new ArrayList<>();

    static {
        hangSanXuat.add("cac hang san xuat:");
        hangSanXuat.add("1-Honda-Japan");
        hangSanXuat.add("2-Toyota-Japan");
        hangSanXuat.add("3-Huyndai-Japan");
        hangSanXuat.add("4-Mercedes-German");
    }
    public static void displaySomething(){
        for (String s:hangSanXuat){
            System.out.println(s);
        }
    }

    public static List<String> sendData(){
        return hangSanXuat;
    }

    @Override
    public void display() {
        emobileList = ReadWrite.readEmobileFile(EMOBILE_CSV);
        if (emobileList.size() != 0){
            for (Emobile emobile: emobileList){
                System.out.println(emobile.toString());
            }
        }if (emobileList.size() == 0){
            System.out.println("The list Empty.");
        }
    }

    @Override
    public void delete() {
        try {
            display();
        System.out.println("Nhap vao bien so muon xoa: ");
        String bienSo = scanner.nextLine();
            for (Emobile emobile: emobileList){
                if (bienSo.equalsIgnoreCase(emobile.getBienKiemSoat())){
                    int select = 0;
                    System.out.println("Ban co chac chan muon xoa "+emobile.toString()+" hay khong?");
                    System.out.println("1. co");
                    System.out.println("2. khong");
                    select = Integer.parseInt(scanner.nextLine());
                    switch (select){
                        case 1:
                            emobileList.remove(emobile);
                            ReadWrite.writeAfterDeleteEmoblie(emobileList);
                            System.out.println("Done!");
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
            for (Emobile emobile: emobileList){
                if (bienSo.equalsIgnoreCase(emobile.getBienKiemSoat())){
                    System.out.println(emobile);
                }
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }
}
