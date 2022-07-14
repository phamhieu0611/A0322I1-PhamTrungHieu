package case_sudy.models;

public class Room extends Facility {
    private double priceFerRoom = 250;
    private String freeService;

    public Room(String tenDichVu, String kieuThue, double area, int maxPerson, double price, double priceFerRoom, String freeService) {
        super(tenDichVu, kieuThue, area, maxPerson, price);
        this.priceFerRoom = priceFerRoom;
        this.freeService = freeService;
    }

    public double getPriceFerRoom() {
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
    public void area(double area) {
        System.out.println("Rent room:"+
                "\nArea Room = "+area);
    }

    @Override
    public void price(double price) {
        double totalPrice = getPrice()+priceFerRoom;
        System.out.println("\nPrice Room = "+getPrice()+"$"+
                "\nTotal = "+totalPrice+"$");
    }

    @Override
    public String toString() {
        return "Room{" +super.toString()+
                "\npriceFerRoom=" + getPriceFerRoom() +
                ", freeService='" + getFreeService() + '\'' +
                '}';
    }
}
