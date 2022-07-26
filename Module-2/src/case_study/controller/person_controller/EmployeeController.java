package case_study.controller.person_controller;

import case_study.controller.FuramaController;
import case_study.models.person.Employee;
import case_study.service.EmployeeService;
import case_study.service.serviceImpl.EmployeeServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeController {
    private EmployeeService employeeService = new EmployeeServiceImpl();
    private static List<Employee> employeeList = new EmployeeServiceImpl().displayAll();
    private static Scanner scanner = new Scanner(System.in);
    public static final String FILE_EMPLOYEE_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\employee.csv";

    public void displayAllListEmployee() {
        List<Employee> employeeList = readEmployeeFile(FILE_EMPLOYEE_CSV);
        for (Employee employees : employeeList) {
            System.out.println(employees);
        }
    }
    public static List<Employee> readEmployeeFile(String filePath){
        List<Employee> employees = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Employee employee;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                int id = Integer.parseInt(temp[0]);
                int idCard = Integer.parseInt(temp[1]);
                int phoneNumber = Integer.parseInt(temp[2]);
                String name = temp[3];
                String birthDay = temp[4];
                String Gender = temp[5];
                String email = temp[6];
                String level = temp[7];
                String workLocation = temp[8];
                double salary = Double.parseDouble(temp[9]);
                employee = new Employee(id, idCard, phoneNumber, name, birthDay, Gender, email, level, workLocation, salary);
                employees.add(employee);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }return employees;
    }


    public void addNewEmployee(Employee employee) {
        try {
            FileWriter fileWriter = new FileWriter(FILE_EMPLOYEE_CSV, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            buffWrite.newLine();
            buffWrite.write(employee.getId()+","+employee.getIdCard()+","+employee.getPhoneNumber()+","+employee.getName()+","+employee.getBirthDay()+","+employee.getGender()+","+employee.getEmail()+","+employee.getLevel()+","+employee.getWorkLocation()+","+employee.getSalary());
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editEmployee(int id, Employee employee) {
        employeeService.editEmployee(id, employee);
    }

    public static void employeeController() {
        FuramaController furamaController = new FuramaController();
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
                    furamaController.furamaController();
                    break;
            }
        } while (true);
    }
}
