package fake_final_exam.service.impl;

import fake_final_exam.models.Motor;
import fake_final_exam.service.Vehicle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorImpl implements Vehicle {
    private static final String MOTOR_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam\\data\\motor.csv";
    private static Scanner scanner = new Scanner(System.in);
    public static List<String> hangSanXuat = new ArrayList<>();
    public static List<Motor> motorList = new ArrayList<>();

    static {
        motorList = readMotorFile(MOTOR_CSV);

        hangSanXuat.add("cac hang san xuat:");
        hangSanXuat.add("1-Kawasaki-Japan");
        hangSanXuat.add("2-Honda-Japan");
        hangSanXuat.add("3-Ducati-Italian");
        hangSanXuat.add("4-Yamaha-Japan");
    }

    public static void displaySomething(){
        for (String s:hangSanXuat){
            System.out.println(s);
        }
    }

    @Override
    public void add() {
        try {
            System.out.println("nhap vao bien kiem soat: ");
            String bks = scanner.nextLine();
            System.out.println("nhap vao so tuong ung voi hang: ");
            displaySomething();
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
            motor.some(motor);
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    public static List<Motor> readMotorFile(String filePath){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Motor motor;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                String bks = temp[0];
                String hang = temp[1];
                String namSX = temp[2];
                String chu = temp[3];
                double congSuat = Double.parseDouble(temp[4]);
                motor = new Motor(bks, hang, namSX, chu, congSuat);
                motorList.add(motor);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }return motorList;
    }

    @Override
    public void display() {
        motorList = readMotorFile(MOTOR_CSV);
        for (Motor motor: motorList){
            System.out.println(motor.toString());
        }
    }

    @Override
    public void delete() {

    }

    @Override
    public void find() {
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
