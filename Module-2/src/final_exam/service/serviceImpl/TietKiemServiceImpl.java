package final_exam.service.serviceImpl;

import case_study.action.Validate;
import final_exam.models.TietKiem;
import final_exam.service.TaiKhoanService;
import final_exam.utils.ReadFile;
import final_exam.utils.WriteFile;

import java.util.List;
import java.util.Scanner;

public class TietKiemServiceImpl implements TaiKhoanService {
    private static Scanner scanner = new Scanner(System.in);
    private static final String TIET_KIEM_CSV = "C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\final_exam\\data\\tietKiem.csv";

    @Override
    public void them() {
        List<TietKiem> tietKiemList = ReadFile.docFileTietKiem(TIET_KIEM_CSV);
        TietKiem tietKiem = nhapThongTin();
        tietKiemList.add(tietKiem);
        WriteFile.ghiFileTietKiem(TIET_KIEM_CSV, tietKiemList);
        System.out.println("Thêm mới tài khoản thanh toán thành công");
    }

    @Override
    public void xoa() {
        List<TietKiem> tietKiemList = ReadFile.docFileTietKiem(TIET_KIEM_CSV);
        boolean kiemTra = false;
        try {

            if (tietKiemList.isEmpty()) {
                System.out.println("Danh sách tài khoản tiết kiệm trống");
            } else {
                System.out.print("Nhập id tài khoản muốn xóa :");
                int idXoa = Integer.parseInt(scanner.nextLine());
                for (TietKiem tietKiem : tietKiemList) {
                    if (tietKiem.getIdTuTang() == idXoa) {
                        System.out.println("Bạn có muốn xóa tài khoản có id " + idXoa + " có chủ tài khoản là " + tietKiem.getChuTaiKhoan() + " không ?");
                        System.out.println("1.Có");
                        System.out.println("2.Không");
                        System.out.print("Nhập lựa chọn: ");
                        int luaChon = Integer.parseInt(scanner.nextLine());
                        if (luaChon == 1) {
                            tietKiemList.remove(tietKiem);
                            WriteFile.ghiFileTietKiem(TIET_KIEM_CSV, tietKiemList);
                            kiemTra = true;
                            System.out.println("Xóa thành công!");
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
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    @Override
    public void hienThi() {
        List<TietKiem> tietKiemList = ReadFile.docFileTietKiem(TIET_KIEM_CSV);
        try {
            if (tietKiemList.isEmpty()) {
                System.out.println("Danh sách tài khoản thanh toán đang trống");
            } else {
                for (TietKiem tietKiem : tietKiemList) {
                    System.out.println(tietKiem);
                }
            }
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }
    }

    @Override
    public void timKiem() {
        List<TietKiem> tietKiemList = ReadFile.docFileTietKiem(TIET_KIEM_CSV);
        boolean kiemTra = false;
        if (tietKiemList.isEmpty()) {
            System.out.println("Danh sách tài khoản thanh toán trống");
        } else {
            int idTimKiem = -1;
            try {
                System.out.print("Nhập id tài khoản bạn muốn tìm kiếm :");
                idTimKiem = Integer.parseInt(scanner.nextLine());
                for (TietKiem tietKiem : tietKiemList) {
                    if(tietKiem.getIdTuTang()==idTimKiem){
                        System.out.println("Tài khoản tiết kiệm có id "+idTimKiem + "là "+tietKiem);
                        kiemTra=true;
                        break;
                    }
                }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
            if(!kiemTra){
                System.out.println("Không tìm thấy tài khoản có id "+idTimKiem);
            }
        }
    }

    public TietKiem nhapThongTin() {
        List<TietKiem> tietKiemList = ReadFile.docFileTietKiem(TIET_KIEM_CSV);
        int idTaiKhoan;
        if(tietKiemList.isEmpty()){
            idTaiKhoan = 1;
        }else {
            idTaiKhoan = tietKiemList.get(tietKiemList.size()-1).getIdTuTang()+1;
        }
            System.out.print("Nhập mã tài khoản tài khoản :");
            String maTaiKhoan = scanner.nextLine();
            String nhapTen;
            while (true)
            {
                System.out.print("Nhập họ và tên đầy đủ: ");
                nhapTen=scanner.nextLine();
                if(Validate.nameRegex(nhapTen))
                    break;
                System.out.print("Nhập tên tiếng anh hoặc tên tiếng việt!");
            }
            String tenChuTaiKhoan = nhapTen;
            String nhapNgay;
            while (true)
            {
                System.out.print("Nhập ngày tạo tài khoản :");
                nhapNgay=scanner.nextLine();
                if(Validate.dateRegex(nhapNgay))
                    break;
                System.out.println("Định dạng ngày: dd-MM-yyyy");
            }
            String ngayTaoTaiKhoan = nhapNgay;
            System.out.print("Nhập số tiền gửi tiết kiệm :");
            double soTienGui = Double.parseDouble(scanner.nextLine());

            String nhapNgayGui;
            while (true) {
                System.out.print("Nhập ngày gửi tiết kiệm :");
                nhapNgayGui=scanner.nextLine();
                if(Validate.dateRegex(nhapNgayGui))
                    break;
                System.out.println("Định dạng ngày: dd-MM-yyyy");
            }
            String ngayGui = nhapNgayGui;
            System.out.print("Nhập lãi suất :");
            double laiSuat = Double.parseDouble(scanner.nextLine());
            System.out.print("Nhập kì hạn gửi :");
            int kiHan = Integer.parseInt(scanner.nextLine());
            return new TietKiem(idTaiKhoan, maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan, soTienGui, ngayGui, laiSuat, kiHan);
    }
}
