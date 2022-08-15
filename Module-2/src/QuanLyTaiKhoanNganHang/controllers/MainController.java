package QuanLyTaiKhoanNganHang.controllers;

import java.util.Scanner;

public class MainController {
    private static final Scanner SCANNER = new Scanner(System.in);
    public static void menuController(){
        do {
            System.out.println("CHÀO MỪNG BẠN ĐẾN VỚI CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG");
            System.out.println("1.Quản lý tài khoản tiết kiệm ");
            System.out.println("2.Quản lý tài khoản thanh toán");
            System.out.println("3.Thoát chương trình");
            System.out.print("Mời bạn nhập lựa chọn :");
            int luaChon = Integer.parseInt(SCANNER.nextLine());
            switch (luaChon){
                case 1:
                    TKTietKiemController.taiKhoanTietKiemController();
                    break;
                case 2:
                    TKThanhToanController.taiKhoanThanhToanController();
                    break;
                case 3:
                    System.exit(0);
            }
        }while (true);

    }
}
