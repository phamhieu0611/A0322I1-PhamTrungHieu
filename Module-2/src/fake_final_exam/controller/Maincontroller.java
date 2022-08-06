package fake_final_exam.controller;

import fake_final_exam.models.Emobile;
import fake_final_exam.models.Motor;
import fake_final_exam.models.Truck;
import fake_final_exam.service.impl.EmobileImpl;
import fake_final_exam.service.impl.MotorImpl;
import fake_final_exam.service.impl.TruckImpl;

import java.util.Scanner;

public class Maincontroller {
    private static Scanner scanner = new Scanner(System.in);
    private static TruckImpl truck = new TruckImpl();
    private static MotorImpl motor = new MotorImpl();
    private static EmobileImpl emobile = new EmobileImpl();
    private static Truck truckService = new Truck();
    private static Motor motorService = new Motor();
    private static Emobile emobileService = new Emobile();

    public static void mainController(){
        while (true){
            try{
                int select = 0;
                System.out.println("--------------------------Menu--------------------------");
                System.out.println("1. Add new vehicle.");
                System.out.println("2. Display list vehicle.");
                System.out.println("3. Delete vehicle.");
                System.out.println("4. Find by license plates.");
                System.out.println("5. Exit.");
                System.out.print("Enter your choice: ");
                select = Integer.parseInt(scanner.nextLine());
                switch (select){
                    case 1:
                        int choose = 0;
                        System.out.println("--------------------------Menu--------------------------");
                        System.out.println("1. Add new Truck.");
                        System.out.println("2. Add new Motor.");
                        System.out.println("3. Add new E-mobile.");
                        System.out.println("4. back to menu.");
                        System.out.print("Enter your choice: ");
                        choose = Integer.parseInt(scanner.nextLine());
                        switch (choose){
                            case 1:
                                truckService.add();
                                break;
                            case 2:
                                motorService.add();
                                break;
                            case 3:
                                emobileService.add();
                                break;
                            case 4:
                                mainController();
                                break;
                        }
                        break;
                    case 2:
                        int choice = 0;
                        System.out.println("--------------------------Menu--------------------------");
                        System.out.println("1. Display list Truck.");
                        System.out.println("2. Display list Motor.");
                        System.out.println("3. Display list E-mobile.");
                        System.out.println("4. Display menu.");
                        System.out.print("Enter your choice: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice){
                            case 1:
                                truck.display();
                                break;
                            case 2:
                                motor.display();
                                break;
                            case 3:
                                emobile.display();
                                break;
                            case 4:
                                mainController();
                                break;
                        }
                        break;
                    case 3:
                        int nhap = 0;
                        System.out.println("--------------------------Menu--------------------------");
                        System.out.println("1. Delete Truck.");
                        System.out.println("2. Delete Motor.");
                        System.out.println("3. Delete E-mobile.");
                        System.out.println("4. back to menu.");
                        System.out.print("Enter your choice: ");
                        nhap = Integer.parseInt(scanner.nextLine());
                        switch (nhap){
                            case 1:
                                truck.delete();
                                break;
                            case 2:
                                motor.delete();
                                break;
                            case 3:
                                emobile.delete();
                                break;
                            case 4:
                                mainController();
                                break;
                        }
                        break;
                    case 4:
                        int input = 0;
                        System.out.println("--------------------------Menu--------------------------");
                        System.out.println("1. find list Truck.");
                        System.out.println("2. find list Motor.");
                        System.out.println("3. find list E-mobile.");
                        System.out.println("4. Display menu.");
                        System.out.print("Enter your choice: ");
                        input = Integer.parseInt(scanner.nextLine());
                        switch (input){
                            case 1:
                                truck.find();
                                break;
                            case 2:
                                motor.find();
                                break;
                            case 3:
                                emobile.find();
                                break;
                            case 4:
                                mainController();
                                break;
                        }
                        break;
                    case 5:
                        System.exit(0);
                }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }

    public static void main(String[] args) {
        Maincontroller maincontrollers = new Maincontroller();
        maincontrollers.mainController();
    }
}
