package case_sudy.controllers.task2.theHouse;

public abstract class Facility {

    private String tenDichVu, kieuThue;
    private int area, maxPerson, price;

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

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    public Facility(String tenDichVu, String kieuThue, int area, int maxPerson, int price) {
        this.tenDichVu = tenDichVu;
        this.kieuThue = kieuThue;
        this.area = area;
        this.maxPerson = maxPerson;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public abstract void area(int area);

    public abstract void price(int price);
}