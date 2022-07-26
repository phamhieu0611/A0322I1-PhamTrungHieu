package case_study.models.facility;

public abstract class Facility {
    private static int id = 1000;
    private String facilityID;
    private String nameService, typeRent;
    private double price, area;
    private int maxPerson;

    public Facility(String nameService, String typeRent, double price, double area, int maxPerson) {
        this.nameService = nameService;
        this.typeRent = typeRent;
        this.price = price;
        this.area = area;
        this.maxPerson = maxPerson;
        String maHoa = "SV";
        if (nameService.equalsIgnoreCase("Villa"))
            maHoa+="VL";
        if (nameService.equalsIgnoreCase("House"))
            maHoa+= "HO";
        if (nameService.equalsIgnoreCase("Room"))
            maHoa+="RO";
        facilityID = maHoa+"_"+(++id);
    }

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

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Facility.id = id;
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

}
