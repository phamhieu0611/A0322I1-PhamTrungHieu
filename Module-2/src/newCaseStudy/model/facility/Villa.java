package newCaseStudy.model.facility;

public class Villa extends Facility{
    private String roomStandard;
    private double areaPool;
    private int floor;

    public Villa(String nameService, String typeRent, double price, double area, int maxPerson, String roomStandard, double areaPool, int floor) {
        super(nameService, typeRent, price, area, maxPerson);
        this.roomStandard = roomStandard;
        this.areaPool = areaPool;
        this.floor = floor;
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

    @Override
    public String toString() {
        return "Villa{" +super.toString()+'\''+
                "roomStandard='" + roomStandard + '\'' +
                ", areaPool=" + areaPool +
                ", floor=" + floor +
                '}';
    }
}
