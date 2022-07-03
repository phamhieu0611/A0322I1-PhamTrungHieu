package case_sudy.controllers.task2.theHouse;

public class Room extends Facility {
    private int priceFerRoom = 250;
    private String freeService;

    public Room(String tenDichVu, String kieuThue, int area, int maxPerson, int price, int priceFerRoom, String freeService) {
        super(tenDichVu, kieuThue, area, maxPerson, price);
        this.priceFerRoom = priceFerRoom;
        this.freeService = freeService;
    }

    public int getPriceFerRoom() {
        return priceFerRoom;
    }

    public void setPriceFerRoom(int priceFerRoom) {
        this.priceFerRoom = priceFerRoom;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public void area(int area) {
        System.out.println("Rent room:"+
                "\nArea Room = "+area);
    }

    @Override
    public void price(int price) {
        int totalPrice = getPrice()+priceFerRoom;
        System.out.println("\nPrice Room = "+getPrice()+"$"+
                "\nTotal = "+totalPrice+"$");
    }

    @Override
    public String toString() {
        return "Room{" +
                "priceFerRoom=" + getPriceFerRoom() +
                ", freeService='" + getFreeService() + '\'' +
                '}';
    }
}
