package fake_final_exam.service.impl;

import fake_final_exam.controller.Maincontroller;
import fake_final_exam.models.Motor;
import fake_final_exam.service.Vehicle;
import fake_final_exam.utils.ReadWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorImpl implements Vehicle {
    private static final String MOTOR_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam\\data\\motor.csv";
    private static Scanner scanner = new Scanner(System.in);
    public static List<String> hangSanXuat = new ArrayList<>();
    public static List<Motor> motorList = new ArrayList<>();

    static {

        hangSanXuat.add("cac hang san xuat:");
        hangSanXuat.add("1-Kawasaki-Japan");
        hangSanXuat.add("2-Honda-Japan");
        hangSanXuat.add("3-Ducati-Italian");
        hangSanXuat.add("4-Yamaha-Japan");
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
        motorList = ReadWrite.readMotorFile(MOTOR_CSV);
        if (motorList.size() != 0){
            for (Motor motor: motorList){
                System.out.println(motor.toString());
            }
        }if (motorList.size() == 0){
            System.out.println("The list Empty.");
        }
    }

    @Override
    public void delete() {
        try {
            display();
            System.out.println("Nhap vao bien so muon xoa: ");
            String bienSo = scanner.nextLine();
            for (Motor motor: motorList){
                if (bienSo.equalsIgnoreCase(motor.getBienKiemSoat())){
                    int select = 0;
                    System.out.println("Ban co chac chan muon xoa "+motor.toString()+" hay khong?");
                    System.out.println("1. co");
                    System.out.println("2. khong");
                    select = Integer.parseInt(scanner.nextLine());
                    switch (select){
                        case 1:
                            motorList.remove(motor);
                            ReadWrite.writeAfterDeleteMotor(motorList);
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
        motorList = ReadWrite.readMotorFile(MOTOR_CSV);
        if (motorList.size() != 0){
        System.out.println("Nhap vao bien so muon tim kiem: ");
        String bienSo = scanner.nextLine();
        try {
            for (Motor motor: motorList){
                if (bienSo.equalsIgnoreCase(motor.getBienKiemSoat())){
                    System.out.println(motor);
                }
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
        }
    }
}
