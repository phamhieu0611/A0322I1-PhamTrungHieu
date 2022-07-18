package case_sudy.models.facility;

public class House extends Facility {
    private String roomStandard;
    private double pricePerHouse = 500;
    private int floor;

    public House(String nameService, String typeRent, double area, int maxPerson, double price, String roomStandard, double pricePerHouse, int floor) {
        super(nameService, typeRent, area, maxPerson, price);
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

    public void setPricePerHouse(double pricePerHouse) {
        this.pricePerHouse = pricePerHouse;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
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
