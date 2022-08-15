package final_exam.models;

public class ThanhToan extends TaiKhoan{
    private int soThe;
    private double soTienTrongTaiKhoan;

    public ThanhToan() {
    }

    public ThanhToan(int idTuTang, String maTaiKhoan, String chuTaiKhoan, String ngayTao, int soThe, double soTienTrongTaiKhoan) {
        super(idTuTang, maTaiKhoan, chuTaiKhoan, ngayTao);
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
        return "ThanhToan: " + super.toString() +
                "soThe=" + soThe +
                ", soTienTrongTaiKhoan=" + soTienTrongTaiKhoan;
    }

    @Override
    public String layThongTin() {
        return String.format("%d,%s,%s,%s,%d,%f\n",this.getIdTuTang(), this.getMaTaiKhoan(),
                this.getChuTaiKhoan(), this.getNgayTao(),this.getSoThe(),this.getSoTienTrongTaiKhoan());
    }
}
