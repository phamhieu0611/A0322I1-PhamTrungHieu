package case_sudy.models;

public abstract class Facility {

    private String tenDichVu, kieuThue;
    private double area, price;
    int maxPerson;

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public String getKieuThue() {
        return kieuThue;
    }

    public void setKieuThue(String kieuThue) {
        this.kieuThue = kieuThue;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public Facility(String tenDichVu, String kieuThue, double area, int maxPerson, double price) {
        this.tenDichVu = tenDichVu;
        this.kieuThue = kieuThue;
        this.area = area;
        this.maxPerson = maxPerson;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void area(double area);

    public abstract void price(double price);

    @Override
    public String toString() {
        return "Facility{" +
                "tenDichVu='" + tenDichVu + '\'' +
                ", kieuThue='" + kieuThue + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", maxPerson=" + maxPerson +
                '}';
    }
}