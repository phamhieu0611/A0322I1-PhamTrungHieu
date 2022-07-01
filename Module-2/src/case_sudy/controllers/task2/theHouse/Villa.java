package case_sudy.controllers.task2.theHouse;

public class Villa extends Facility {
    private String roomStandard;
    private int areaPool;
    private int floor;
    private int pricePerVilla = 1000;

    public Villa(String tenDichVu, String kieuThue, int area, int maxPerson, int price, String roomStandard, int areaPool, int floor, int pricePerVilla) {
        super(tenDichVu, kieuThue, area, maxPerson, price);
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

    public int getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(int areaPool) {
        this.areaPool = areaPool;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getPricePerVilla() {
        return pricePerVilla;
    }

    public void setPricePerVilla(int pricePerVilla) {
        this.pricePerVilla = pricePerVilla;
    }

    @Override
    public void area(int area) {
        System.out.println("\nRent villa:"+
                "\nArea Villa = "+getArea());
    }

    @Override
    public void price(int price) {
        int totalPriceVilla = getPrice()+(pricePerVilla*floor);
        System.out.println("\nFlorr = "+floor+
                "\nPrice Room = "+getPrice()+"$"+
                "\nTotal = "+totalPriceVilla+"$");
    }
}
