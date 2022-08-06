package fake_final_exam.service.impl;

import fake_final_exam.models.Emobile;
import fake_final_exam.models.Motor;
import fake_final_exam.service.Vehicle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmobileImpl implements Vehicle {
    private static final String EMOBILE_CSV= "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam\\data\\emobile.csv";
    private static Scanner scanner = new Scanner(System.in);
    public static List<String> hangSanXuat = new ArrayList<>();
    public static List<Emobile> emobileList = new ArrayList<>();

    static {
        emobileList = readEmobileFile(EMOBILE_CSV);

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
            System.out.println("nhap vao kieu xe: ");
            String kieuXe = scanner.nextLine();
            System.out.println("nhap vao so cho ngoi: ");
            int choNgoi = Integer.parseInt(scanner.nextLine());
            Emobile emobile = new Emobile(bks, hang, namSX, chu, kieuXe, choNgoi);
            emobile.some(emobile);
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    public static List<Emobile> readEmobileFile(String filePath){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Emobile emobile;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                String bks = temp[0];
                String hang = temp[1];
                String namSX = temp[2];
                String chu = temp[3];
                String kieuXe = temp[4];
                int choNgoi = Integer.parseInt(temp[5]);
                emobile = new Emobile(bks, hang, namSX, chu, kieuXe, choNgoi);
                emobileList.add(emobile);
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
        }return emobileList;
    }


    @Override
    public void display() {
        emobileList = readEmobileFile(EMOBILE_CSV);
        for (Emobile emobile: emobileList){
            System.out.println(emobile.toString());
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
