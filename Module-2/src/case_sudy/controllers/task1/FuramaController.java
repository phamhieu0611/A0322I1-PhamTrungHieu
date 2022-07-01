package case_sudy.controllers.task1;

import java.util.Scanner;

public class FuramaController {
    static void displayMainMenu(){
        int choice;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Employee Management.");
        System.out.println("2. Customer Management.");
        System.out.println("3. Facility Management.");
        System.out.println("4. Booking Management.");
        System.out.println("5. Promotion Management.");
        System.out.println("6. Exit.");

        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    displayEmployee();
                    break;
                case 2:
                    displayCustomer();
                    break;
                case 3:
                    displayFacility();
                    break;
                case 4:
                    displayBooking();
                    break;
                case 5:
                    displayPromotion();
                    break;
                case 6:
                    System.exit(0);
            }
        }while (choice > 0 || choice < 6);
    }
    static void displayEmployee(){
        System.out.println("1. Display list employee.");
        System.out.println("2. Add new employee.");
        System.out.println("3. Edit employee.");
        System.out.println("4. Return main menu.");
        Scanner scanner = new Scanner(System.in);
        int choice;
        choice = scanner.nextInt();
        do {
            switch (choice){
                case 4:
                    displayMainMenu();
                    break;
            }
        }while (choice != 4);
    }
    static void displayCustomer(){
        System.out.println("1. Display list customer.");
        System.out.println("2. Add new customer.");
        System.out.println("3. Edit customer.");
        System.out.println("4. Return main menu.");
        Scanner scanner = new Scanner(System.in);
        int choice;
        choice = scanner.nextInt();
        do {
            switch (choice){
                case 4:
                    displayMainMenu();
                    break;
            }
        }while (choice != 4);
    }
    static void displayFacility(){
        System.out.println("1. Display list facility.");
        System.out.println("2. Add new facility.");
        System.out.println("3. Edit facility.");
        System.out.println("4. Return main menu.");
        Scanner scanner = new Scanner(System.in);
        int choice;
        choice = scanner.nextInt();
        do {
            switch (choice){
                case 4:
                    displayMainMenu();
                    break;
            }
        }while (choice != 4);

    }
    static void displayBooking(){
        System.out.println("1. Add new booking.");
        System.out.println("2. Display list booking.");
        System.out.println("3. Create new contracts.");
        System.out.println("4. Display list contracts");
        System.out.println("5. Edit contracts");
        System.out.println("6. Return main menu.");
        Scanner scanner = new Scanner(System.in);
        int choice;
        choice = scanner.nextInt();
        do {
            switch (choice){
                case 6:
                    displayMainMenu();
                    break;
            }
        }while (choice != 6);
    }
    static void displayPromotion(){
        System.out.println("1. Display list customer.");
        System.out.println("2. Display list customer.");
        System.out.println("3. Return main menu.");
        Scanner scanner = new Scanner(System.in);
        int choice;
        choice = scanner.nextInt();
        do {
            switch (choice){
                case 3:
                    displayMainMenu();
                    break;
            }
        }while (choice != 3);
    }
    public static void main(String[] args) {
        displayMainMenu();
    }
}
