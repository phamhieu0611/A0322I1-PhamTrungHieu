package case_study.controller.person_controller;

import case_study.controller.FuramaController;
import case_study.models.person.Customer;
import case_study.service.CustomerService;
import case_study.service.serviceImpl.CustomerServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private static List<Customer> customerList = new CustomerServiceImpl().displayAll();
    private CustomerService customerService = new CustomerServiceImpl();
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerController customerController = new CustomerController();
    public static final String FILE_CUSTOMER_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\case_study\\data\\customer.csv";

    public void displayAllCustomer(){
        List<Customer> customerList = readCustomerFile(FILE_CUSTOMER_CSV);
        for (Customer customers : customerList){
            System.out.println(customers);
        }
    }

    public static List<Customer> readCustomerFile(String filePath){
        List<Customer> customers = new ArrayList<>();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            String temp[];
            Customer customer;
            while ((line = bufferedReader.readLine()) != null){
                temp = line.split(",");
                int id = Integer.parseInt(temp[0]);
                int idCard = Integer.parseInt(temp[1]);
                int phoneNumber = Integer.parseInt(temp[2]);
                String name = temp[3];
                String birthDay = temp[4];
                String Gender = temp[5];
                String email = temp[6];
                String typeCustomer = temp[7];
                String address = temp[8];
                customer = new Customer(id, idCard, phoneNumber, name, birthDay, Gender, email, typeCustomer, address);
                customers.add(customer);
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
        }return customers;
    }


    public void addNewCustomer(Customer customer){
        try {
            FileWriter fileWriter = new FileWriter(FILE_CUSTOMER_CSV, true);
            BufferedWriter buffWrite = new BufferedWriter(fileWriter);
            buffWrite.newLine();
            buffWrite.write(customer.getId()+","+customer.getIdCard()+","+customer.getPhoneNumber()+","+customer.getName()+","+customer.getBirthDay()+","+customer.getGender()+","+customer.getEmail()+","+customer.getTypeCustomer()+","+customer.getAddress());
            buffWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editCustomer(int id, Customer customer){
        customerService.editCustomer(id, customer);
    }

    public static void controllerCustomer(){
        FuramaController furamaController = new FuramaController();
        int select = 0;
        do {
            System.out.println("-----------------Customer Management-----------------");
            System.out.println("1. Display list customer.");
            System.out.println("2. Add new customer.");
            System.out.println("3. Edit customer.");
            System.out.println("4. Return main menu.");
            System.out.print("\nEnter your choice: ");
            select = Integer.parseInt(scanner.nextLine());

            switch (select){
                case 1:
                    System.out.println("-----------------Display list customer-----------------");
                    customerController.displayAllCustomer();
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
                    System.out.print("Input type customer:");
                    String typeCustomer = scanner.nextLine();
                    System.out.print("Input address:");
                    String address = scanner.nextLine();
                    customerController.addNewCustomer(new Customer(id, idCard, phoneNumber, name, birthday, gender, email, typeCustomer, address));
                    System.out.println();
                    System.out.println("Added complete!");
                    break;
                case 3:
                    System.out.println("-----------------Edit Customer-----------------");
                    System.out.print("Input id Employee wanna Edit: ");
                    int idEdit = Integer.parseInt(scanner.nextLine());
                    Iterator<Customer> customerIterator = customerList.iterator();
                    while (customerIterator.hasNext()){
                        Customer customer = customerIterator.next();
                        if (customer.getId() == idEdit){
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
                            System.out.print("Input new type customer:");
                            String typeCustomerNew = scanner.nextLine();
                            System.out.print("Input new address:");
                            String addressNew = scanner.nextLine();
                            customerController.editCustomer(idEdit, new Customer(idNew, idCardNew, phoneNumberNew, nameNew, birthdayNew, genderNew, emailNew, typeCustomerNew, addressNew));
                            System.out.println();
                            System.out.println("Update complete!");
                        }
                    }System.out.println("Your ID input not found, do it again!");
                    System.out.println("\n");
                    break;
                case 4:
                    furamaController.furamaController();
                    break;
            }
        }while (true);
    }
}
