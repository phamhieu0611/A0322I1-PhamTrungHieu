package case_study.controller.person_controller;

import case_study.controller.FuramaController;
import case_study.models.person.Customer;
import case_study.models.person.Employee;
import case_study.service.EmployeeService;
import case_study.service.serviceImpl.EmployeeServiceImpl;
import java.util.Scanner;

public class EmployeeController {
    private static EmployeeService employeeService = new EmployeeServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void employeeController() {
        EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();
        while (true){
            try {
                FuramaController furamaController = new FuramaController();
                int select = 0;
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
                                    Employee employee = employeeServiceImpl.addRegexEmployee();
                                    employeeServiceImpl.addEmployee(employee);
                                    System.out.println();
                                    System.out.println("Added complete!");
                            break;
                        case 3:
                                    editEmployee(employeeService);
                                    System.out.println("\n");
                                    break;
                        case 4:
                            furamaController.furamaController();
                            break;
                    }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }

    public static void editEmployee(EmployeeService employeeService) {
        while (true){
            try {
                int positionList = getPositionListEmployee(scanner, employeeService);
                int choseMenuEdit =-1;
                    Employee employeeEdit = employeeService.getEmployee(positionList);
                    System.out.println("Infor about employee in position "+positionList+ " is:");
                    System.out.println(employeeEdit.toString());
                    System.out.println("Chose on Menu Edit Employee  :");
                    System.out.println("1.\tChange the employee in ID "+positionList+" to the new employee");
                    System.out.println("2.\tChange properties in ID "+positionList);
                    System.out.println("3.\tReturn Employee menu");
                    choseMenuEdit = Integer.parseInt(scanner.nextLine());;
                    switch (choseMenuEdit){
                        case 1:
                            Employee newEmployee = enterNewEmployee();
                            employeeService.editEmployee(positionList,newEmployee);
                            break;
                        case 2:
                            int choseMenuEditAfter = -1;
                            do{
                                choseMenuEditAfter = getChoseMenuEditEmployee(positionList, employeeEdit);
                                chosePropertiesEditEmployee(employeeEdit, choseMenuEditAfter);
                            }while (choseMenuEditAfter != 11);
                            break;
                    }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }

    public static int getPositionListEmployee(Scanner scanner, EmployeeService employeeService) {
        while (true){
            try {
                int positionList = -1;
                    employeeService.employeeShow();
                    System.out.println("Enter ID for Employee want Edit: ");
                    positionList = Integer.parseInt(scanner.nextLine());
                return positionList;
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }

    public static Employee enterNewEmployee() {
        while (true){
            try {
                System.out.print("Input new ID: ");
                int idNew = Integer.parseInt(scanner.nextLine());
                System.out.print("Input new ID card:");
                int idCardNew = Integer.parseInt(scanner.nextLine());
                System.out.print("Input new name: ");
                String nameNew = scanner.nextLine();
                System.out.print("Input new birth day:");
                String birthdayNew = scanner.nextLine();
                System.out.print("Input new gender:");
                String genderNew = scanner.nextLine();
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
                return new Employee(idNew, idCardNew, phoneNumberNew, nameNew, birthdayNew, genderNew, emailNew, levelNew, workLocationNew, salaryNew);
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }

    public static int getChoseMenuEditEmployee(int poisitionArrayList, Employee employeeEdit) {
        while (true){
            try {
                int choseMenuEdit;
                System.out.println("Chose on Menu Edit Employee "+poisitionArrayList+": ");
                System.out.println("1\tEdit id ("+employeeEdit.getId()+")");
                System.out.println("2\tEdit id card ("+employeeEdit.getIdCard()+")");
                System.out.println("3\tEdit phone number ("+employeeEdit.getPhoneNumber()+")");
                System.out.println("4\tEdit name ("+employeeEdit.getName()+")");
                System.out.println("5\tEdit birth day ("+employeeEdit.getBirthDay()+")");
                System.out.println("6\tEdit gender ("+employeeEdit.getGender()+")");
                System.out.println("7\tEdit email ("+employeeEdit.getEmail()+")");
                System.out.println("8\tEdit level ("+employeeEdit.getLevel()+")");
                System.out.println("9\tEdit work location ("+employeeEdit.getWorkLocation()+")");
                System.out.println("10\tEdit salary ("+employeeEdit.getSalary()+")");
                System.out.println("11\tReturn main menu");
                choseMenuEdit = Integer.parseInt(scanner.nextLine());
                return choseMenuEdit;
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }

    public static void chosePropertiesEditEmployee(Employee employeeEdit, int choseMenuEdit) {
        while (true){
            try {
                switch (choseMenuEdit){
                    case 1:System.out.println("Enter id for new Employee: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        employeeEdit.setId(id);
                        break;
                    case 2:
                        System.out.println("Enter id card for new Employee : ");
                        int idCard = Integer.parseInt(scanner.nextLine());
                        employeeEdit.setId(idCard);
                        break;
                    case 3:
                        System.out.println("Enter Sphone number for new Employee : ");
                        int phoneNumber = Integer.parseInt(scanner.nextLine());
                        employeeEdit.setPhoneNumber(phoneNumber);
                        break;
                    case 4:
                        System.out.println("Enter name for new Employee: ");
                        String name = scanner.nextLine();
                        employeeEdit.setName(name);
                        break;
                    case 5:
                        System.out.println("Enter birth day for new Employee: ");
                        String birthDay = scanner.nextLine();
                        employeeEdit.setBirthDay(birthDay);
                        break;
                    case 6:
                        System.out.println("Enter gender for new Employee: ");
                        String gender = scanner.nextLine();
                        employeeEdit.setGender(gender);
                        break;
                    case 7:
                        System.out.println("Enter email for new Employee : ");
                        String email = scanner.nextLine();
                        employeeEdit.setEmail(email);
                        break;
                    case 8:
                        System.out.println("Enter level for new Employee : ");
                        String level = scanner.nextLine();
                        employeeEdit.setLevel(level);
                        break;
                    case 9:
                        System.out.println("Enter work location for new Employee : ");
                        String position = scanner.nextLine();
                        employeeEdit.setWorkLocation(position);
                        break;
                    case 10:
                        System.out.println("Enter salary for new Employee : ");
                        double salary = Double.parseDouble(scanner.nextLine());
                        employeeEdit.setSalary(salary);
                        break;
                }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }
}
