package case_study.service.serviceImpl;

import case_study.action.BookingComparator;
import case_study.action.Validate;
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
    private static final String FILE_BOOKING_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\booking.csv";
    private static final String FILE_ROOM_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\room.csv";
    private static final String FILE_HOUSE_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\house.csv";
    private static final String FILE_VILLA_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\villa.csv";
    private static Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
    private static Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();
    private static Map<Villa, Integer> villaIntegerMap = new LinkedHashMap<>();
    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static final String[] arrayType={"Hour","Day","Week","Month","Year","Age?"};
    public static final String FILE_CUSTOMER_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\customer.csv";
    private static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());
    private static ArrayList<Customer> customerList;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Booking> setArrayList = new ArrayList<>();
    private static FacilityServiceImpl facilityService = new FacilityServiceImpl();

    static {
        customerList = (ArrayList<Customer>) readCustomerFile(FILE_CUSTOMER_CSV);
        readHouseFile(FILE_HOUSE_CSV, houseIntegerMap);
        facilityIntegerMap.putAll(houseIntegerMap);
        readRoomFile(FILE_ROOM_CSV, roomIntegerMap);
        facilityIntegerMap.putAll(roomIntegerMap);
        readVillaFile(FILE_VILLA_CSV, villaIntegerMap);
        facilityIntegerMap.putAll(villaIntegerMap);

    }

    public static void display(){
        facilityService.displayFacility();
    }

    public Set<Booking> sendData(){
        return bookingSet;
    }

    private int indexBooking(int id)
    {
        setArrayList.addAll(bookingSet);
        int index=-1;
        for (int i=0; i<setArrayList.size(); i++)
        {
            if (id==setArrayList.get(i).getBookingID())
            {
                index=i;
                break;
            }
        }
        return index;
    }

//    public static double useVoucher(Booking booking){
//        int customerID =booking.getCustomer();
//        String facilityID = booking.getFacility();
//        Facility facility = FacilityServiceImpl.searchFacility(facilityID);
//        double useVoucher =VoucherService.getVoucher(customerID)*0.1;
//        double day =countDay(booking.getFirstDate(), booking.getLastDate());
//        double paymnet = rentType(facility);
//        double total =day*paymnet*(1-useVoucher);
//        return total;
//    }

    public static double rentType(Facility facility){
        double renCost = 0;
        String rentType = facility.getTypeRent();
        double rentPrice =facility.getPrice();
        if (rentType.equalsIgnoreCase(arrayType[0])){
            renCost = rentPrice/24;
        }if (rentType.equalsIgnoreCase(arrayType[1])){
            renCost = rentPrice;
        }if (rentType.equalsIgnoreCase(arrayType[2])){
            renCost = rentPrice*7;
        }if (rentType.equalsIgnoreCase(arrayType[3])){
            renCost = rentPrice*30;
        }if (rentType.equalsIgnoreCase(arrayType[4])){
            renCost = rentPrice*365;
        }if (rentType.equalsIgnoreCase(arrayType[4])){
            return renCost;
        }
        return renCost;
    }

    @Override
    public void addBooking() {
            displayBooking();
            try {
                String idInput;
                while (true) {
                    System.out.println("Input booking id (ID can not same): ");
                    idInput = scanner.nextLine();
                    if (Validate.checkId(idInput))
                        break;
                    System.out.println("Format ID: xxxx (x is a number).");
                }
                int id = Integer.parseInt(idInput);
                int checkID = indexBooking(id);
                if (checkID == -1) {
                    int customer = chooseCustomer();
                    String facility = chooseFacility();
                    String inputDayStart;
                    while (true) {
                        System.out.print("Input starting day rent: ");
                        inputDayStart = scanner.nextLine();
                        if (Validate.dateRegex(inputDayStart))
                            break;
                        System.out.println("Format: dd-MM-yyyy");
                    }
                    String startDate = inputDayStart;
                    String inputDayEnd;
                    while (true) {
                        System.out.print("Input end day rent: ");
                        inputDayEnd = scanner.nextLine();
                        if (Validate.dateRegex(inputDayEnd))
                            break;
                        System.out.println("Format: dd-MM-yyyy");
                    }
                    String endDate = inputDayEnd;
                    Booking booking = new Booking(id, startDate, endDate, customer, facility);
                    WriteFile.addNewBooking(booking);
                    bookingSet.add(booking);
                    System.out.println("Added complete!");
                }if (checkID == 0){
                    System.out.println("Booking id already exists.");
                }
            } catch (Exception e) {
                System.err.println("Exception " + e.toString());
            }
    }

    @Override
    public void displayBooking() {
        readBookingFile(FILE_BOOKING_CSV, bookingSet);
        System.out.println("Booking List: ");
        for (Booking booking: bookingSet){
            System.out.println(booking);
        }
        System.out.println("\n");
    }

    public static int chooseCustomer(){
        try {
            readCustomerFile(FILE_CUSTOMER_CSV);
            System.out.println("Customer List: ");
            for (Customer customer:customerList){
                System.out.println(customer.toString());
            }
            String idInput;
            while (true){
                System.out.print("Input Customer ID: ");
                idInput = scanner.nextLine();
                if (Validate.checkId(idInput))
                    break;
                System.out.print("ID not found, try again: ");
            }
            int id = Integer.parseInt(idInput);
            boolean check = true;
            while (check){
                for (Customer customer: customerList){
                    if (id == customer.getId()){
                        check = false;
                        return customer.getId();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Exception "+e.toString());
        }return Integer.parseInt(null);
    }

    public static String chooseFacility(){
        try {
            System.out.println("Facillity List: ");
            display();
            String idInputFacility;
            while (true){
                System.out.print("Input Facility ID: ");
                idInputFacility = scanner.nextLine();
                if (Validate.checkIDFacility(idInputFacility))
                    break;
                System.out.println("Format Facility Id: SVXX-YYYY (with XX: House is HO and YYYY is number 0-9).");
            }
            boolean check = true;
            String id = idInputFacility;
            while (check){
                for (Map.Entry<Facility, Integer> entry: facilityIntegerMap.entrySet()) {
                    if (id.equals(entry.getKey().getFacilityID())){
                        check = false;
                        return entry.getKey().getFacilityID();
                    }
                } if (check) {
                    System.out.print("ID nout found, try again: ");
                    id = scanner.nextLine();
                }
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }return null;
    }
}
