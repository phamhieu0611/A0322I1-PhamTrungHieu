package case_study.controller.booking_contract_promotion;

import case_study.controller.FuramaController;
import case_study.service.serviceImpl.BookingServiceImpl;
import case_study.service.serviceImpl.ContractServiceImpl;

import java.util.Scanner;

public class BookingContractController {
    private static ContractServiceImpl contractService = new ContractServiceImpl();
    private static BookingServiceImpl bookingService = new BookingServiceImpl();
    private static Scanner scanner = new Scanner(System.in);

    public static void controllerBooking() {
        while (true){
            try {
                int select = 0;
                System.out.println("-----------------Booking Management.-----------------");
                System.out.println("1. Add new booking");
                System.out.println("2. Display list booking");
                System.out.println("3. create new contract");
                System.out.println("4. display list contract");
                System.out.println("5. edit contract");
                System.out.println("6. return main menu");
                System.out.print("\nEnter your choice: ");
                select = Integer.parseInt(scanner.nextLine());

                switch (select){
                    case 1:
                        bookingService.addBooking();
                        break;
                    case 2:
                        bookingService.displayBooking();
                        break;
                    case 3:
                        contractService.makeNewContract();
                        break;
                    case 4:
                        contractService.displayContract();
                        break;
                    case 5:
                        contractService.editContract();
                        break;
                    case 6:
                        FuramaController.furamaController();
                        break;
                }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }
}
