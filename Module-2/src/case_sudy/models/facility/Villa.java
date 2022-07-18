package case_sudy.models.facility;

public class Villa extends Facility {
    private String roomStandard;
    private double areaPool;
    private int floor;
    private double pricePerVilla = 1000;

    public Villa(String nameService, String typeRent, double area, int maxPerson, double price, String roomStandard, double areaPool, int floor, double pricePerVilla) {
        super(nameService, typeRent, area, maxPerson, price);
        this.roomStandard = roomStandard;
        this.areaPool = areaPool;
        this.floor = floor;
        this.pricePerVilla = pricePerVilla;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public double getPricePerVilla() {
        return pricePerVilla;
    }

    public void setPricePerVilla(double pricePerVilla) {
        this.pricePerVilla = pricePerVilla;
    }

    @Override
    public String toString() {
        return "Villa{" +super.toString()+
                "\nroomStandard='" + getRoomStandard() + '\'' +
                ", areaPool=" + getAreaPool() +
                ", floor=" + getFloor() +
                ", pricePerVilla=" + getPricePerVilla() +
                '}';
    }
}
