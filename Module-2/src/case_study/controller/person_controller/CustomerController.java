package case_study.controller.person_controller;

import case_study.controller.FuramaController;
import case_study.models.person.Customer;
import case_study.service.CustomerService;
import case_study.service.serviceImpl.CustomerServiceImpl;


import java.util.Scanner;

public class CustomerController {
    private static CustomerService customerService = new CustomerServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void controllerCustomer(){
        CustomerServiceImpl customerServiceImpl=new CustomerServiceImpl();
            try {
                FuramaController furamaController = new FuramaController();
                int select = 0;
                while (true){
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
                            customerService.displayAll();
                            break;
                        case 2:
                            System.out.println("-----------------Add new customer-----------------");
                            Customer customer = customerServiceImpl.addRegexCustomer();

                            customerServiceImpl.addCustomer(customer);
                            System.out.println();
                            System.out.println("Added complete!");
                            break;
                        case 3:
                            customerServiceImpl.editCustomer();
                            System.out.println();
                            System.out.println("Update complete!");
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
