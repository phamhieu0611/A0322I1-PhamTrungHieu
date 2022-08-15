package final_exam.models;

public class TietKiem extends TaiKhoan{
    private double soTienGui;
    private String ngayGui;
    private double laiSuat;
    private int kiHan;

    public TietKiem() {
    }

    public TietKiem(int idTuTang, String maTaiKhoan, String chuTaiKhoan, String ngayTao, double soTienGui, String ngayGui, double laiSuat, int kiHan) {
        super(idTuTang, maTaiKhoan, chuTaiKhoan, ngayTao);
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
        return "TaiKhoanTietKiem: " + super.toString() +
                "soTienGui=" + soTienGui +
                ", ngayGui='" + ngayGui + '\'' +
                ", laiSuat=" + laiSuat +
                ", kiHan=" + kiHan;
    }

    @Override
    public String layThongTin() {
        return String.format("%d,%s,%s,%s,%f,%s,%f,%d\n", this.getIdTuTang(), this.getMaTaiKhoan(),
                this.getChuTaiKhoan(), this.getNgayTao(), this.getSoTienGui(), this.getNgayGui(),
                this.getLaiSuat(), this.getKiHan());
    }
}
