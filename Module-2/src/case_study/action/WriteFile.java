package case_study.action;

import case_study.models.Booking;
import case_study.models.Contract;
import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.models.person.Customer;
import case_study.models.person.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;

public class WriteFile {
    private static final String FILE_CONTRACT_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\contract.csv";
    private static final String FILE_BOOKING_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\booking.csv";
    public static final String FILE_CUSTOMER_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\customer.csv";
    public static final String FILE_EMPLOYEE_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\employee.csv";
    private static final String FILE_ROOM_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\room.csv";
    private static final String FILE_HOUSE_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\house.csv";
    private static final String FILE_VILLA_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\villa.csv";
    public static void editNewEmployee(ArrayList<Employee> employeeList) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_EMPLOYEE_CSV, false);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            for (Employee employee : employeeList) {
                buffWrite.write(employee.getId() + "," + employee.getIdCard() + "," + employee.getPhoneNumber() + "," + employee.getName() + "," + employee.getBirthDay() + "," + employee.getGender() + "," + employee.getEmail() + "," + employee.getLevel() + "," + employee.getWorkLocation() + "," + employee.getSalary());
                buffWrite.newLine();
            }
            buffWrite.close();
        } catch (IOException e) {
            System.err.println("IOException "+e.toString());
        }
    }

    public static void editNewCustomer(ArrayList<Customer> customersList){
        try {
            FileWriter fileWriter = new FileWriter(FILE_CUSTOMER_CSV, false);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            for (Customer customer : customersList) {
                buffWrite.write(customer.getId() + "," + customer.getIdCard() + "," + customer.getPhoneNumber() + "," + customer.getName() + "," + customer.getBirthDay() + "," + customer.getGender() + "," + customer.getEmail() + "," + customer.getTypeCustomer() + "," + customer.getAddress());
                buffWrite.newLine();
            }
            buffWrite.close();
        } catch (IOException e) {
            System.err.println("IOException "+e.toString());
        }
    }


    public static void addNewHouse(House house){
        try {
            FileWriter fileWriter = new FileWriter(FILE_HOUSE_CSV, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(house.getFacilityID()+","+house.getNameService()+","+house.getTypeRent()+","+house.getArea()+","+house.getPrice()+","+house.getMaxPerson()+","+house.getRoomStandard()+","+house.getFloor());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("Exception "+e.toString());
        }
    }

    public static void addNewRoom(Room room){
        try {
            FileWriter fileWriter = new FileWriter(FILE_ROOM_CSV, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(room.getFacilityID()+","+room.getNameService()+","+room.getTypeRent()+","+room.getArea()+","+room.getPrice()+","+room.getMaxPerson()+","+room.getFreeService());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("Exception "+e.toString());;
        }
    }

    public static void addNeewVilla(Villa villa){
        try {
            FileWriter fileWriter = new FileWriter(FILE_VILLA_CSV, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(villa.getFacilityID()+","+villa.getNameService()+","+villa.getTypeRent()+","+villa.getArea()+","+villa.getPrice()+","+villa.getMaxPerson()+","+villa.getRoomStandard()+","+villa.getAreaPool()+","+villa.getFloor());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("Exception "+e.toString());
        }
    }

    public static void addNewBooking(Booking booking){
        try {
            FileWriter fileWriter = new FileWriter(FILE_BOOKING_CSV, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(booking.getBookingID()+","+booking.getFirstDate()+","+booking.getLastDate()+","+booking.getCustomer()+","+booking.getFacility()+","+booking.getCustomer());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("Exception "+e.toString());
        }
    }

    public static void addNewContract(Contract contract){
        try {
            FileWriter fileWriter = new FileWriter(FILE_CONTRACT_CSV, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(contract.getContractID()+","+contract.getBookingID()+","+contract.getDeposit()+","+contract.getPaymnet());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (Exception e) {
            System.err.println("Exception "+e.toString());
        }
    }

    public static void writeToFileFacility(String path, Map<? extends Facility,Integer> listObject) {
        try {
            FileWriter fr = new FileWriter(path);
            BufferedWriter br = new BufferedWriter(fr);
            for (Map.Entry<? extends Facility,Integer> entry:listObject.entrySet()) {
                br.write(entry.getKey().toString()+","+entry.getValue());
                br.newLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.err.println("IOException "+e.toString());
        }
    }

    public static void writeToContract(String s, TreeSet<Contract> arrayContract) {
    }
}
