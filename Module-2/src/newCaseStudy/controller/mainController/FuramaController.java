package newCaseStudy.controller.mainController;

import newCaseStudy.controller.CustomerController;
import newCaseStudy.controller.EmployeeController;
import newCaseStudy.controller.FacilityController;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
            int select = 0;
            System.out.println("--------------------------Menu--------------------------");
            System.out.println("1. Employee Management.");
            System.out.println("2. Customer Management.");
            System.out.println("3. Facility Management.");
            System.out.println("4. Booking Management.");
            System.out.println("5. Promotion Management.");
            System.out.println("6. Exit.");
            do {
                System.out.println("Enter your choice: ");
                select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1:
                        EmployeeController.employeeController();
                        break;
                    case 2:
                        CustomerController.controllerCustomer();
                        break;
                    case 3:
                        FacilityController.controllerFacility();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        System.exit(0);
                }
            }while (select > 0 || select <6);
    }
}
