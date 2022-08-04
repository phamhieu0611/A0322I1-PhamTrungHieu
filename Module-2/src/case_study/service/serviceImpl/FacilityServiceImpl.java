package case_study.service.serviceImpl;

import case_study.action.Validate;
import case_study.action.WriteFile;
import case_study.models.Booking;
import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.service.FacilityService;

import java.util.*;

import static case_study.action.ReadFile.*;

public class FacilityServiceImpl implements FacilityService {
    private static Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
    private static Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();
    private static Map<Villa, Integer> villaIntegerMap = new LinkedHashMap<>();
    private static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String[] arrayType={"Hour","Day","Week","Month","Year","Age?"};
    private static final String FILE_ROOM_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\room.csv";
    private static final String FILE_HOUSE_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\house.csv";
    private static Set<Booking> bookingSet = new BookingServiceImpl().sendData();
    private static final String FILE_VILLA_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\villa.csv";
    private static ArrayList<String> maintenanceService;

    public FacilityServiceImpl(){
    }

    public static void abc(){
        System.out.println(maintenanceService);
    }

    @Override
    public void addFacility(Facility facility) {
        int value = 0;
        if (facility != null){
            if (facility instanceof Villa){
                villaIntegerMap.put((Villa) facility, value);
                WriteFile.writeToFileFacility(FILE_VILLA_CSV, villaIntegerMap);
            }if (facility instanceof House){
                houseIntegerMap.put((House) facility, value);
                WriteFile.writeToFileFacility(FILE_HOUSE_CSV, houseIntegerMap);
            }if (facility instanceof Room){
                roomIntegerMap.put((Room) facility, value);
                WriteFile.writeToFileFacility(FILE_ROOM_CSV, roomIntegerMap);
            }
        }
    }

