package QuanLyTaiKhoanNganHang.model;

public class TaiKhoanTietKiem extends TaiKhoanNganHang {
    private double soTienGui;
    private String ngayGui;
    private double laiSuat;
    private int kiHan;

    public TaiKhoanTietKiem() {

    }

    public TaiKhoanTietKiem(double soTienGui, String ngayGui, double laiSuat, int kiHan) {
        this.soTienGui = soTienGui;
        this.ngayGui = ngayGui;
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public TaiKhoanTietKiem(int idTaiKhoan, String maTaiKhoan, String tenChuTaiKhoan, String ngayTaoTaiKhoan,
                            double soTienGui, String ngayGui, double laiSuat, int kiHan) {
        super(idTaiKhoan, maTaiKhoan, tenChuTaiKhoan, ngayTaoTaiKhoan);
        this.soTienGui = soTienGui;
        this.ngayGui = ngayGui;
        this.laiSuat = laiSuat;
        this.kiHan = kiHan;
    }

    public double getSoTienGui() {
        return soTienGui;
    }

    public void setSoTienGui(double soTienGui) {
        this.soTienGui = soTienGui;
    }

    public String getNgayGui() {
        return ngayGui;
    }

    public void setNgayGui(String ngayGui) {
        this.ngayGui = ngayGui;
    }

    public double getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(double laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getKiHan() {
        return kiHan;
    }

    public void setKiHan(int kiHan) {
        this.kiHan = kiHan;
    }

    @Override
    public String toString() {
        return "TaiKhoanTietKiem{" + super.toString() +
                "soTienGui=" + soTienGui +
                ", ngayGui='" + ngayGui + '\'' +
                ", laiSuat=" + laiSuat +
                ", kiHan=" + kiHan +
                '}';
    }

    @Override
    public String getInfor() {
        return String.format("%d,%s,%s,%s,%f,%s,%f,%d\n", this.getIdTaiKhoan(), this.getMaTaiKhoan(),
                this.getTenChuTaiKhoan(), this.getNgayTaoTaiKhoan(), this.getSoTienGui(), this.getNgayGui(),
                this.getLaiSuat(), this.getKiHan());
    }
}
