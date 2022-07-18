package newCaseStudy.controller;

import newCaseStudy.controller.mainController.FuramaController;
import newCaseStudy.model.person.Customer;
import newCaseStudy.reponsitory.reponsitoryImpl.CustomerReponsitoryImpl;
import newCaseStudy.service.CustomerService;
import newCaseStudy.service.serviceImpl.CustomerServiceImpl;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CustomerController {
    private static List<Customer> customerList = new CustomerReponsitoryImpl().displayAll();
    private CustomerService customerService = new CustomerServiceImpl();
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerController customerController = new CustomerController();

    public void displayAllCustomer(){
        for (Customer customer : customerService.displayAll()){
            System.out.println(customer);
        }
    }

    public void addNewCustomer(Customer customer){
        customerService.addCustomer(customer);
    }

    public void editCustomer(int id, Customer customer){
        customerService.editCustomer(id, customer);
    }

    public static void controllerCustomer(){
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
                    System.out.println("\n");
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
                    break;
            }
        }while (true);
    }
}
