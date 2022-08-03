package case_study.models.facility;

public abstract class Facility {
    private String facilityID;
    private String nameService;
    private String typeRent;
    private double price;
    private double area;
    private int maxPerson;

    public Facility(String facilityID, String nameService, String typeRent, double price, double area, int maxPerson) {
        this.facilityID = facilityID;
        this.nameService = nameService;
        this.typeRent = typeRent;
        this.price = price;
        this.area = area;
        this.maxPerson = maxPerson;
    }

    public Facility() {
    }

    public String getFacilityID() {
        return facilityID;
    }

    public void setFacilityID(String facilityID) {
        this.facilityID = facilityID;
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
        return "facilityID='" + facilityID + '\'' +
                ", nameService='" + nameService + '\'' +
                ", typeRent='" + typeRent + '\'' +
                ", price=" + price +
                ", area=" + area +
                ", maxPerson=" + maxPerson;
    }
}
