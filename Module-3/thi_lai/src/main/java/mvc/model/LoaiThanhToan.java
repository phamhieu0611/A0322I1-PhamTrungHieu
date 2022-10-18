package mvc.model;

public class LoaiThanhToan {
    private int ma_thanh_toan;
    private String loai_thanh_toan;

    public LoaiThanhToan(int ma_thanh_toan, String loai_thanh_toan) {
        this.ma_thanh_toan = ma_thanh_toan;
        this.loai_thanh_toan = loai_thanh_toan;
    }

    public LoaiThanhToan() {
    }

    public int getMa_thanh_toan() {
        return ma_thanh_toan;
    }

    public void setMa_thanh_toan(int ma_thanh_toan) {
        this.ma_thanh_toan = ma_thanh_toan;
    }

    public String getLoai_thanh_toan() {
        return loai_thanh_toan;
    }

    public void setLoai_thanh_toan(String loai_thanh_toan) {
        this.loai_thanh_toan = loai_thanh_toan;
    }
}
