package case_sudy.models;

public class House extends Facility {
    private String roomStandard;
    private double pricePerHouse = 500;
    private int floor;

    public House(String tenDichVu, String kieuThue, double area, int maxPerson, double price, String roomStandard, double pricePerHouse, int floor) {
        super(tenDichVu, kieuThue, area, maxPerson, price);
        this.roomStandard = roomStandard;
        this.pricePerHouse = pricePerHouse;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPricePerHouse() {
        return pricePerHouse;
    }

    public void setPricePerHouse(int pricePerHouse) {
        this.pricePerHouse = pricePerHouse;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public void area(double area) {
        System.out.println("\nRent house:"+
                "\nArea House = "+getArea());
    }


    @Override
    public void price(double price) {
        double totalPriceHouse = getPrice()+(pricePerHouse*floor);
        System.out.println("\nFlorr = "+floor+
                "\nPrice Room = "+getPrice()+"$"+
                "\nTotal = "+totalPriceHouse+"$");
    }

    @Override
    public String toString() {
        return "House{" +super.toString()+
                "\nroomStandard='" + getRoomStandard() + '\'' +
                ", pricePerHouse=" + getPricePerHouse() +
                ", floor=" + getFloor() +
                '}';
    }
}
