package final_exam.service.serviceImpl;

import case_study.action.Validate;
import final_exam.models.ThanhToan;
import final_exam.service.TaiKhoanService;
import final_exam.utils.ReadFile;
import final_exam.utils.WriteFile;

import java.util.List;
import java.util.Scanner;

public class ThanhToanServiceImpl implements TaiKhoanService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String THANH_TOAN_CSV ="C:\\Users\\User\\OneDrive\\Desktop\\Codegym\\A0322I1-PhamTrungHieu\\Module-2\\src\\final_exam\\data\\thanhToan.csv";
    @Override
    public void them() {
        List<ThanhToan> thanhToanList = ReadFile.docFileThanhToan(THANH_TOAN_CSV);
        ThanhToan taiKhoanThanhToan = nhapThongTin();
        thanhToanList.add(taiKhoanThanhToan);
        WriteFile.ghiFileThanhToan(THANH_TOAN_CSV,thanhToanList);
        System.out.println("Thêm tài khoản thanh toán thành công");
    }

    @Override
    public void xoa() {
        List<ThanhToan> thanhToanList = ReadFile.docFileThanhToan(THANH_TOAN_CSV);
        boolean kiemTra = false;
        if(thanhToanList.isEmpty()){
            System.out.println("Danh sách tài khoản thanh toán trống");
        }else {
            int idXoa = -1;
            try {
                System.out.print("Nhập id tài khoản bạn cần xóa :");
                idXoa = Integer.parseInt(scanner.nextLine());
                for (ThanhToan taikhoanThanhToan:thanhToanList) {
                    if(taikhoanThanhToan.getIdTuTang()==idXoa){
                        System.out.println("Bạn có muốn xóa tài khoản có id "+idXoa+" có chủ tài khoản là " +taikhoanThanhToan.getChuTaiKhoan()+ " không ?");
                        System.out.println("1.Có");
                        System.out.println("2.Không");
                        System.out.print("Nhập lựa chọn của bạn :");
                        int luaChon = Integer.parseInt(scanner.nextLine());
                        if(luaChon==1){
                            thanhToanList.remove(taikhoanThanhToan);
                            WriteFile.ghiFileThanhToan(THANH_TOAN_CSV,thanhToanList);
                            kiemTra= true;
                            System.out.println("Xóa thành công");
                            break;
                        }else if(luaChon==2){
                            kiemTra=true;
                            break;
                        }
                    }
                }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }
            if(!kiemTra){
                System.out.println("Không tìm thấy tài khoản thanh toán có id là "+idXoa);
            }
        }
    }

    @Override
    public void hienThi() {
        List<ThanhToan> thanhToanList = ReadFile.docFileThanhToan(THANH_TOAN_CSV);
        if(thanhToanList.isEmpty()){
            System.out.println("Danh sách tài khoản thanh toán đang trống");
        }else {
            for (ThanhToan taiKhoanThanhToan : thanhToanList) {
                System.out.println(taiKhoanThanhToan);
            }
        }
    }

    @Override
    public void timKiem() {
        List<ThanhToan> thanhToanList = ReadFile.docFileThanhToan(THANH_TOAN_CSV);
        boolean kiemTra = false;
        if(thanhToanList.isEmpty()){
            System.out.println("Danh sách tài khoản thanh toán trống");
        }else {
            int idTimKiem = -1;
            try {
                System.out.print("Nhập id tài khoản bạn cần tìm :");
                idTimKiem = Integer.parseInt(scanner.nextLine());
                for (ThanhToan taiKhoanThanhToan : thanhToanList) {
                    if(taiKhoanThanhToan.getIdTuTang()==idTimKiem){
                        System.out.println("Tài khoản có id "+idTimKiem+" là "+taiKhoanThanhToan);
                        kiemTra= true;
                        break;
                    }
                }
            }catch (Exception e){
                System.err.println("Exception "+e.toString());
            }

            if(!kiemTra){
                System.out.println("Không tìm thấy tài khoản thanh toán có id "+ idTimKiem);
            }
        }


    }
    public ThanhToan nhapThongTin(){
        List<ThanhToan> thanhToanList = ReadFile.docFileThanhToan(THANH_TOAN_CSV);
        int idTaiKhoan;
        if(thanhToanList.isEmpty()){
            idTaiKhoan = 1;
        }else{
            idTaiKhoan = thanhToanList.get(thanhToanList.size()-1).getIdTuTang()+1;
        }
        try{
            System.out.print("Nhập mã tài khoản tài khoản :");
            String maTaiKhoan= scanner.nextLine();
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
            System.out.print("Nhập số thẻ tài khoản :");
            int soThe=Integer.parseInt(scanner.nextLine());
            System.out.print("Nhập số tiền trong tài khoản :");
            double soTienTrongTaiKhoan = Double.parseDouble(scanner.nextLine());
            return new ThanhToan(idTaiKhoan,maTaiKhoan,tenChuTaiKhoan,ngayTaoTaiKhoan,soThe,soTienTrongTaiKhoan);
        }catch (Exception e){
            System.err.println("Exception "+e.toString());
        }return null;
    }
}
