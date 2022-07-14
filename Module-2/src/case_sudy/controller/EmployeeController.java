package case_sudy.controller;

import case_sudy.service.EmployService;
import case_sudy.models.Employee;
import case_sudy.repository.EmployeeRepositoryIplm;
import case_sudy.service.EmployServiceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static case_sudy.controller.FuramaController.displayMainMenu;

public class EmployeeController {
    private EmployService employService = new EmployServiceImpl();
    private static List<Employee> employeeList= new EmployeeRepositoryIplm().getEmployeeList();
    public void displayAllEmployee(){
        for (Employee employee: employService.findAll()){
            System.out.println(employee);
        }
    }
    public void addNewEmployee(Employee employee){
        employService.addEmployee(employee);
    }
    public void updateEmployee(int id, Employee employee){
        employService.updateEmpoyee(id, employee);
    }

    public static void displayEmployee(){
        EmployeeController employeeController = new EmployeeController();
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("-----------------Employee Management-----------------");
            System.out.println("1. Display list employee.");
            System.out.println("2. Add new employee.");
            System.out.println("3. Edit employee.");
            System.out.println("4. Return main menu.");
            System.out.print("\nEnter your choice: ");
            select = Integer.parseInt(scanner.nextLine());

            switch (select){
                case 1:
                    System.out.println("-----------------Display list employee-----------------");
                    employeeController.displayAllEmployee();
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
                    employeeController.addNewEmployee(new Employee(id, name, birthday, gender, idCard, phoneNumber, email, level, workLocation, salary));
                    System.out.println();
                    System.out.println("Added complete!");
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("-----------------Edit employee-----------------");
                    System.out.print("Input id Employee wanna Edit: ");
                    int idEdit = Integer.parseInt(scanner.nextLine());
                    Iterator<Employee> employeeItrt = employeeList.iterator();
                    while (employeeItrt.hasNext()){
                        Employee employee = employeeItrt.next();
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
                            employeeController.updateEmployee(idEdit, new Employee(idNew, nameNew, birthdayNew, genderNew, idCardNew, phoneNumberNew, emailNew, levelNew, workLocationNew, salaryNew));
                            System.out.println();
                            System.out.println("Update complete!");
                        }
                    }
                    System.out.println("Your ID input not found, do it again!");
                    System.out.println("\n");
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        }while (true);
    }
}
