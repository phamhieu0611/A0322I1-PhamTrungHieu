package fake_final_exam2.models;

public class HocSinh extends Person{
    private String lop;
    private String diem;

    public HocSinh() {
    }

    public HocSinh(String name, String date, String gender, String lop, String diem) {
        super(name, date, gender);
        this.lop = lop;
        this.diem = diem;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getDiem() {
        return diem;
    }

    public void setDiem(String diem) {
        this.diem = diem;
    }

    @Override
    public String toString() {
        return "HocSinh: " + super.toString() +
                "lop='" + lop + '\'' +
                ", diem='" + diem + '\'';
    }

    @Override
    public String layThongTin() {
        return String.format("%s,%s,%s,%s,%s", this.getName()+this.getDate()+this.getGender()+this.getLop()+this.getDiem());
    }
}
