package newCaseStudy.model.facility;

public class Room extends Facility{
    private String freeService;

    public Room(String nameService, String typeRent, double price, double area, int maxPerson, String freeService) {
        super(nameService, typeRent, price, area, maxPerson);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +super.toString()+'\''+
                "freeService='" + freeService + '\'' +
                '}';
    }
}
