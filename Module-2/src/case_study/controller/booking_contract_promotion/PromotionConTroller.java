package case_study.controller.booking_contract_promotion;

import case_study.controller.FuramaController;
import case_study.service.serviceImpl.PromotionServiceImpl;

import java.util.Scanner;

public class PromotionConTroller {
    private static Scanner scanner = new Scanner(System.in);
    private static PromotionServiceImpl promotionService = new PromotionServiceImpl();

    public static void promotionController(){
        while (true){
            try {
                int select = 0;
                System.out.println("-----------------Promotion Management.-----------------");
                System.out.println("1. Display list customer use service");
                System.out.println("2. Display list customer get voucher");
                System.out.println("3. return main menu");
                System.out.print("\nEnter your choice: ");
                select = Integer.parseInt(scanner.nextLine());
                switch (select) {
                    case 1:
                        promotionService.displayUserService();
                        break;
                    case 2:
                        promotionService.displayGetVoucherService();
                        break;
                    case 3:
                        FuramaController.furamaController();
                        break;
                }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }
    }
}
