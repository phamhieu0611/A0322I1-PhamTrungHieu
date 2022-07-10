package case_sudy.controllers.task2.controller;

import case_sudy.controllers.task2.EmployService;
import case_sudy.controllers.task2.human.Employee;
import case_sudy.controllers.task2.service.EmployServiceImpl;

import java.util.Scanner;

import static case_sudy.controllers.task1.FuramaController.displayMainMenu;

public class EmployeeController {
    private EmployService employService = new EmployServiceImpl();
    public void displayAllEmployee(){
        for (Employee employee: employService.findAll()){
            System.out.println(employee);
        }
    }
    public void addNewEmployee(Employee employee){
        employService.addEmployee(employee);
    }
    public void removeEmployee(int id){
        employService.remove(id);
    }
    public void updateEmployee(Employee employee){
        employService.updateEmpoyee(employee);
    }
    public void findEmployee(int id){
        employService.findById(id);
    }

    public static void displayEmployee(){
        EmployeeController employeeController = new EmployeeController();
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("1. Display list employee.");
            System.out.println("2. Add new employee.");
            System.out.println("3. Edit employee.");
            System.out.println("4. Return main menu.");
            System.out.print("\nEnter your choice: ");
            select = Integer.parseInt(scanner.nextLine());

            switch (select){
                case 1:
                    employeeController.displayAllEmployee();
                    break;
                case 2:
                    System.out.println("Input ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Input name: ");
                    String name = scanner.nextLine();
                    System.out.println("Input birth day:");
                    String birthday = scanner.nextLine();
                    System.out.println("Input gender:");
                    String gender = scanner.nextLine();
                    System.out.println("Input ID card:");
                    int idCard = Integer.parseInt(scanner.nextLine());
                    System.out.println("Input phone number:");
                    int phoneNumber = Integer.parseInt(scanner.nextLine());
                    System.out.println("Input email:");
                    String email = scanner.nextLine();
                    System.out.println("Input level:");
                    String level = scanner.nextLine();
                    System.out.println("Input work location:");
                    String workLocation = scanner.nextLine();
                    System.out.println("Input salary:");
                    int salary = Integer.parseInt(scanner.nextLine());
                    employeeController.addNewEmployee(new Employee(id, name, birthday, gender, idCard, phoneNumber, email, level, workLocation, salary));
                    break;
                case 3:
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }while (true);
    }
}
