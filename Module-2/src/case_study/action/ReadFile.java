package case_study.action;


import case_study.models.Booking;
import case_study.models.Contract;
import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.models.person.Customer;
import case_study.models.person.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ReadFile {

    public static List<Employee> readEmployeeFile(String filePath){
        List<Employee> employees = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Employee employee;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                int id = Integer.parseInt(temp[0]);
                int idCard = Integer.parseInt(temp[1]);
                int phoneNumber = Integer.parseInt(temp[2]);
                String name = temp[3];
                String birthDay = temp[4];
                String Gender = temp[5];
                String email = temp[6];
                String level = temp[7];
                String workLocation = temp[8];
                double salary = Double.parseDouble(temp[9]);
                employee = new Employee(id, idCard, phoneNumber, name, birthDay, Gender, email, level, workLocation, salary);
                employees.add(employee);
            }
        } catch (Exception e) {
            System.err.println("File not found or ERROR!");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }return employees;
    }

    public static List<Customer> readCustomerFile(String filePath){
        List<Customer> customers = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Customer customer;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                int idCus = Integer.parseInt(temp[0]);
                int idCard = Integer.parseInt(temp[1]);
                int phoneNumber = Integer.parseInt(temp[2]);
                String name = temp[3];
                String birthDay = temp[4];
                String Gender = temp[5];
                String email = temp[6];
                String typeCustomer = temp[7];
                String address = temp[8];
                customer = new Customer(idCus, idCard, phoneNumber, name, birthDay, Gender, email, typeCustomer, address);
                customers.add(customer);
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
        }return customers;
    }

    public static void readHouseFile(String filePath, Map<House, Integer> houseIntegerMap){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            House house;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                String faciliryID = temp[0];
                String nameService = temp[1];
                String typeRent = temp[2];
                double price = Double.parseDouble(temp[3]);
                double area = Double.parseDouble(temp[4]);
                int maxPerson = Integer.parseInt(temp[5]);
                String roomStandart = temp[6];
                int floor = Integer.parseInt(temp[7]);
                house = new House(faciliryID, nameService, typeRent, price, area, maxPerson, roomStandart, floor);
                houseIntegerMap.put(house, 0);
            }
        } catch (Exception e) {
            System.err.println("Exception "+e.toString());
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                System.err.println("Exception "+e.toString());;
            }
        }
    }

    public static void readVillaFile(String filePath, Map<Villa, Integer> map){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Villa villa;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                String faciliryID = temp[0];
                String nameService = temp[1];
                String typeRent = temp[2];
                double price = Double.parseDouble(temp[3]);
                double area = Double.parseDouble(temp[4]);
                int maxPerson = Integer.parseInt(temp[5]);
                String roomStandart = temp[6];
                double areaPool = Double.parseDouble(temp[7]);
                int floor = Integer.parseInt(temp[8]);
                villa = new Villa(faciliryID, nameService, typeRent, price, area, maxPerson, roomStandart, areaPool, floor);
                map.put(villa, 0);
            }
        } catch (Exception e) {
            System.err.println("Exception "+e.toString());
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                System.err.println("Exception "+e.toString());
            }
        }
    }

    public static void readRoomFile(String filePath, Map<Room, Integer> map){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Room room;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                String faciliryID = temp[0];
                String nameService = temp[1];
                String typeRent = temp[2];
                double price = Double.parseDouble(temp[3]);
                double area = Double.parseDouble(temp[4]);
                int maxPerson = Integer.parseInt(temp[5]);
                String freeService = temp[6];
                room = new Room(faciliryID, nameService, typeRent, price, area, maxPerson, freeService);
                map.put(room, 0);
            }
        } catch (Exception e) {
            System.err.println("Exception "+e.toString());
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                System.err.println("Exeption "+e.toString());;
            }
        }
    }

    public static void readBookingFile(String filePath, Set<Booking> set){
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Booking booking;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                int bookingID = Integer.parseInt(temp[0]);
                String startDate = temp[1];
                String endDate = temp[2];
                int customerID = Integer.parseInt(temp[3]);
                String facilityID = temp[4];
                booking = new Booking(bookingID, startDate, endDate, customerID, facilityID);
                set.add(booking);
            }
        } catch (Exception e) {
            System.err.println("Exception "+e.toString());
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                System.err.println("Exeption "+e.toString());;
            }
        }
    }

    public static List<Contract> readContractFile(String filePath){
        List<Contract> contracts = new ArrayList<>();
        FileReader fileReaders = null;
        BufferedReader bufferedReaders = null;
        try {
            fileReaders = new FileReader(filePath);
            bufferedReaders = new BufferedReader(fileReaders);
            String line;
            String temp[];
            Contract contract;
            while ((line = bufferedReaders.readLine()) != null){
                temp = line.split(",");
                int contractId = Integer.parseInt(temp[0]);
                int idBooking = Integer.parseInt(temp[1]);
                int customerID = Integer.parseInt(temp[2]);
                String facilityID = temp[3];
                String startDate = temp[4];
                String endDate = temp[5];
                double deposit = Double.parseDouble(temp[6]);
                double paymnet = Double.parseDouble(temp[7]);
                contract = new Contract(contractId, idBooking, customerID, facilityID, startDate, endDate, deposit, paymnet);
                contracts.add(contract);
            }
        } catch (Exception e) {
            System.err.println("Exception "+e.toString());;
        } finally {
            try {
                bufferedReaders.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }return contracts;
    }

    public static void readDataFromVoucher(String path, Map<Integer,Integer> map) {
        try {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            map.clear();
            while ((line = br.readLine()) != null) {
                String[] strings=line.split(",");
                int id= Integer.parseInt(strings[0]);
                int voucher=Integer.parseInt(strings[1]);
                map.put(id,voucher);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
    }
}
