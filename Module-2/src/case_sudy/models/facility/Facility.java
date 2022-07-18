package case_sudy.models.facility;

public abstract class Facility {

    private String nameService, typeRent;
    private double area, price;
    int maxPerson;

    public Facility(String nameService, String typeRent, double area, int maxPerson, double price) {
        this.nameService = nameService;
        this.typeRent = typeRent;
        this.area = area;
        this.price = price;
        this.maxPerson = maxPerson;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(String typeRent) {
        this.typeRent = typeRent;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxPerson() {
        return maxPerson;
    }

    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "nameService='" + nameService + '\'' +
                ", typeRent='" + typeRent + '\'' +
                ", area=" + area +
                ", price=" + price +
                ", maxPerson=" + maxPerson +
                '}';
    }
}