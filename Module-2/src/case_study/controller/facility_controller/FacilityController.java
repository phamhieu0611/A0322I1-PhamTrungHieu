package case_study.controller.facility_controller;

import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.models.person.Employee;
import case_study.service.FacilityService;
import case_study.service.serviceImpl.FacilityServiceImpl;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FacilityController {
    private static Scanner scanner = new Scanner(System.in);
    private static FacilityService facilityService = new FacilityServiceImpl();
    public static final String FILE_ROOM_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\room.csv";
    public static final String FILE_HOUSE_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\house.csv";
    public static final String FILE_VILLA_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\villa.csv";

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
                int id = Integer.parseInt(temp[1].substring(5, 9));
                String nameService = temp[2];
                String typeRent = temp[3];
                double price = Double.parseDouble(temp[4]);
                double area = Double.parseDouble(temp[5]);
                int maxPerson = Integer.parseInt(temp[6]);
                String freeService = temp[7];
                room = new Room(faciliryID, nameService, typeRent, price, area, maxPerson, freeService);
                int value = Integer.parseInt(temp[8]);
                map.put(room, value);
                if (Facility.getId()<id){
                    Facility.setId(id);
                }
            }
        } catch (Exception e) {
            System.err.println("File not found or ERROR!");
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void displayAllList() {
        List<Room> roomList = readRoomFile(FILE_ROOM_CSV);
        for (Room rooms : roomList) {
            System.out.println(rooms);
        }
    }

    public static void addNewHouse(House house){
        try {
            FileWriter fileWriter = new FileWriter(FILE_HOUSE_CSV, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(house.getFacilityID()+","+house.getNameService()+","+house.getTypeRent()+","+house.getPrice()+","+house.getMaxPerson()+","+house.getRoomStandard()+","+house.getFloor());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNewRoom(Room room){
        try {
            FileWriter fileWriter = new FileWriter(FILE_ROOM_CSV, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(room.getFacilityID()+","+room.getNameService()+","+room.getTypeRent()+","+room.getPrice()+","+room.getMaxPerson()+","+room.getFreeService());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addNeewVilla(Villa villa){
        try {
            FileWriter fileWriter = new FileWriter(FILE_VILLA_CSV, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.newLine();
            bufferedWriter.write(villa.getFacilityID()+","+villa.getNameService()+","+villa.getTypeRent()+","+villa.getPrice()+","+villa.getMaxPerson()+","+villa.getRoomStandard()+","+villa.getFloor());
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readHouseFile(String filePath, Map<House, Integer> map){
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
                int id = Integer.parseInt(temp[1].substring(5, 9));
                String nameService = temp[2];
                String typeRent = temp[3];
                double price = Double.parseDouble(temp[4]);
                double area = Double.parseDouble(temp[5]);
                int maxPerson = Integer.parseInt(temp[6]);
                String roomStandart = temp[7];
                int floor = Integer.parseInt(temp[8]);
                house = new House(faciliryID, nameService, typeRent, price, area, maxPerson, roomStandart, floor);
                int value = Integer.parseInt(temp[9]);
                map.put(house, value);
                if (Facility.getId()<id){
                    Facility.setId(id);
                }
            }
        } catch (Exception e) {
            System.err.println("File not found or ERROR!");
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
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
                int id = Integer.parseInt(temp[1].substring(5, 9));
                String nameService = temp[2];
                String typeRent = temp[3];
                double price = Double.parseDouble(temp[4]);
                double area = Double.parseDouble(temp[5]);
                int maxPerson = Integer.parseInt(temp[6]);
                String roomStandart = temp[7];
                double areaPool = Double.parseDouble(temp[8]);
                int floor = Integer.parseInt(temp[9]);
                villa = new Villa(faciliryID, nameService, typeRent, price, area, maxPerson, roomStandart, areaPool, floor);
                int value = Integer.parseInt(temp[10]);
                map.put(villa, value);
                if (Facility.getId()<id){
                    Facility.setId(id);
                }
            }
        } catch (Exception e) {
            System.err.println("File not found or ERROR!");
        } finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getChoiceID(FacilityService facilityService){
        int choseID = 0;
        do{
            System.out.println("Chose "+facilityService.sizeFacility()+" to exit");
            System.out.println("Chose ID you want to edit:");
            choseID = Integer.parseInt(scanner.nextLine());
            Facility facility = facilityService.getFacility(choseID);
            if(facility==null){
                System.out.println("Chose "+facilityService.sizeFacility()+" to exit");
                System.out.println("Chose ID again to edit:");
                choseID = Integer.parseInt(scanner.nextLine());
            }
        }while (choseID == facilityService.sizeFacility());
        return choseID;
    }

    public static int getChoseIDEditFacility(FacilityService facilityService) {
        int choseID = 0;
        do{
            System.out.println("Chose "+facilityService.sizeFacility()+" to exit");
            System.out.println("Chose ID you want to edit:");
            choseID = Integer.parseInt(scanner.nextLine());
            Facility facility = facilityService.getFacility(choseID);
            if(facility==null){
                System.out.println("Chose "+facilityService.sizeFacility()+" to exit");
                System.out.println("Chose ID again to edit:");
                choseID = Integer.parseInt(scanner.nextLine());
            }
        }while (choseID == facilityService.sizeFacility());
        return choseID;
    }

    public static void editFacilityService(FacilityService facilityService) {
        facilityService.displayFacility();
        int choseID = getChoseIDEditFacility(facilityService);
        Facility facility = facilityService.getFacility(choseID);
        if(facility instanceof House){
            House editHouse = (House) facility;
            int choseMenuEditHouse = 0;
            do{
                choseMenuEditHouse = getChoseMenuEditHouse(choseID, editHouse);
                chosePropertiesEditHouse(editHouse, choseMenuEditHouse);
            }while (choseMenuEditHouse != 7);
        }else if(facility instanceof Room){
            Room editRoom = (Room) facility;
            int choseMenuEditRoom = 0;
            do{
                choseMenuEditRoom = getChoseMenuEditRoom(choseID, editRoom);
                chosePropertiesEditRoom(editRoom, choseMenuEditRoom);
            }while (choseMenuEditRoom != 6);
        }else if(facility instanceof Villa){
            Villa editVilla = (Villa) facility;
            int choseMenuEditVilla = 0;
            do{
                choseMenuEditVilla = getChoseMenuEditVilla(choseID, editVilla);
                chosePropertiesEditVilla(editVilla, choseMenuEditVilla);
            }while (choseMenuEditVilla != 8);
        }
    }
    public static int getChoseMenuEditHouse(int choseID, House editHouse) {
        int choseMenuEditHouse;
        System.out.println("Chose on Menu Edit House "+choseID+": ");
        System.out.println("1\tEdit Name Service ("+editHouse.getNameService()+")");
        System.out.println("2\tEdit Area Use ("+editHouse.getArea()+")");
        System.out.println("3\tEdit floors ("+editHouse.getFloor()+")");
        System.out.println("4\tEdit Maximum People ("+editHouse.getMaxPerson()+")");
        System.out.println("5\tEdit Standard Room ("+editHouse.getRoomStandard()+")");
        System.out.println("6\tEdit Rental Cost ("+editHouse.getPrice()+")");
        System.out.println("7\tReturn main menu");
        choseMenuEditHouse = Integer.parseInt(scanner.nextLine());
        return choseMenuEditHouse;
    }
    public static void chosePropertiesEditHouse(House houseEdit, int choseMenuEditHouse) {
        switch (choseMenuEditHouse){
            case 1:
                System.out.println("Enter Name Service for new House: ");
                String nameService = scanner.nextLine();
                houseEdit.setNameService(nameService);
                break;
            case 2:
                System.out.println("Enter Area Use for new House: ");
                double areaUse = Double.parseDouble(scanner.nextLine());
                houseEdit.setArea(areaUse);
                break;
            case 3:
                System.out.println("Enter floors for new House: ");
                int floors = Integer.parseInt(scanner.nextLine());
                houseEdit.setFloor(floors);
                break;
            case 4:
                System.out.println("Enter Maximum People for new House : ");
                int maximumPeople = Integer.parseInt(scanner.nextLine());
                houseEdit.setMaxPerson(maximumPeople);
                break;
            case 5:
                System.out.println("Enter Standard Room for new House: ");
                String sRoom = scanner.nextLine();
                houseEdit.setRoomStandard(sRoom);
                break;
            case 6:
                System.out.println("Enter Rental Cost for new House : ");
                double rentalCost = Double.parseDouble(scanner.nextLine());
                houseEdit.setPrice(rentalCost);
                break;
        }
    }
    public static void chosePropertiesEditVilla(Villa editVilla, int choseMenuEditVilla) {
        switch (choseMenuEditVilla){
            case 1:
                System.out.println("Enter Name Service for new Villa: ");
                String nameService = scanner.nextLine();
                editVilla.setNameService(nameService);
                break;
            case 2:
                System.out.println("Enter Area Use for new Villa: ");
                double areaUse = Double.parseDouble(scanner.nextLine());
                editVilla.setArea(areaUse);
                break;
            case 3:
                System.out.println("Enter floors for new Villa: ");
                int floors =Integer.parseInt(scanner.nextLine());
                editVilla.setFloor(floors);
                break;
            case 4:
                System.out.println("Enter Maximum People for new Villa : ");
                int maximumPeople = Integer.parseInt(scanner.nextLine());
                editVilla.setMaxPerson(maximumPeople);
                break;
            case 5:
                System.out.println("Enter Standard Room for new Villa: ");
                String sRoom = scanner.nextLine();
                editVilla.setRoomStandard(sRoom);
                break;
            case 6:
                System.out.println("Enter Rental Cost for new Villa : ");
                double rentalCost = Double.parseDouble(scanner.nextLine());
                editVilla.setPrice(rentalCost);
                break;
            case 7:
                System.out.println("Enter pool Area for new Villa : ");
                double poolArea = Double.parseDouble(scanner.nextLine());
                editVilla.setAreaPool(poolArea);
                break;
        }
    }

    public static int getChoseMenuEditVilla(int choseID, Villa editVilla) {
        int choseMenuEditVilla;
        System.out.println("Chose on Menu Edit Villa "+choseID+": ");
        System.out.println("1\tEdit Name Service ("+editVilla.getNameService()+")");
        System.out.println("2\tEdit Area Use ("+editVilla.getArea()+")");
        System.out.println("3\tEdit floors ("+editVilla.getFloor()+")");
        System.out.println("4\tEdit Maximum People ("+editVilla.getMaxPerson()+")");
        System.out.println("5\tEdit Standard Room ("+editVilla.getRoomStandard()+")");
        System.out.println("6\tEdit Rental Cost ("+editVilla.getPrice()+")");
        System.out.println("7\tEdit Pool Area ("+editVilla.getAreaPool()+")");
        System.out.println("8\tReturn main menu");
        choseMenuEditVilla = Integer.parseInt(scanner.nextLine());
        return choseMenuEditVilla;
    }

    public static void chosePropertiesEditRoom(Room editRoom, int choseMenuEditRoom) {
        switch (choseMenuEditRoom){
            case 1:
                System.out.println("Enter Name Service for new Room: ");
                String nameService = scanner.nextLine();
                editRoom.setNameService(nameService);
                break;
            case 2:
                System.out.println("Enter Area Use for new Room: ");
                double areaUse = Double.parseDouble(scanner.nextLine());
                editRoom.setArea(areaUse);
                break;
            case 3:
                System.out.println("Enter Free Service for new Room: ");
                String freeService = scanner.nextLine();
                editRoom.setFreeService(freeService);
                break;
            case 4:
                System.out.println("Enter Maximum People for new Room : ");
                int maximumPeople = Integer.parseInt(scanner.nextLine());
                editRoom.setMaxPerson(maximumPeople);
                break;
            case 5:
                System.out.println("Enter Rental Cost for new Room : ");
                double rentalCost = Double.parseDouble(scanner.nextLine());
                editRoom.setPrice(rentalCost);
                break;
        }
    }

    public static int getChoseMenuEditRoom(int choseID, Room editRoom) {
        int choseMenuEditRoom;
        System.out.println("Chose on Menu Edit Room "+choseID+": ");
        System.out.println("1\tEdit Name Service ("+editRoom.getNameService()+")");
        System.out.println("2\tEdit Area Use ("+editRoom.getArea()+")");
        System.out.println("3\tEdit free Service ("+editRoom.getFreeService()+")");
        System.out.println("4\tEdit Maximum People ("+editRoom.getMaxPerson()+")");
        System.out.println("5\tEdit Rental Cost ("+editRoom.getPrice()+")");
        System.out.println("6\tReturn main menu");
        choseMenuEditRoom = Integer.parseInt(scanner.nextLine());
        return choseMenuEditRoom;
    }

    public static void controllerFacility() {
        int select = 0;
        do {
            System.out.println("-----------------Facility Management-----------------");
            System.out.println("1. Display list facility.");
            System.out.println("2. Add new facility.");
            System.out.println("3. Edit facility.");
            System.out.println("4. Return main menu.");
            System.out.print("\nEnter your choice: ");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    System.out.println("-----------------Display list facility-----------------");
                    facilityService.displayFacility();
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("-----------------Add new facility-----------------");
                    int choiceformAdd = 0;
                    do {
                        System.out.println("Chose form facility want add: ");
                        System.out.println("1. Add new House ");
                        System.out.println("2. Add new Room ");
                        System.out.println("3. Add new Villa ");
                        System.out.println("4. Return Facility menu");
                        System.out.print("\nEnter your choice: ");
                        choiceformAdd = Integer.parseInt(scanner.nextLine());
                        switch (choiceformAdd){
                            case 1:
                                System.out.println("-----------------Add new House-----------------");
                                System.out.print("Input facility ID:");
                                String facilityIDHouse = scanner.nextLine();
                                System.out.print("Input nameService: ");
                                String nameServiceHouse = scanner.nextLine();
                                System.out.print("Type rent: ");
                                String typeRentHouse = scanner.nextLine();
                                System.out.print("Input area: ");
                                double areaHouse = Double.parseDouble(scanner.nextLine());
                                System.out.print("Input MaxPerson: ");
                                int maxPersonHouse = Integer.parseInt(scanner.nextLine());
                                System.out.print("Input rent price: ");
                                double priceHouse = Double.parseDouble(scanner.nextLine());
                                System.out.print("Input roomStandard: ");
                                String roomStandardHouse = scanner.nextLine();
                                System.out.print("Input floor in House: ");
                                int floorHouse = Integer.parseInt(scanner.nextLine());
                                FacilityController.addNewHouse(new House(facilityIDHouse, nameServiceHouse, typeRentHouse, priceHouse, areaHouse, maxPersonHouse, roomStandardHouse, floorHouse));
                                System.out.println();
                                System.out.println("Added complete!");
                                System.out.println("\n");
                                break;
                            case 2:
                                System.out.println("-----------------Add new Room-----------------");
                                System.out.print("Input facility ID:");
                                String facilityIDRoom = scanner.nextLine();
                                System.out.print("Input nameService: ");
                                String nameService = scanner.nextLine();
                                System.out.print("Type rent: ");
                                String typeRent = scanner.nextLine();
                                System.out.print("Input area: ");
                                double area = Double.parseDouble(scanner.nextLine());
                                System.out.print("Input MaxPerson: ");
                                int maxPerson = Integer.parseInt(scanner.nextLine());
                                System.out.print("Input rent price: ");
                                double price = Double.parseDouble(scanner.nextLine());
                                System.out.print("Input Free service in House: ");
                                String freeService = scanner.nextLine();
                                FacilityController.addNewRoom(new Room(facilityIDRoom, nameService, typeRent, price, area, maxPerson, freeService));
                                System.out.println();
                                System.out.println("Added complete!");
                                System.out.println("\n");
                                break;
                            case 3:
                                System.out.println("-----------------Add new Villa-----------------");
                                System.out.print("Input facility ID:");
                                String facilityIDVilla = scanner.nextLine();
                                System.out.print("Input nameService: ");
                                String nameServiceVilla = scanner.nextLine();
                                System.out.print("Type rent: ");
                                String typeRentVilla = scanner.nextLine();
                                System.out.print("Input area: ");
                                double areaVilla = Double.parseDouble(scanner.nextLine());
                                System.out.print("Input MaxPerson: ");
                                int maxPersonVilla = Integer.parseInt(scanner.nextLine());
                                System.out.print("Input rent price: ");
                                double priceVilla = Double.parseDouble(scanner.nextLine());
                                System.out.print("Input roomStandard: ");
                                String roomStandardVilla = scanner.nextLine();
                                System.out.print("Input areapool of villa: ");
                                double areaPoolVilla = Double.parseDouble(scanner.nextLine());
                                System.out.print("Input floor in Villa: ");
                                int floorVilla = Integer.parseInt(scanner.nextLine());
                                FacilityController.addNeewVilla(new Villa(facilityIDVilla, nameServiceVilla, typeRentVilla, priceVilla, areaVilla, maxPersonVilla, roomStandardVilla, areaPoolVilla, floorVilla));
                                System.out.println();
                                System.out.println("Added complete!");
                                System.out.println("\n");
                                break;
                            case 4:
                                System.out.println("\n");
                                controllerFacility();
                                break;
                        }
                    }while (choiceformAdd != 4);
                    break;
                case 3:
                    System.out.println("-----------------Edit Facility-----------------");
                    editFacilityService(facilityService);
                    break;
                case 4:
                    break;
            }
        }while (true);
    }
}
