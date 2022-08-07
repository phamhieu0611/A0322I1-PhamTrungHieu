package fake_final_exam2.models;

public class GiangVien extends Person{
    private String chuyenMon;

    public GiangVien() {
    }

    public GiangVien(String name, String date, String gender, String chuyenMon) {
        super(name, date, gender);
        this.chuyenMon = chuyenMon;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    @Override
    public String toString() {
        return "GiangVien: " + super.toString() +
                "chuyenMon='" + chuyenMon + '\'';
    }

    @Override
    public String layThongTin() {
        return String.format("%s,%s,%s,%s", this.getName()+this.getDate()+this.getGender()+this.getChuyenMon());

    }
}
