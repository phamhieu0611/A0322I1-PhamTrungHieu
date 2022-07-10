package case_sudy.controllers.task2.controller;

import case_sudy.controllers.task2.CustomerService;
import case_sudy.controllers.task2.human.Customer;
import case_sudy.controllers.task2.service.CustomerServiceImpl;

import java.util.Scanner;

import static case_sudy.controllers.task1.FuramaController.displayMainMenu;

public class CustomerController {
    private CustomerService customerService = new CustomerServiceImpl();
    public void displayAllCustomer(){
        for (Customer customer : customerService.findAll()){
            System.out.println(customer);
        }
    }
    public void addNewCustomer(Customer customer){
        customerService.addCustomer(customer);
    }
    public void updateNewCustomer(Customer customer){
        customerService.updateCustomer(customer);
    }
    public void removeCustomer(int id){
        customerService.remove(id);
    }
    public void findById(int id){
        customerService.findById(id);
    }

    public static void displayCustomer(){
        CustomerController customerController = new CustomerController();
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("1. Display list customer.");
            System.out.println("2. Add new customer.");
            System.out.println("3. Edit customer.");
            System.out.println("4. Return main menu.");
            System.out.print("\nEnter your choice: ");
            select = Integer.parseInt(scanner.nextLine());

            switch (select){
                case 1:
                    customerController.displayAllCustomer();
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
                    System.out.println("Input type customer:");
                    String typeCustomer = scanner.nextLine();
                    System.out.println("Input address:");
                    String address = scanner.nextLine();
                    customerController.addNewCustomer(new Customer(id, name, birthday, gender, idCard, phoneNumber, email, typeCustomer, address));
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
