package fake_final_exam.utils;

import fake_final_exam.models.Emobile;
import fake_final_exam.models.Motor;
import fake_final_exam.models.Truck;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWrite {
    private static final String EMOBILE_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam\\data\\emobile.csv";
    private static final String TRUCK_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam\\data\\truck.csv";
    private static final String MOTOR_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\fake_final_exam\\data\\motor.csv";

    public static void addEmobile(Emobile emobile) {
        try {
            FileWriter fileWriter = new FileWriter(EMOBILE_CSV, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            buffWrite.write(emobile.getBienKiemSoat() + "," + emobile.getHangSanXuat() + "," + emobile.getNamSanXuat() + "," + emobile.getChuSoHuu() + "," + emobile.getKieuXe() + "," + emobile.getSoChoNgoi());
            buffWrite.newLine();
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void addMotor(Motor motor) {
        try {
            FileWriter fileWriter = new FileWriter(MOTOR_CSV, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            buffWrite.write(motor.getBienKiemSoat() + "," + motor.getHangSanXuat() + "," + motor.getNamSanXuat() + "," + motor.getChuSoHuu() + "," + motor.getCongSuat());
            buffWrite.newLine();
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static void addTruck(Truck truck) {
        try {
            FileWriter fileWriter = new FileWriter(TRUCK_CSV, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            buffWrite.write(truck.getBienKiemSoat() + "," + truck.getHangSanXuat() + "," + truck.getNamSanXuat() + "," + truck.getChuSoHuu() + "," + truck.getTaiTrong());
            buffWrite.newLine();
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    public static List<Emobile> readEmobileFile(String filePath) {
        List<Emobile> emobileList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Emobile emobile;
            while ((line = bufferedReader.readLine()) != null) {
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
        }
        return emobileList;
    }

    public static List<Motor> readMotorFile(String filePath) {
        List<Motor> motorList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Motor motor;
            while ((line = bufferedReader.readLine()) != null) {
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
        }
        return motorList;
    }

    public static List<Truck> readTruckFile(String filePath) {
        List<Truck> truckList = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Truck truck;
            while ((line = bufferedReader.readLine()) != null) {
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
        }
        return truckList;
    }

    public static void writeAfterDeleteMotor(List<Motor> emobiles) {
        try {
            FileWriter fileWriter = new FileWriter(MOTOR_CSV, false);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            for (Motor motor : emobiles) {
                buffWrite.write(motor.getBienKiemSoat() + "," + motor.getHangSanXuat() + "," + motor.getNamSanXuat() + "," + motor.getChuSoHuu() + "," + motor.getCongSuat());
                buffWrite.newLine();
            }
            buffWrite.close();
        } catch (IOException e) {
            System.err.println("IOException " + e.toString());
        }
    }

    public static void writeAfterDeleteEmoblie(List<Emobile> emobileList) {
        try {
            FileWriter fileWriter = new FileWriter(EMOBILE_CSV, false);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            for (Emobile emobile : emobileList) {
                buffWrite.write(emobile.getBienKiemSoat() + "," + emobile.getHangSanXuat() + "," + emobile.getNamSanXuat() + "," + emobile.getChuSoHuu() + "," + emobile.getKieuXe() + "," + emobile.getSoChoNgoi());
                buffWrite.newLine();
            }
            buffWrite.close();
        } catch (IOException e) {
            System.err.println("IOException " + e.toString());
        }
    }

    public static void writeAfterDeleteTruck(List<Truck> truckList) {
        try {
            FileWriter fileWriter = new FileWriter(TRUCK_CSV, false);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            for (Truck truck : truckList) {
                buffWrite.write(truck.getBienKiemSoat() + "," + truck.getHangSanXuat() + "," + truck.getNamSanXuat() + "," + truck.getChuSoHuu() + "," + truck.getTaiTrong());
                buffWrite.newLine();
            }
            buffWrite.close();
        } catch (IOException e) {
            System.err.println("IOException " + e.toString());
        }
    }
}