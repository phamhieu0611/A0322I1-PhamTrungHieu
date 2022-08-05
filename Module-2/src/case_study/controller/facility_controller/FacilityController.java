package case_study.controller.facility_controller;

import case_study.action.WriteFile;
import case_study.controller.FuramaController;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.service.serviceImpl.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    private static Scanner scanner = new Scanner(System.in);
    private static FacilityServiceImpl facilityService = new FacilityServiceImpl();

    public static void controllerFacility() {
        try {
            int select = 0;
            while (true) {
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
                        while (true) {
                            System.out.println("Chose form facility want add: ");
                            System.out.println("1. Add new House ");
                            System.out.println("2. Add new Room ");
                            System.out.println("3. Add new Villa ");
                            System.out.println("4. Return Facility menu");
                            System.out.print("\nEnter your choice: ");
                            choiceformAdd = Integer.parseInt(scanner.nextLine());
                            switch (choiceformAdd) {
                                case 1:
                                    System.out.println("-----------------Add new House-----------------");
                                    House house = facilityService.addRegexHouse();
                                    WriteFile.addNewHouse(house);
                                    System.out.println();
                                    System.out.println("Added complete!");
                                    break;
                                case 2:
                                    System.out.println("-----------------Add new Room-----------------");
                                    Room room = facilityService.addRegexRoom();
                                    WriteFile.addNewRoom(room);
                                    System.out.println();
                                    System.out.println("Added complete!");
                                    break;
                                case 3:
                                    System.out.println("-----------------Add new Villa-----------------");
                                    Villa villa = facilityService.addRegexVilla();
                                    WriteFile.addNeewVilla(villa);
                                    System.out.println();
                                    System.out.println("Added complete!");
                                    break;
                                case 4:
                                    System.out.println("\n");
                                    controllerFacility();
                                    break;
                            }
                        }
                    case 3:
                        System.out.println("-----------------Display list facility maintenance-----------------");
                        int selectFacilityMaintenance = 0;
                        while (true) {
                            System.out.println("1. Display list facility maintenance ");
                            System.out.println("2. Add new facility maintenance ");
                            System.out.println("3. Return Facility menu");
                            System.out.print("\nEnter your choice: ");
                            selectFacilityMaintenance = Integer.parseInt(scanner.nextLine());
                            switch (selectFacilityMaintenance) {
                                case 1:
                                    facilityService.facilityMaintenance();
                                    break;
                                case 2:
                                    System.out.println("-----------------Add new facility maintenance-----------------");
                                    facilityService.checkFacilityMaintenance();
                                case 3:
                                    controllerFacility();
                                    break;
                            }
                        }
                    case 4:
                        FuramaController.furamaController();
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Exception " + e.toString());
        }
    }
}
