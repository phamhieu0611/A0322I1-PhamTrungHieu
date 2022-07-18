package newCaseStudy.controller;

import newCaseStudy.controller.mainController.FuramaController;
import newCaseStudy.model.person.Employee;
import newCaseStudy.reponsitory.reponsitoryImpl.EmployeeReponsitoryImpl;
import newCaseStudy.service.EmployeeService;
import newCaseStudy.service.serviceImpl.EmployeeServiceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static case_sudy.controller.mainController.FuramaController.displayMainMenu;

public class EmployeeController {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private static List<Employee> employeeList = new EmployeeReponsitoryImpl().displayAll();
    private static Scanner scanner = new Scanner(System.in);

    public void displayAllListEmployee() {
        for (Employee employee : employeeService.displayAll()) {
            System.out.println(employee);
        }
    }

    public void addNewEmployee(Employee employee) {
        employeeService.addEmployee(employee);
    }

    public void editEmployee(int id, Employee employee) {
        employeeService.editEmployee(id, employee);
    }

    public static void employeeController() {
        EmployeeController employeeController = new EmployeeController();
        int select = 0;
        do {
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
                    employeeController.displayAllListEmployee();
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("-----------------Add new employee-----------------");
                    System.out.print("Input ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Input name: ");
                    String name = scanner.nextLine();
                    System.out.print("Input birth day:");
                    String birthday = scanner.nextLine();
                    System.out.print("Input gender:");
                    String gender = scanner.nextLine();
                    System.out.print("Input ID card:");
                    int idCard = Integer.parseInt(scanner.nextLine());
                    System.out.print("Input phone number:");
                    int phoneNumber = Integer.parseInt(scanner.nextLine());
                    System.out.print("Input email:");
                    String email = scanner.nextLine();
                    System.out.print("Input level:");
                    String level = scanner.nextLine();
                    System.out.print("Input work location:");
                    String workLocation = scanner.nextLine();
                    System.out.print("Input salary:");
                    double salary = Double.parseDouble(scanner.nextLine());
                    employeeController.addNewEmployee(new Employee(id, idCard, phoneNumber, name,birthday,gender,email,level,workLocation,salary));
                    System.out.println();
                    System.out.println("Added complete!");
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("-----------------Edit employee-----------------");
                    System.out.print("Input id Employee wanna Edit: ");
                    int idEdit = Integer.parseInt(scanner.nextLine());
                    Iterator<Employee> employeeIterator = employeeList.iterator();
                    while (employeeIterator.hasNext()){
                        Employee employee = employeeIterator.next();
                        if (employee.getId() == idEdit){
                            System.out.print("Input new ID: ");
                            int idNew = Integer.parseInt(scanner.nextLine());
                            System.out.print("Input new name: ");
                            String nameNew = scanner.nextLine();
                            System.out.print("Input new birth day:");
                            String birthdayNew = scanner.nextLine();
                            System.out.print("Input new gender:");
                            String genderNew = scanner.nextLine();
                            System.out.print("Input new ID card:");
                            int idCardNew = Integer.parseInt(scanner.nextLine());
                            System.out.print("Input new phone number:");
                            int phoneNumberNew = Integer.parseInt(scanner.nextLine());
                            System.out.print("Input new email:");
                            String emailNew = scanner.nextLine();
                            System.out.print("Input new level:");
                            String levelNew = scanner.nextLine();
                            System.out.print("Input new work location:");
                            String workLocationNew = scanner.nextLine();
                            System.out.print("Input new salary:");
                            double salaryNew = Double.parseDouble(scanner.nextLine());
                            employeeController.editEmployee(idEdit, new Employee(idNew, idCardNew, phoneNumberNew, nameNew, birthdayNew, genderNew, emailNew, levelNew, workLocationNew, salaryNew));
                        }
                    } System.out.println("Your ID input not found, do it again!");
                    System.out.println("\n");
                    break;
                case 4:

                    break;
            }
        } while (true);
    }
}
