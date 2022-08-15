package final_exam.models;

public abstract class TaiKhoan {
    private int idTuTang;
    private String maTaiKhoan;
    private String chuTaiKhoan;
    private String ngayTao;
    private static int tangId = 0;

    public abstract String layThongTin();

    public TaiKhoan() {
    }

    public static void tangID(){
        tangId++;
    }

    public TaiKhoan(int idTuTang, String maTaiKhoan, String chuTaiKhoan, String ngayTao) {
        this.idTuTang = tangId;
        this.maTaiKhoan = maTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.ngayTao = ngayTao;
    }

    public int getIdTuTang() {
        return idTuTang;
    }

    public void setIdTuTang(int idTuTang) {
        this.idTuTang = idTuTang;
    }

    public String getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(String maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return chuTaiKhoan;
    }

    public void setChuTaiKhoan(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return "TaiKhoan: " +
                "idTuTang=" + idTuTang +
                ", maTaiKhoan='" + maTaiKhoan + '\'' +
                ", chuTaiKhoan='" + chuTaiKhoan + '\'' +
                ", ngayTao='" + ngayTao + '\'';
    }
}
