package case_sudy.controller;

import case_sudy.controller.mainController.FuramaController;
import case_sudy.models.facility.Facility;
import case_sudy.models.facility.House;
import case_sudy.models.facility.Room;
import case_sudy.models.facility.Villa;
import case_sudy.service.FacilityService;
import case_sudy.service.serviceImpl.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    static Scanner scanner = new Scanner(System.in);
    static FacilityService facilityService = new FacilityServiceImpl();
    public static void displayFacility(){
        int choice;
        do {
            System.out.println("-----------------Facility Management-----------------");
            System.out.println("1. Display list facility.");
            System.out.println("2. Add new facility.");
            System.out.println("3. Edit facility.");
            System.out.println("4. Return main menu.");
            System.out.print("\nEnter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
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
                                FacilityController.addHouseFacility();
                                System.out.println("\n");
                                break;
                            case 2:
                                System.out.println("-----------------Add new Room-----------------");
                                FacilityController.addRoomFacility();
                                System.out.println("\n");

                                break;
                            case 3:
                                System.out.println("-----------------Add new Villa-----------------");
                                FacilityController.addVillaFacility();
                                System.out.println("\n");
                                break;
                            case 4:
                                System.out.println("\n");
                                displayFacility();
                                break;
                        }
                    }while (choiceformAdd != 4);
                    break;
                case 3:
                    editFacilityService(facilityService);
                    break;
                case 4:
                    FuramaController.displayMainMenu();
                    System.out.println("\n");
                    break;
            }
        }while (true);

    }
    private static void addHouseFacility() {
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
        System.out.print("Input roomStandard: ");
        String roomStandard = scanner.nextLine();
        System.out.print("Input price per house: ");
        double pricePerHouse = Double.parseDouble(scanner.nextLine());
        System.out.print("Input floor in House: ");
        int floor = Integer.parseInt(scanner.nextLine());
        facilityService.addFacility(new House(nameService, typeRent, area, maxPerson, price, roomStandard, pricePerHouse, floor));
        System.out.println();
        System.out.println("Added complete!");
        System.out.println("\n");
    }

    private static void addRoomFacility() {
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
        System.out.print("Input price per room: ");
        double pricePerRoom = Double.parseDouble(scanner.nextLine());
        System.out.print("Input Free service in House: ");
        String freeService = scanner.nextLine();
        facilityService.addFacility(new Room(nameService, typeRent, area, maxPerson, price, pricePerRoom, freeService));
        System.out.println();
        System.out.println("Added complete!");
        System.out.println("\n");
    }

    private static void addVillaFacility() {
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
        System.out.print("Input roomStandard: ");
        String roomStandard = scanner.nextLine();
        System.out.print("Input areapool of villa: ");
        double areaPool = Double.parseDouble(scanner.nextLine());
        System.out.print("Input floor in Villa: ");
        int floor = Integer.parseInt(scanner.nextLine());
        System.out.print("Input price per Villa: ");
        double pricePerHouse = Double.parseDouble(scanner.nextLine());
        facilityService.addFacility(new Villa(nameService, typeRent, area, maxPerson, price, roomStandard, areaPool, floor, pricePerHouse));
        System.out.println();
        System.out.println("Added complete!");
        System.out.println("\n");
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

//    public static void editFacility(FacilityService facilityService){
//        facilityService.displayFacility();
//        int choiceID = getChoiceID(facilityService);
//        Facility facility = facilityService.getFacility(choiceID);
//        if (facility instanceof House){
//            House houseEdit = (House) facility;
//            houseEdit(houseEdit);
//        }else if(facility instanceof Room){
//            Room roomEdit = (Room) facility;
//            roomEdit(roomEdit);
//        }else if(facility instanceof Villa){
//            Villa villaEdit = (Villa) facility;
//            villaEdit(villaEdit);
//        }
//    }
//    public static void houseEdit(House houseEdit){
//        System.out.println("\n");
//        System.out.print("Input nameService: ");
//        String nameServiceNew = scanner.nextLine();
//        houseEdit.setNameService(nameServiceNew);
//        System.out.print("Type rent: ");
//        String typeRentNew = scanner.nextLine();
//        houseEdit.setTypeRent(typeRentNew);
//        System.out.print("Input area: ");
//        double areaNew = Double.parseDouble(scanner.nextLine());
//        houseEdit.setArea(areaNew);
//        System.out.print("Input new MaxPerson: ");
//        int maxPersonNew = Integer.parseInt(scanner.nextLine());
//        houseEdit.setMaxPerson(maxPersonNew);
//        System.out.print("Input new rent price: ");
//        double priceNew = Double.parseDouble(scanner.nextLine());
//        houseEdit.setPrice(priceNew);
//        System.out.print("Input new roomStandard: ");
//        String roomStandardNew = scanner.nextLine();
//        houseEdit.setRoomStandard(roomStandardNew);
//        System.out.print("Input new price per house: ");
//        double pricePerHouseNew = Double.parseDouble(scanner.nextLine());
//        houseEdit.setPricePerHouse(pricePerHouseNew);
//        System.out.print("Input new floor in House: ");
//        int floorNew = Integer.parseInt(scanner.nextLine());
//        houseEdit.setFloor(floorNew);
//        System.out.println();
//        System.out.println("Edited complete!");
//        System.out.println("\n");
//    }
//    public static void roomEdit(Room roomEdit){
//        System.out.println("\n");
//        System.out.print("Input new nameService: ");
//        String nameServiceNew = scanner.nextLine();
//        roomEdit.setNameService(nameServiceNew);
//        System.out.print("Input new type rent: ");
//        String typeRentNew = scanner.nextLine();
//        roomEdit.setTypeRent(typeRentNew);
//        System.out.print("Input new area: ");
//        double areaNew = Double.parseDouble(scanner.nextLine());
//        roomEdit.setArea(areaNew);
//        System.out.print("Input new MaxPerson: ");
//        int maxPersonNew = Integer.parseInt(scanner.nextLine());
//        roomEdit.setMaxPerson(maxPersonNew);
//        System.out.print("Input new rent price: ");
//        double priceNew = Double.parseDouble(scanner.nextLine());
//        roomEdit.setPrice(priceNew);
//        System.out.print("Input new price per room: ");
//        double pricePerRoomNew = Double.parseDouble(scanner.nextLine());
//        roomEdit.setPriceFerRoom(pricePerRoomNew);
//        System.out.print("Input new Free service in House: ");
//        String freeServiceNew = scanner.nextLine();
//        roomEdit.setFreeService(freeServiceNew);
//        System.out.println();
//        System.out.println("Edited complete!");
//        System.out.println("\n");
//    }
//    public static void villaEdit(Villa villaEdit){
//        System.out.println("\n");
//        System.out.print("Input new nameService: ");
//        String nameServiceNew = scanner.nextLine();
//        villaEdit.setNameService(nameServiceNew);
//        System.out.print("Input new type rent: ");
//        String typeRentNew = scanner.nextLine();
//        villaEdit.setTypeRent(typeRentNew);
//        System.out.print("Input new area: ");
//        double areaNew = Double.parseDouble(scanner.nextLine());
//        villaEdit.setArea(areaNew);
//        System.out.print("Input new MaxPerson: ");
//        int maxPersonNew = Integer.parseInt(scanner.nextLine());
//        villaEdit.setMaxPerson(maxPersonNew);
//        System.out.print("Input new rent price: ");
//        double priceNew = Double.parseDouble(scanner.nextLine());
//        villaEdit.setPrice(priceNew);
//        System.out.print("Input new roomStandard: ");
//        String roomStandardNew = scanner.nextLine();
//        villaEdit.setRoomStandard(roomStandardNew);
//        System.out.print("Input new areapool of villa: ");
//        double areaPoolNew = Double.parseDouble(scanner.nextLine());
//        villaEdit.setAreaPool(areaPoolNew);
//        System.out.print("Input new floor in Villa: ");
//        int floorNew = Integer.parseInt(scanner.nextLine());
//        villaEdit.setFloor(floorNew);
//        System.out.print("Input new price per Villa: ");
//        double pricePerVillaNew = Double.parseDouble(scanner.nextLine());
//        villaEdit.setPricePerVilla(pricePerVillaNew);
//        System.out.println();
//        System.out.println("Edited complete!");
//        System.out.println("\n");
//    }


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
            House houseEdit = (House) facility;
            int choseMenuEditHouse = 0;
            do{
                choseMenuEditHouse = getChoseMenuEditHouse(choseID, houseEdit);
                chosePropertiesEditHouse(houseEdit, choseMenuEditHouse);
            }while (choseMenuEditHouse != 7);
        }else if(facility instanceof Room){
            Room roomEdit = (Room) facility;
            int choseMenuEditRoom = 0;
            do{
                choseMenuEditRoom = getChoseMenuEditRoom(choseID, roomEdit);
                chosePropertiesEditRoom(roomEdit, choseMenuEditRoom);
            }while (choseMenuEditRoom != 6);
        }else if(facility instanceof Villa){
            Villa villaEdit = (Villa) facility;
            int choseMenuEditVilla = 0;
            do{
                choseMenuEditVilla = getChoseMenuEditVilla(choseID, villaEdit);
                chosePropertiesEditVilla(villaEdit, choseMenuEditVilla);
            }while (choseMenuEditVilla != 8);
        }
    }
    public static int getChoseMenuEditHouse(int choseID, House houseEdit) {
        int choseMenuEditHouse;
        System.out.println("Chose on Menu Edit House "+choseID+": ");
        System.out.println("1\tEdit Name Service ("+houseEdit.getNameService()+")");
        System.out.println("2\tEdit Area Use ("+houseEdit.getArea()+")");
        System.out.println("3\tEdit floors ("+houseEdit.getFloor()+")");
        System.out.println("4\tEdit Maximum People ("+houseEdit.getMaxPerson()+")");
        System.out.println("5\tEdit Standard Room ("+houseEdit.getRoomStandard()+")");
        System.out.println("6\tEdit Rental Cost ("+houseEdit.getPrice()+")");
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
    public static void chosePropertiesEditVilla(Villa villaEdit, int choseMenuEditVilla) {
        switch (choseMenuEditVilla){
            case 1:
                System.out.println("Enter Name Service for new Villa: ");
                String nameService = scanner.nextLine();
                villaEdit.setNameService(nameService);
                break;
            case 2:
                System.out.println("Enter Area Use for new Villa: ");
                double areaUse = Double.parseDouble(scanner.nextLine());
                villaEdit.setArea(areaUse);
                break;
            case 3:
                System.out.println("Enter floors for new Villa: ");
                int floors =Integer.parseInt(scanner.nextLine());
                villaEdit.setFloor(floors);
                break;
            case 4:
                System.out.println("Enter Maximum People for new Villa : ");
                int maximumPeople = Integer.parseInt(scanner.nextLine());
                villaEdit.setMaxPerson(maximumPeople);
                break;
            case 5:
                System.out.println("Enter Standard Room for new Villa: ");
                String sRoom = scanner.nextLine();
                villaEdit.setRoomStandard(sRoom);
                break;
            case 6:
                System.out.println("Enter Rental Cost for new Villa : ");
                double rentalCost = Double.parseDouble(scanner.nextLine());
                villaEdit.setPrice(rentalCost);
                break;
            case 7:
                System.out.println("Enter pool Area for new Villa : ");
                double poolArea = Double.parseDouble(scanner.nextLine());
                villaEdit.setAreaPool(poolArea);
                break;
        }
    }

    public static int getChoseMenuEditVilla(int choseID, Villa villaEdit) {
        int choseMenuEditVilla;
        System.out.println("Chose on Menu Edit Villa "+choseID+": ");
        System.out.println("1\tEdit Name Service ("+villaEdit.getNameService()+")");
        System.out.println("2\tEdit Area Use ("+villaEdit.getArea()+")");
        System.out.println("3\tEdit floors ("+villaEdit.getFloor()+")");
        System.out.println("4\tEdit Maximum People ("+villaEdit.getMaxPerson()+")");
        System.out.println("5\tEdit Standard Room ("+villaEdit.getRoomStandard()+")");
        System.out.println("6\tEdit Rental Cost ("+villaEdit.getPrice()+")");
        System.out.println("7\tEdit Pool Area ("+villaEdit.getAreaPool()+")");
        System.out.println("8\tReturn main menu");
        choseMenuEditVilla = Integer.parseInt(scanner.nextLine());
        return choseMenuEditVilla;
    }

    public static void chosePropertiesEditRoom(Room roomEdit, int choseMenuEditRoom) {
        switch (choseMenuEditRoom){
            case 1:
                System.out.println("Enter Name Service for new Room: ");
                String nameService = scanner.nextLine();
                roomEdit.setNameService(nameService);
                break;
            case 2:
                System.out.println("Enter Area Use for new Room: ");
                double areaUse = Double.parseDouble(scanner.nextLine());
                roomEdit.setArea(areaUse);
                break;
            case 3:
                System.out.println("Enter Free Service for new Room: ");
                String freeService = scanner.nextLine();
                roomEdit.setFreeService(freeService);
                break;
            case 4:
                System.out.println("Enter Maximum People for new Room : ");
                int maximumPeople = Integer.parseInt(scanner.nextLine());
                roomEdit.setMaxPerson(maximumPeople);
                break;
            case 5:
                System.out.println("Enter Rental Cost for new Room : ");
                double rentalCost = Double.parseDouble(scanner.nextLine());
                roomEdit.setPrice(rentalCost);
                break;
        }
    }

    public static int getChoseMenuEditRoom(int choseID, Room roomEdit) {
        int choseMenuEditRoom;
        System.out.println("Chose on Menu Edit Room "+choseID+": ");
        System.out.println("1\tEdit Name Service ("+roomEdit.getNameService()+")");
        System.out.println("2\tEdit Area Use ("+roomEdit.getArea()+")");
        System.out.println("3\tEdit free Service ("+roomEdit.getFreeService()+")");
        System.out.println("4\tEdit Maximum People ("+roomEdit.getMaxPerson()+")");
        System.out.println("5\tEdit Rental Cost ("+roomEdit.getPrice()+")");
        System.out.println("6\tReturn main menu");
        choseMenuEditRoom = Integer.parseInt(scanner.nextLine());
        return choseMenuEditRoom;
    }
}