    @Override
    public Facility getFacility(int index) {
        try {
            int id = 0;
            for (Facility key: facilityIntegerMap.keySet()){
                if (index == id){
                    return key;
                }id++;
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
        return null;
    }

    @Override
    public void displayFacility() {
        readBookingFile(BookingServiceImpl.FILE_CUSTOMER_CSV, bookingSet);
        readRoomFile(FILE_ROOM_CSV, roomIntegerMap);
        readVillaFile(FILE_VILLA_CSV, villaIntegerMap);
        readHouseFile(FILE_HOUSE_CSV, houseIntegerMap);
        for (Booking booking: bookingSet) {
            for (Map.Entry<House, Integer> entry : houseIntegerMap.entrySet()) {
                    System.out.println("Facility: " + entry.getKey() + "\nUsed: " + entry.getValue());
                    if (booking.getFacility().equals(entry.getKey().getFacilityID())){
                        maintenanceService.add(String.valueOf(entry.getKey()));
                    }
            }
            for (Map.Entry<Room, Integer> entryRoom : roomIntegerMap.entrySet()) {
                System.out.println("Facility: " + entryRoom.getKey() + "\nUsed: " + entryRoom.getValue());
                if (booking.getFacility().equals(entryRoom.getKey().getFacilityID())){
                    maintenanceService.add(String.valueOf(entryRoom.getKey()));
                }
            }
            for (Map.Entry<Villa, Integer> entryVilla : villaIntegerMap.entrySet()) {
                System.out.println("Facility: " + entryVilla.getKey() + "\nUsed: " + entryVilla.getValue());
                if (booking.getFacility().equals(entryVilla.getKey().getFacilityID())){
                    maintenanceService.add(String.valueOf(entryVilla.getKey()));
                }
            }
        }
    }

    @Override
    public int sizeFacility() {
        return facilityIntegerMap.size();
    }

    @Override
    public void displayListFacilityMain() {
        boolean check = false;
        try {
            int id = 0;
            for (Facility key : facilityIntegerMap.keySet()){
                if (facilityIntegerMap.get(key) > 4){
                    check = true;
                    break;
                }
            }if (check){
                for (Facility key : facilityIntegerMap.keySet()) {
                    if (facilityIntegerMap.get(key)>4) {
                        System.out.println("ID Facility: " + (id ++) + " Facility: " + key + " USED: " + facilityIntegerMap.get(key));
                    }
                }
            }else {
                System.out.println("All facility are fine");
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    public House addRegexHouse(){
        while (true){
            try {
                String facilitiID;
                while (true){
                    System.out.print("Input facility ID:");
                    facilitiID = scanner.nextLine();
                    if (Validate.checkIDFacility(facilitiID))
                        break;
                    System.out.println("Format Facility Id: SVXX-YYYY (with XX: House is HO and YYYY is number 0-9).");
                }
                String facilityIDHouse = facilitiID;
                String nameServices;
                while (true){
                    System.out.print("Input nameService: ");
                    nameServices = scanner.nextLine();
                    if (Validate.checkNameFacility(nameServices))
                        break;
                    System.out.println("Format Facility name: Xyyyyy (with X is an upper case and y an lower case).");
                }
                String nameServiceHouse = nameServices;
                System.out.println("Type: 1.Hour    2.Day   3.Week  4.Month 5.Year  6.Age?");
                int typeRents;
                while (true){
                    System.out.print("Type rent: ");
                    String typeRentes = scanner.nextLine();
                    if (Validate.checkOneNumber(typeRentes)){
                        typeRents = Integer.parseInt(typeRentes);
                        if (typeRents>=1 && typeRents<=6)
                            break;
                    }
                    System.out.println("Please re-enter type rent!");
                }
                String typeRentHouse = arrayType[typeRents];
                System.out.print("Input area: ");
                double areaHouse = Double.parseDouble(scanner.nextLine());
                int maxPersons;
                while (true){
                    System.out.print("Input MaxPerson: ");
                    maxPersons = Integer.parseInt(scanner.nextLine());
                    if (Validate.checkMaxPerson(maxPersons))
                        break;
                }
                int maxPersonHouse = maxPersons;
                double priceIn;
                while (true){
                    System.out.print("Input rent price: ");
                    priceIn = Double.parseDouble(scanner.nextLine());
                    if (Validate.checkRentPrice(priceIn))
                        break;
                }
                double priceHouse = priceIn;
                String roomStandart;
                while (true){
                    System.out.print("Input roomStandard: ");
                    roomStandart = scanner.nextLine();
                    if (Validate.checkNameFacility(roomStandart))
                        break;
                    System.out.println("Format room standart: Xyyyyy (with X is an upper case and y an lower case).");
                }
                String roomStandardHouse = roomStandart;
                int floors;
                while (true){
                    System.out.print("Input floor in House: ");
                    floors = Integer.parseInt(scanner.nextLine());
                    if (Validate.checkNumberFloors(floors))
                        break;
                }
                int floorHouse = floors;
                return new House(facilityIDHouse, nameServiceHouse, typeRentHouse, priceHouse, areaHouse, maxPersonHouse, roomStandardHouse, floorHouse);
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }
    public Room addRegexRoom(){
        while (true){
            try {
                String facilitiID;
                while (true){
                    System.out.print("Input facility ID:");
                    facilitiID = scanner.nextLine();
                    if (Validate.checkIDFacility(facilitiID))
                        break;
                    System.out.println("Format Facility Id: SVXX-YYYY (with XX: Room is RO and YYYY is number 0-9).");
                }
                String facilityIDRoom = facilitiID;
                String nameServices;
                while (true){
                    System.out.print("Input nameService: ");
                    nameServices = scanner.nextLine();
                    if (Validate.checkNameFacility(nameServices))
                        break;
                    System.out.println("Format Facility name: Xyyyyy (with X is an upper case and y an lower case).");
                }
                String nameServiceRoom = nameServices;
                System.out.println("Type: 1.Hour    2.Day   3.Week  4.Month 5.Year  6.Age?");
                int typeRents;
                while (true){
                    System.out.print("Type rent: ");
                    String typeRentes = scanner.nextLine();
                    if (Validate.checkOneNumber(typeRentes)){
                        typeRents = Integer.parseInt(typeRentes);
                        if (typeRents>=1 && typeRents<=6)
                            break;
                    }
                    System.out.println("Please re-enter type rent!");
                }
                String typeRentRoom = arrayType[typeRents];
                System.out.print("Input area: ");
                double areaRoom = Double.parseDouble(scanner.nextLine());
                int maxPersons;
                while (true){
                    System.out.print("Input MaxPerson: ");
                    maxPersons = Integer.parseInt(scanner.nextLine());
                    if (Validate.checkMaxPerson(maxPersons))
                        break;
                }
                int maxPersonRoom = maxPersons;
                double priceIn;
                while (true){
                    System.out.print("Input rent price: ");
                    priceIn = Double.parseDouble(scanner.nextLine());
                    if (Validate.checkRentPrice(priceIn))
                        break;
                }
                double priceRoom = priceIn;
                System.out.print("Input Free service in House: ");
                String freeService = scanner.nextLine();
                return new Room(facilityIDRoom, nameServiceRoom, typeRentRoom, priceRoom, areaRoom, maxPersonRoom, freeService);
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }
    public Villa addRegexVilla(){
        while (true){
            try {
                String facilitiID;
                while (true){
                    System.out.print("Input facility ID:");
                    facilitiID = scanner.nextLine();
                    if (Validate.checkIDFacility(facilitiID))
                        break;
                    System.out.println("Format Facility Id: SVXX-YYYY (with XX: Villa is VL and YYYY is number 0-9).");
                }
                String facilityIDVilla = facilitiID;
                String nameServices;
                while (true){
                    System.out.print("Input nameService: ");
                    nameServices = scanner.nextLine();
                    if (Validate.checkNameFacility(nameServices))
                        break;
                    System.out.println("Format Facility name: Xyyyyy (with X is an upper case and y an lower case).");
                }
                String nameServiceVilla = nameServices;
                System.out.println("Type: 1.Hour    2.Day   3.Week  4.Month 5.Year  6.Age?");
                int typeRents;
                while (true){
                    System.out.print("Type rent: ");
                    String typeRentes = scanner.nextLine();
                    if (Validate.checkOneNumber(typeRentes)){
                        typeRents = Integer.parseInt(typeRentes);
                        if (typeRents>=1 && typeRents<=6)
                            break;
                    }
                    System.out.println("Please re-enter type rent!");
                }
                String typeRentVilla = arrayType[typeRents];
                System.out.print("Input area: ");
                double areaVilla = Double.parseDouble(scanner.nextLine());
                int maxPersons;
                while (true){
                    System.out.print("Input MaxPerson: ");
                    maxPersons = Integer.parseInt(scanner.nextLine());
                    if (Validate.checkMaxPerson(maxPersons))
                        break;
                }
                int maxPersonVilla = maxPersons;
                double priceIn;
                while (true){
                    System.out.print("Input rent price: ");
                    priceIn = Double.parseDouble(scanner.nextLine());
                    if (Validate.checkRentPrice(priceIn))
                        break;
                }
                double priceVilla = priceIn;
                String roomStandart;
                while (true){
                    System.out.print("Input roomStandard: ");
                    roomStandart = scanner.nextLine();
                    if (Validate.checkRoomStandart(roomStandart))
                        break;
                    System.out.println("Format room standart: Xyyyyy (with X is an upper case and y an lower case).");
                }
                String roomStandardVilla = roomStandart;
                double areaPool;
                while (true){
                    System.out.print("Input areapool of villa: ");
                    areaPool = Double.parseDouble(scanner.nextLine());
                    if (Validate.checkPoolArea(areaPool))
                        break;
                }
                double areaPoolVilla = areaPool;
                int floors;
                while (true){
                    System.out.print("Input floor in House: ");
                    floors = Integer.parseInt(scanner.nextLine());
                    if (Validate.checkNumberFloors(floors))
                        break;
                }
                int floorVilla = floors;
                return new Villa(facilityIDVilla, nameServiceVilla, typeRentVilla, priceVilla, areaVilla, maxPersonVilla, roomStandardVilla, areaPoolVilla, floorVilla);
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }
}

