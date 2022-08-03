package case_study.models.facility;

public class Room extends Facility{
    private String freeService;

    public Room(String facilityID, String nameService, String typeRent, double price, double area, int maxPerson, String freeService) {
        super(facilityID, nameService, typeRent, price, area, maxPerson);
        this.freeService = freeService;
    }

    public Room() {
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room:" +super.toString()+
                " , freeService='" + freeService + '\'';
    }
}
