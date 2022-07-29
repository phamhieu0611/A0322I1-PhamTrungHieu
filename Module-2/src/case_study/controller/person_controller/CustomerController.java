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
        while (true){
            try {
                FuramaController furamaController = new FuramaController();
                int select = 0;
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
                            System.out.println("\n");
                            break;
                        case 2:
                            System.out.println("-----------------Add new customer-----------------");
                            Customer customer = customerServiceImpl.addRegexCustomer();
                            customerServiceImpl.addCustomer(customer);
                            System.out.println();
                            System.out.println("Added complete!");
                            break;
                        case 3:
                            editCustomer(customerService);
                            System.out.println();
                            System.out.println("Update complete!");
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

    public static void editCustomer(CustomerService customerService) {
        while (true){
            try {
                int positionList = getPositionListCustomer(scanner, customerService);
                int choseMenuEdit =-1;
                    Customer customerEdit = customerService.getCustomer(positionList);
                    System.out.println("Infor about customer in position "+positionList+ " is:");
                    System.out.println(customerEdit.toString());
                    System.out.println("Chose on Menu Edit Customer  :");
                    System.out.println("1.\tChange the Customer in ID "+positionList+" to the new employee");
                    System.out.println("2.\tChange properties in ID "+positionList);
                    System.out.println("3.\tReturn Customer menu");
                    choseMenuEdit = Integer.parseInt(scanner.nextLine());
                    switch (choseMenuEdit){
                        case 1:
                            Customer newCustomer = enterNewCustomer();
                            customerService.editCustomer(positionList,newCustomer);
                            break;
                        case 2:
                            int choseMenuEditAfter = -1;
                            do{
                                choseMenuEditAfter = getChoseMenuEditCustomer(positionList, customerEdit);
                                chosePropertiesEditCustomer(customerEdit, choseMenuEditAfter);
                            }while (choseMenuEditAfter != 10);
                    }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }

    public static int getPositionListCustomer(Scanner scanner, CustomerService customerService) {
        while (true){
            try {
                int positionList = -1;
                    customerService.customerShow();
                    System.out.println("Enter ID for Customer want Edit: ");
                    positionList = Integer.parseInt(scanner.nextLine());
                return positionList;
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }

    public static Customer enterNewCustomer() {
        while (true){
            try {
                System.out.print("Input new ID: ");
                int idNew = Integer.parseInt(scanner.nextLine());
                System.out.print("Input new ID card:");
                int idCardNew = Integer.parseInt(scanner.nextLine());
                System.out.print("Input new phone number:");
                int phoneNumberNew = Integer.parseInt(scanner.nextLine());
                System.out.print("Input new name: ");
                String nameNew = scanner.nextLine();
                System.out.print("Input new birth day:");
                String birthdayNew = scanner.nextLine();
                System.out.print("Input new gender:");
                String genderNew = scanner.nextLine();
                System.out.print("Input new email:");
                String emailNew = scanner.nextLine();
                System.out.print("Input type customer:");
                String typeCustomer = scanner.nextLine();
                System.out.print("Input address:");
                String address = scanner.nextLine();
                return new Customer(idNew,idCardNew,phoneNumberNew,nameNew,birthdayNew,genderNew,emailNew,typeCustomer,address);
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }

    public static int getChoseMenuEditCustomer(int poisitionArrayList, Customer customerEdit) {
        while (true){
            try {
                int choseMenuEdit;
                System.out.println("Chose on Menu Edit Customer "+poisitionArrayList+": ");
                System.out.println("1\tEdit id ("+customerEdit.getId()+")");
                System.out.println("2\tEdit id card ("+customerEdit.getIdCard()+")");
                System.out.println("3\tEdit phone number ("+customerEdit.getPhoneNumber()+")");
                System.out.println("4\tEdit name ("+customerEdit.getName()+")");
                System.out.println("5\tEdit birth day ("+customerEdit.getBirthDay()+")");
                System.out.println("6\tEdit gender ("+customerEdit.getGender()+")");
                System.out.println("7\tEdit email ("+customerEdit.getEmail()+")");
                System.out.println("8\tEdit type of guest ("+customerEdit.getTypeCustomer()+")");
                System.out.println("9\tEdit address ("+customerEdit.getAddress()+")");
                System.out.println("10\tReturn main menu");
                choseMenuEdit = Integer.parseInt(scanner.nextLine());
                return choseMenuEdit;
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }

    public static void chosePropertiesEditCustomer(Customer customerEdit, int choseMenuEdit) {
        while (true){
            try {
                switch (choseMenuEdit){
                    case 1:System.out.println("Enter id for new customer: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        customerEdit.setId(id);
                        break;
                    case 2:
                        System.out.println("Enter id card for new customer : ");
                        int idCard = Integer.parseInt(scanner.nextLine());
                        customerEdit.setId(idCard);
                        break;
                    case 3:
                        System.out.println("Enter phone number for new customer : ");
                        int phoneNumber = Integer.parseInt(scanner.nextLine());
                        customerEdit.setPhoneNumber(phoneNumber);
                        break;
                    case 4:
                        System.out.println("Enter name for new customer: ");
                        String name = scanner.nextLine();
                        customerEdit.setName(name);
                        break;
                    case 5:
                        System.out.println("Enter birth day for new customer: ");
                        String birthDay = scanner.nextLine();
                        customerEdit.setBirthDay(birthDay);
                        break;
                    case 6:
                        System.out.println("Enter gender for new customer: ");
                        String gender = scanner.nextLine();
                        customerEdit.setGender(gender);
                        break;
                    case 7:
                        System.out.println("Enter email for new customer : ");
                        String email = scanner.nextLine();
                        customerEdit.setEmail(email);
                        break;
                    case 8:
                        System.out.println("Enter type of guest for new Customer : ");
                        String typeOfGuest = scanner.nextLine();
                        customerEdit.setTypeCustomer(typeOfGuest);
                        break;
                    case 9:
                        System.out.println("Enter address for new Customer : ");
                        String address = scanner.nextLine();
                        customerEdit.setAddress(address);
                        break;
                }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }
}
