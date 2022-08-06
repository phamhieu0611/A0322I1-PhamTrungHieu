package fake_final_exam.models;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Truck extends Vehicle{
    private static final String TRUCK_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam\\data\\truck.csv";
    private double taiTrong;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Truck> truckList = new ArrayList<>();


    public Truck(String bienKiemSoat, String hangSanXuat, String namSanXuat, String chuSoHuu, double taiTrong) {
        super(bienKiemSoat, hangSanXuat, namSanXuat, chuSoHuu);
        this.taiTrong = taiTrong;
    }

    public Truck() {
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

    public static void some(Truck truck){
        try {
            FileWriter fileWriter = new FileWriter(TRUCK_CSV, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            buffWrite.write(truck.getBienKiemSoat()+","+truck.getHangSanXuat()+","+truck.getNamSanXuat()+","+truck.getChuSoHuu()+","+truck.getTaiTrong());
            buffWrite.newLine();
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
        }
    }

    @Override
    public void delete() {

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
    public void find() {
        System.out.println("Nhap vao bien so muon tim: ");
        String input = scanner.nextLine();
        truckList = readTruckFile(TRUCK_CSV);
        for (Truck truck: truckList){
            if (input.equalsIgnoreCase(truck.getBienKiemSoat())){
                System.out.println(truck.toString());
            }
        }
    }
}
