package newCaseStudy.model.facility;

public abstract class Facility {
    private String nameService, typeRent;
    private double price, area;
    private int maxPerson;

    public Facility(String nameService, String typeRent, double price, double area, int maxPerson) {
        this.nameService = nameService;
        this.typeRent = typeRent;
        this.price = price;
        this.area = area;
        this.maxPerson = maxPerson;
    }

    public Facility() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    @Override
    public String toString() {
        return "Facility{" +
                "nameService='" + nameService + '\'' +
                ", typeRent='" + typeRent + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", maxPerson=" + maxPerson +
                '}';
    }
}
