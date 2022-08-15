package QuanLyTaiKhoanNganHang.controllers;


import QuanLyTaiKhoanNganHang.service.impl.TaiKhoanThanhToanService;

import java.util.Scanner;

public class TKThanhToanController {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static TaiKhoanThanhToanService taiKhoanThanhToanService = new TaiKhoanThanhToanService();
    public static void taiKhoanThanhToanController(){
        do {
            System.out.println("--------QUẢN LÝ TÀI KHOẢN THANH TOÁN------");
            System.out.println("1.Thêm mới tài khoản");
            System.out.println("2.Xóa tài khoản");
            System.out.println("3.Xem danh sách tài khoản ngân hàng");
            System.out.println("4.Tìm kiếm tài khoản");
            System.out.println("5.Quay về menu chính");
            System.out.print("Nhập lựa chọn của bạn :");
            int luaChon = Integer.parseInt(SCANNER.nextLine());
            switch (luaChon){
                case 1:
                    taiKhoanThanhToanService.them();
                    break;
                case 2:
                    taiKhoanThanhToanService.xoa();
                    break;
                case 3:
                    taiKhoanThanhToanService.hienThi();
                    break;
                case 4:
                    taiKhoanThanhToanService.timKiem();
                    break;
                case 5:
                    return;
            }
        }while (true);

    }
}
