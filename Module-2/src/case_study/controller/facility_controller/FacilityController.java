package case_study.controller.facility_controller;

import case_study.action.WriteFile;
import case_study.controller.FuramaController;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.service.FacilityService;
import case_study.service.serviceImpl.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    private static Scanner scanner = new Scanner(System.in);
    private static FacilityService facilityService = new FacilityServiceImpl();


    public static void controllerFacility() {
        FacilityServiceImpl facilityServiceImpl = new FacilityServiceImpl();
        int select = 0;
        do {
            System.out.println("-----------------Facility Management-----------------");
            System.out.println("1. Display list facility.");
            System.out.println("2. Add new facility.");
            System.out.println("3. Display list facility maintenance.");
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
                                House house = facilityServiceImpl.addRegexHouse();
                                WriteFile.addNewHouse(house);
                                System.out.println();
                                System.out.println("Added complete!");
                                break;
                            case 2:
                                System.out.println("-----------------Add new Room-----------------");
                                Room room = facilityServiceImpl.addRegexRoom();
                                WriteFile.addNewRoom(room);
                                System.out.println();
                                System.out.println("Added complete!");
                                break;
                            case 3:
                                System.out.println("-----------------Add new Villa-----------------");
                                Villa villa = facilityServiceImpl.addRegexVilla();
                                WriteFile.addNeewVilla(villa);
                                System.out.println();
                                System.out.println("Added complete!");
                                break;
                            case 4:
                                System.out.println("\n");
                                controllerFacility();
                                break;
                        }
                    }while (choiceformAdd != 4);
                    break;
                case 3:
                    System.out.println("-----------------Display list facility maintenance-----------------");
                    break;
                case 4:
                    FuramaController.furamaController();
                    break;
            }
        }while (true);
    }
}
