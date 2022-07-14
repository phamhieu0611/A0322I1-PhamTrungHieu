package case_sudy.controller;

import case_sudy.models.Facility;
import case_sudy.models.House;
import case_sudy.models.Room;
import case_sudy.models.Villa;
import case_sudy.service.FacilityService;
import case_sudy.service.FacilityServiceImpl;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityController {
    static Scanner scanner = new Scanner(System.in);
    static FacilityService facilityService = new FacilityServiceImpl();
    static     private Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();

    public static void displayFacility(){
        int choice;
        do {
            System.out.println("-----------------Facility Management-----------------");
            System.out.println("1. Display list facility.");
            System.out.println("2. Add new facility.");
            System.out.println("3. Edit facility.");
            System.out.println("4. Return main menu.");
            System.out.print("\nEnter your choice: ");
            choice = scanner.nextInt();
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
                        choiceformAdd = scanner.nextInt();
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
                    System.out.println("-----------------Edit facility-----------------");
                    
                    System.out.println("\n");
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
}
