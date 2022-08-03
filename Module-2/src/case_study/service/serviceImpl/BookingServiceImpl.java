package case_study.service.serviceImpl;

import case_study.action.BookingComparator;
import case_study.action.WriteFile;
import case_study.models.Booking;
import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.models.person.Customer;
import case_study.service.BookingService;

import java.util.*;

import static case_study.action.ReadFile.*;
import static case_study.action.ReadFile.readVillaFile;

public class BookingServiceImpl implements BookingService {

    private static final String FILE_ROOM_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\room.csv";
    private static final String FILE_HOUSE_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\house.csv";
    private static final String FILE_VILLA_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\villa.csv";
    private static Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
    private static Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();
    private static Map<Villa, Integer> villaIntegerMap = new LinkedHashMap<>();public static final String FILE_CUSTOMER_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\customer.csv";
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    private static ArrayList<Customer> customerList;
    static Scanner scanner = new Scanner(System.in);

    static {
        customerList = (ArrayList<Customer>) readCustomerFile(FILE_CUSTOMER_CSV);
    }

    public Set<Booking> sendData(){
        return bookingSet;
    }

    public static void dispplayFacility(){
            readHouseFile(FILE_HOUSE_CSV, houseIntegerMap);
            for (Map.Entry<House, Integer> entry : houseIntegerMap.entrySet()){
                System.out.println("Facility: "+entry.getKey()+"\nUsed: "+entry.getValue());
            }
            readRoomFile(FILE_ROOM_CSV, roomIntegerMap);
            for (Map.Entry<Room, Integer> entryRoom : roomIntegerMap.entrySet()){
                System.out.println("Facility: "+entryRoom.getKey()+"\nUsed: "+entryRoom.getValue());
            }
            readVillaFile(FILE_VILLA_CSV, villaIntegerMap);
            for (Map.Entry<Villa, Integer> entryVilla : villaIntegerMap.entrySet()){
                System.out.println("Facility: "+entryVilla.getKey()+"\nUsed: "+entryVilla.getValue());
            }
    }

    @Override
    public void addBooking() {
        try {
            int id = 1;
            if (!bookingSet.isEmpty()){
                id = bookingSet.size()+1;
            }
            Customer customer = chooseCustomer();
            Facility facility = chooseFacility();
            System.out.print("Input starting day rent: ");
            String startDate = scanner.nextLine();
            System.out.print("Input end day rent: ");
            String endDate = scanner.nextLine();
            Booking booking = new Booking(id, startDate, endDate, customer, facility);
            WriteFile.addNewBooking(booking);
            bookingSet.add(booking);
            System.out.println("Added complete!");

        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    @Override
    public void displayBooking() {
        System.out.println("Booking List: ");
        for (Booking booking: bookingSet){
            System.out.println(booking);
        }
    }

    public static Customer chooseCustomer(){
        try {
            System.out.println("Customer List: ");
            for (Customer customer:customerList){
                System.out.println(customer.toString());
            }
            System.out.print("Input Customer ID: ");
            boolean check = true;
            int id = Integer.parseInt(scanner.nextLine());
            while (check){
                for (Customer customer: customerList){
                    if (id == customer.getId()){
                        check = false;
                        return customer;
                    }
                }
                if (check){
                    System.out.print("ID not found, try again: ");
                    id = Integer.parseInt(scanner.nextLine());
                }
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }return null;
    }

    public static Facility chooseFacility(){
        try {
            System.out.println("Facillity List: ");
            dispplayFacility();
            System.out.print("Input Facility ID: ");
            boolean check = true;
            String id = scanner.nextLine();
            while (check){
                for (Map.Entry<House, Integer> entry : houseIntegerMap.entrySet()){
                    if (id.equals(entry.getKey().getFacilityID())){
                        check = false;
                        return entry.getKey();
                    }
                }for (Map.Entry<Room, Integer> entryRoom : roomIntegerMap.entrySet()) {
                    if (id.equals(entryRoom.getKey().getFacilityID())) {
                        check = false;
                        return entryRoom.getKey();
                    }
                }for (Map.Entry<Villa, Integer> entryVilla : villaIntegerMap.entrySet()){
                    if (id.equals(entryVilla.getKey().getFacilityID())){
                        check = false;
                        return entryVilla.getKey();
                    }
                }
                if (check){
                    System.out.print("ID nout found, try again: ");
                    id = scanner.nextLine();
                }
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }return null;
    }
}
