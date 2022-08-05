package case_study.controller.person_controller;

import case_study.controller.FuramaController;
import case_study.models.person.Employee;
import case_study.service.serviceImpl.EmployeeServiceImpl;
import java.util.Scanner;

public class EmployeeController {
    private static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void employeeController() {
            try {
                FuramaController furamaController = new FuramaController();
                int select = 0;
                while (true) {
                    System.out.println("-----------------Employee Management-----------------");
                    System.out.println("1. Display list employee.");
                    System.out.println("2. Add new employee.");
                    System.out.println("3. Edit employee.");
                    System.out.println("4. Return main menu.");
                    System.out.print("\nEnter your choice: ");
                    select = Integer.parseInt(scanner.nextLine());
                    switch (select) {
                        case 1:
                            System.out.println("-----------------Display list employee-----------------");
                            employeeService.displayAll();
                            System.out.println("\n");
                            break;
                        case 2:
                            Employee employee = employeeService.addRegexEmployee();
                            employeeService.addEmployee(employee);
                            System.out.println();
                            System.out.println("Added complete!");
                            break;
                        case 3:
                            employeeService.editEmployee();
                            System.out.println("\n");
                            break;
                        case 4:
                            furamaController.furamaController();
                            break;
                    }
                }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
}
