package QuanLyTaiKhoanNganHang.controllers;

import QuanLyTaiKhoanNganHang.service.impl.TaiKhoanTietKiemService;

import java.util.Scanner;

public class TKTietKiemController {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static TaiKhoanTietKiemService taiKhoanTietKiemService = new TaiKhoanTietKiemService();

    public static void taiKhoanTietKiemController(){
        do {
            System.out.println("--------QUẢN LÝ TÀI KHOẢN TIẾT KIỆM------");
            System.out.println("1.Thêm mới tài khoản");
            System.out.println("2.Xóa tài khoản");
            System.out.println("3.Xem danh sách tài khoản ngân hàng");
            System.out.println("4.Tìm kiếm tài khoản");
            System.out.println("5.Quay về menu chính");
            System.out.print("Nhập lựa chọn của bạn :");
            int luaChon = Integer.parseInt(SCANNER.nextLine());
            switch (luaChon){
                case 1:
                    taiKhoanTietKiemService.them();
                    break;
                case 2:
                    taiKhoanTietKiemService.xoa();
                    break;
                case 3:
                    taiKhoanTietKiemService.hienThi();
                    break;
                case 4:
                    taiKhoanTietKiemService.timKiem();
                    break;
                case 5:
                    return;
            }
        }while (true);

    }
}
