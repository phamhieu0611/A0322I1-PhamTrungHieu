package fake_final_exam.service.impl;

import fake_final_exam.models.Truck;
import fake_final_exam.service.Vehicle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckImpl implements Vehicle {
    private static final String TRUCK_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam\\data\\truck.csv";
    private static Scanner scanner = new Scanner(System.in);
    private static List<Truck> truckList = new ArrayList<>();
    private static List<String> hangSanXuat = new ArrayList<>();

    static {
        truckList = readTruckFile(TRUCK_CSV);

        hangSanXuat.add("cac hang san xuat:");
        hangSanXuat.add("1-Mercedes-German");
        hangSanXuat.add("2-Toyota-Japan");
        hangSanXuat.add("3-Huyndai-Japan");
        hangSanXuat.add("4-Vinfast-VietNam");
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
                truck.some(truck);
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
    }

    public static List<Truck> readTruckFile(String filePath){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Truck truck;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                String bks = temp[0];
                String hang = temp[1];
                String namSX = temp[2];
                String chu = temp[3];
                double taiTrong = Double.parseDouble(temp[4]);
                truck = new Truck(bks, hang, namSX, chu, taiTrong);
                truckList.add(truck);
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
        }return truckList;
    }


    @Override
    public void display() {
        truckList = readTruckFile(TRUCK_CSV);
        for (Truck truck: truckList){
            System.out.println(truck.toString());
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
