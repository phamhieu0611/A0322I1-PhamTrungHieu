package QuanLyTaiKhoanNganHang.service.impl;

import QuanLyTaiKhoanNganHang.model.TaiKhoanTietKiem;
import QuanLyTaiKhoanNganHang.service.ITaiKhoanNganHang;
import QuanLyTaiKhoanNganHang.utils.DocGhiFileTaiKhoanTietKiem;

import java.util.List;
import java.util.Scanner;

public class TaiKhoanTietKiemService implements ITaiKhoanNganHang {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PATH = "src\\on_tap\\QuanLyTaiKhoanNganHang\\data\\taiKhoanTietKiem.csv";

    @Override
    public void them() {
        List<TaiKhoanTietKiem> taiKhoanTietKiemList = DocGhiFileTaiKhoanTietKiem.docFileTaiKhoanTietKiem(PATH);
        TaiKhoanTietKiem taiKhoanTietKiem = nhapThongTin();
        taiKhoanTietKiemList.add(taiKhoanTietKiem);
        DocGhiFileTaiKhoanTietKiem.ghiFileTaiKhoanTietKiem(PATH, taiKhoanTietKiemList);
        System.out.println("Thêm tài khoản thanh toán thành công");
    }

    @Override
    public void xoa() {
        List<TaiKhoanTietKiem> taiKhoanTietKiemList = DocGhiFileTaiKhoanTietKiem.docFileTaiKhoanTietKiem(PATH);
        boolean kiemTra = false;
        if (taiKhoanTietKiemList.isEmpty()) {
            System.out.println("Danh sách tài khoản tiết kiệm đang trống");
        } else {
            System.out.print("Nhập id tài khoản bạn cần xóa :");
            int idXoa = Integer.parseInt(SCANNER.nextLine());
            for (TaiKhoanTietKiem taiKhoanTietKiem : taiKhoanTietKiemList) {
                if (taiKhoanTietKiem.getIdTaiKhoan() == idXoa) {
                    System.out.println("Bạn có muốn xóa tài khoản có id " + idXoa + " có chủ tài khoản là "
                            + taiKhoanTietKiem.getTenChuTaiKhoan() + " không ?");
                    System.out.println("1.Có");
                    System.out.println("2.Không");
                    System.out.print("Nhập lựa chọn của bạn :");
                    int luaChon = Integer.parseInt(SCANNER.nextLine());
                    if (luaChon == 1) {
                        taiKhoanTietKiemList.remove(taiKhoanTietKiem);
                        DocGhiFileTaiKhoanTietKiem.ghiFileTaiKhoanTietKiem(PATH, taiKhoanTietKiemList);
                        kiemTra = true;
                        System.out.println("Xóa thành công");
                        System.out.println("Danh sách tài khoản tiết kiệm sau khi xóa");
                        hienThi();
                        break;
                    } else if (luaChon == 2) {
                        kiemTra = true;
                        break;
                    }
                }
            }
            if (!kiemTra) {
                System.out.println("Không tìm thấy tài khoản thanh toán có id là " + idXoa);
            }
        }
    }

    @Override
    public void hienThi() {
        List<TaiKhoanTietKiem> taiKhoanTietKiemList = DocGhiFileTaiKhoanTietKiem.docFileTaiKhoanTietKiem(PATH);
        if (taiKhoanTietKiemList.isEmpty()) {
            System.out.println("Danh sách tài khoản thanh toán đang trống");
        } else {
            for (TaiKhoanTietKiem taiKhoanTietKiem : taiKhoanTietKiemList) {
                System.out.println(taiKhoanTietKiem);
            }
        }
    }

    @Override
    public void timKiem() {
        List<TaiKhoanTietKiem> taiKhoanTietKiemList = DocGhiFileTaiKhoanTietKiem.docFileTaiKhoanTietKiem(PATH);
        boolean kiemTra = false;
        if (taiKhoanTietKiemList.isEmpty()) {
            System.out.println("Danh sách tài khoản thanh toán đang trống");
        } else {
            System.out.print("Nhập id tài khoản bạn muốn tìm kiếm :");
            int idTimKiem = Integer.parseInt(SCANNER.nextLine());
            for (TaiKhoanTietKiem taiKhoanTietKiem : taiKhoanTietKiemList) {
                if(taiKhoanTietKiem.getIdTaiKhoan()==idTimKiem){
                    System.out.println("Tài khoản tiết kiệm có id "+idTimKiem + "là "+taiKhoanTietKiem);
                    kiemTra=true;
                    break;
                }
            }
            if(!kiemTra){
                System.out.println("Không tìm thấy tài khoản có id "+idTimKiem);
            }
        }
    }

    public TaiKhoanTietKiem nhapThongTin() {
        int idTaiKhoan;
        String maTaiKhoan;
        String tenChuTaiKhoan;
        String ngayTaoTaiKhoan;
        double soTienGui;
        String ngayGui;
        double laiSuat;
        int kiHan;

        List<TaiKhoanTietKiem> taiKhoanTietKiemList = DocGhiFileTaiKhoanTietKiem.docFileTaiKhoanTietKiem(PATH);
        if(taiKhoanTietKiemList.isEmpty()){
            idTaiKhoan = 1;
        }else {
            idTaiKhoan = taiKhoanTietKiemList.get(taiKhoanTietKiemList.size()-1).getIdTaiKhoan()+1;
        }
        System.out.println("Id tài khoản này là  :"+idTaiKhoan);
       ;

        System.out.print("Nhập mã tài khoản tài khoản :");
        maTaiKhoan = SCANNER.nextLine();

        System.out.print("Nhập tên chủ tài khoản :");
        tenChuTaiKhoan = SCANNER.nextLine();

        System.out.print("Nhập ngày tạo tài khoản :");
        ngayTaoTaiKhoan = SCANNER.nextLine();

        System.out.print("Nhập số tiền gửi tiết kiệm :");
        soTienGui = Double.parseDouble(SCANNER.nextLine());

        System.out.print("Nhập ngày gửi tiết kiệm :");
        ngayGui = SCANNER.nextLine();

        System.out.print("Nhập lãi suất :");
        laiSuat = Double.parseDouble(SCANNER.nextLine());

        System.out.print("Nhập kì hạn gửi :");
        kiHan = Integer.parseInt(SCANNER.nextLine());


        return new TaiKhoanTietKiem(idTaiKhoan, maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan, soTienGui, ngayGui,
                laiSuat, kiHan);
    }
}
