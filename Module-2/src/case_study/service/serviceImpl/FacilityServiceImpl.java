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
    private static Set<Booking> bookingSet = new BookingServiceImpl().sendData();
    private static List<String> arrayList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> addFacilityMaintenance = new ArrayList<>();
    private static final String[] arrayType={"Hour","Day","Week","Month","Year","Age?"};
    private static final String FILE_BOOKING_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\booking.csv";
    private static final String FILE_ROOM_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\room.csv";
    private static final String FILE_HOUSE_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\house.csv";
    private static final String FILE_VILLA_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\villa.csv";

    static {
        readBookingFile(FILE_BOOKING_CSV, bookingSet);

        readHouseFile(FILE_HOUSE_CSV, houseIntegerMap);
        facilityIntegerMap.putAll(houseIntegerMap);
        readRoomFile(FILE_ROOM_CSV, roomIntegerMap);
        facilityIntegerMap.putAll(roomIntegerMap);
        readVillaFile(FILE_VILLA_CSV, villaIntegerMap);
        facilityIntegerMap.putAll(villaIntegerMap);
    }

    public static void checkFacilityMaintenance(){
        try {
            System.out.print("Input Faicility to add to Facility maintenance: ");
            String facilityIdInput = scanner.nextLine();
            for (Booking booking: bookingSet){
                if (facilityIdInput.equals(booking.getFacility())){
                    addFacilityMaintenance.add(booking.getFacility());
                }

            }
            if (addFacilityMaintenance.size() != 0){
                for (String facilityIn: addFacilityMaintenance){
                    Facility facility = searchFacility(facilityIn);
                    System.out.println(facility);
                }
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    @Override
    public void displayFacility() {
        try {
            for (Map.Entry<Facility, Integer> entry: facilityIntegerMap.entrySet()){
                System.out.println("Facility: " + entry.getKey() + "\nUsed: " + entry.getValue());
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    @Override
    public void facilityMaintenance() {
        System.out.println("List facility maintenance: ");
        for (Booking booking: bookingSet){
            arrayList.add(booking.getFacility());
        }if (arrayList.size() == 0){
            System.out.println("List facility maintenance is empty!");
        }if (arrayList.size() != 0){
            for (String s: arrayList){
                Facility facility = searchFacility(s);
                System.out.println(facility.toString());
            }
        }
    }

    public static Facility searchFacility(String id)
    {
        String maID=id.substring(0,4);

        if(maID.equalsIgnoreCase("SVVL"))
        {
            for (Map.Entry<Villa,Integer> villaIntegerEntry:villaIntegerMap.entrySet())
            {
                if(villaIntegerEntry.getKey().getFacilityID().equalsIgnoreCase(id))
                {
                    return villaIntegerEntry.getKey();
                }
            }
        }

        if(maID.equalsIgnoreCase("SVHO"))
        {
            for (Map.Entry<House,Integer> houseIntegerEntry:houseIntegerMap.entrySet())
            {
                if(houseIntegerEntry.getKey().getFacilityID().equalsIgnoreCase(id))
                {
                    return houseIntegerEntry.getKey();
                }
            }
        }

        if(maID.equalsIgnoreCase("SVRO"))
        {
            for (Map.Entry<Room,Integer> roomIntegerEntry:roomIntegerMap.entrySet())
            {
                if(roomIntegerEntry.getKey().getFacilityID().equalsIgnoreCase(id))
                {
                    return roomIntegerEntry.getKey();
                }
            }
        }

        return null;
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

