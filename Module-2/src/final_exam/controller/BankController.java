package final_exam.controller;

import final_exam.service.serviceImpl.ThanhToanServiceImpl;
import final_exam.service.serviceImpl.TietKiemServiceImpl;

import java.util.Scanner;

public class BankController {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static ThanhToanServiceImpl thanhToanService = new ThanhToanServiceImpl();
    private static TietKiemServiceImpl tietKiemService = new TietKiemServiceImpl();

    public static void bankController(){
        do {
            try {
                System.out.println("----------------TÀI KHOẢN TIẾT KIỆM--------------");
                System.out.println("1.Thêm mới tài khoản");
                System.out.println("2.Xóa tài khoản");
                System.out.println("3.Xem danh sách tài khoản ngân hàng");
                System.out.println("4.Tìm kiếm tài khoản");
                System.out.println("5.Quay về");
                System.out.print("Nhập lựa chọn: ");
                int select = Integer.parseInt(SCANNER.nextLine());
                switch (select){
                    case 1:
                        System.out.println("----------------TÀI KHOẢN TIẾT KIỆM--------------");
                        System.out.println("1.Thêm mới tài khoản tiết kiệm");
                        System.out.println("2.Thêm mới tài khoản thanh toán");
                        System.out.println("3.Quay về");
                        System.out.print("Nhập lựa chọn: ");
                        int choose = Integer.parseInt(SCANNER.nextLine());
                        switch (choose){
                            case 1:
                                tietKiemService.them();
                                break;
                            case 2:
                                thanhToanService.them();
                                break;
                            case 3:
                                bankController();
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("----------------ÀI KHOẢN THANH TOÁN--------------");
                        System.out.println("1.Xóa tài khoản tiết kiệm");
                        System.out.println("2.Xóa tài khoản thanh toán");
                        System.out.println("3.Quay về");
                        System.out.print("Nhập lựa chọn: ");
                        int choice = Integer.parseInt(SCANNER.nextLine());
                        switch (choice){
                            case 1:
                                tietKiemService.xoa();
                                break;
                            case 2:
                                thanhToanService.xoa();
                                break;
                            case 3:
                                bankController();
                                return;
                        }
                        break;
                    case 3:
                        System.out.println("----------------ÀI KHOẢN THANH TOÁN--------------");
                        System.out.println("1.Xem danh sách tài khoản tiết kiệm");
                        System.out.println("2.Xem danh sách tài khoản thanh toán");
                        System.out.println("3.Quay về");
                        System.out.print("Nhập lựa chọn: ");
                        int input = Integer.parseInt(SCANNER.nextLine());
                        switch (input){
                            case 1:
                                tietKiemService.hienThi();
                                break;
                            case 2:
                                thanhToanService.hienThi();
                                break;
                            case 3:
                                bankController();
                                return;
                        }
                        break;
                    case 4:
                        System.out.println("----------------ÀI KHOẢN THANH TOÁN--------------");
                        System.out.println("1.Tìm kiếm tài khoản tiết kiệm");
                        System.out.println("2.Tìm kiếm tài khoản thanh toán");
                        System.out.println("3.Quay về");
                        System.out.print("Nhập lựa chọn: ");
                        int nhap = Integer.parseInt(SCANNER.nextLine());
                        switch (nhap){
                            case 1:
                                tietKiemService.timKiem();
                                break;
                            case 2:
                                thanhToanService.timKiem();
                                break;
                            case 3:
                                bankController();
                                return;
                        }
                        break;
                    case 5:
                        System.exit(0);
                }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
        }while (true);
    }
    
    public static void main(String[] args) {
        bankController();
    }
}