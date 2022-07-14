package case_sudy.controller;

import case_sudy.service.CustomerService;
import case_sudy.models.Customer;
import case_sudy.repository.CustomerRepositoryIplm;
import case_sudy.service.CustomerServiceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private static List<Customer> customerList = new CustomerRepositoryIplm().getCustomerList();
    private CustomerService customerService = new CustomerServiceImpl();
    static Scanner scanner = new Scanner(System.in);
    static CustomerController customerController = new CustomerController();

    public void displayAllCustomer(){
        for (Customer customer : customerService.findAll()){
            System.out.println(customer);
        }
    }
    public void addNewCustomer(Customer customer){
        customerService.addCustomer(customer);
    }
    public void updateNewCustomer(int id,Customer customer){
        customerService.updateCustomer(id, customer);
    }

    public static void displayCustomer(){
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
                    customerController.addNewCustomer(new Customer(id, name, birthday, gender, idCard, phoneNumber, email, typeCustomer, address));
                    System.out.println();
                    System.out.println("Added complete!");
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("-----------------Edit Customer-----------------");
                    System.out.print("Input id Employee wanna Edit: ");
                    int idEdit = Integer.parseInt(scanner.nextLine());
                    Iterator<Customer> customerItrt = customerList.iterator();
                    while (customerItrt.hasNext()){
                        Customer customer = customerItrt.next();
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
                            customerController.updateNewCustomer(idEdit, new Customer(idNew, nameNew, birthdayNew, genderNew, idCardNew, phoneNumberNew, emailNew, typeCustomerNew, addressNew));
                            System.out.println();
                            System.out.println("Update complete!");
                        }
                    }
                    System.out.println("Your ID input not found, do it again!");
                    System.out.println("\n");
                    break;
                case 4:
                    FuramaController.displayMainMenu();
                    break;
            }
        }while (true);
    }
}
