package QuanLyTaiKhoanNganHang.model;

public class TaiKhoanThanhToan extends TaiKhoanNganHang{
    private int soThe;
    private double soTienTrongTaiKhoan;

    public TaiKhoanThanhToan(){

    }

    public TaiKhoanThanhToan(int soThe, double soTienTrongTaiKhoan) {
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public TaiKhoanThanhToan(int idTaiKhoan, String maTaiKhoan, String tenChuTaiKhoan, String ngayTaoTaiKhoan,
                             int soThe, double soTienTrongTaiKhoan) {
        super(idTaiKhoan, maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan);
        this.soThe = soThe;
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    public int getSoThe() {
        return soThe;
    }

    public void setSoThe(int soThe) {
        this.soThe = soThe;
    }

    public double getSoTienTrongTaiKhoan() {
        return soTienTrongTaiKhoan;
    }

    public void setSoTienTrongTaiKhoan(double soTienTrongTaiKhoan) {
        this.soTienTrongTaiKhoan = soTienTrongTaiKhoan;
    }

    @Override
    public String toString() {
        return "TaiKhoanThanhToan{" + super.toString()+
                "soThe=" + soThe +
                ", soTienTrongTaiKhoan=" + soTienTrongTaiKhoan +
                '}';
    }

    @Override
    public String getInfor() {
        return String.format("%d,%s,%s,%s,%d,%f\n",this.getIdTaiKhoan(),this.getMaTaiKhoan(),this.getTenChuTaiKhoan(),
                this.getNgayTaoTaiKhoan(),this.getSoThe(),this.getSoTienTrongTaiKhoan());
    }
}
