package case_study.models.facility;

public class House extends Facility{
    private String roomStandard;
    private int floor;

    public House(String nameService, String typeRent, double price, double area, int maxPerson, String roomStandard, int floor) {
        super(nameService, typeRent, price, area, maxPerson);
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public House(String facilityID, String nameService, String typeRent, double price, double area, int maxPerson, String roomStandard, int floor) {
        super(facilityID, nameService, typeRent, price, area, maxPerson);
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" +super.toString()+'\''+
                "roomStandard='" + roomStandard + '\'' +
                ", floor=" + floor +
                '}';
    }
}
