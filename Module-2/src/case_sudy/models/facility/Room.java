package case_sudy.models.facility;

public class Room extends Facility {
    private double priceFerRoom = 250;
    private String freeService;

    public Room(String nameService, String typeRent, double area, int maxPerson, double price, double priceFerRoom, String freeService) {
        super(nameService, typeRent, area, maxPerson, price);
        this.priceFerRoom = priceFerRoom;
        this.freeService = freeService;
    }

    public double getPriceFerRoom() {
        return priceFerRoom;
    }

    public void setPriceFerRoom(double priceFerRoom) {
        this.priceFerRoom = priceFerRoom;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +super.toString()+
                "\npriceFerRoom=" + getPriceFerRoom() +
                ", freeService='" + getFreeService() + '\'' +
                '}';
    }
}
