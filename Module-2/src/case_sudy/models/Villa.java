package case_sudy.models;

public class Villa extends Facility {
    private String roomStandard;
    private double areaPool;
    private int floor;
    private double pricePerVilla = 1000;

    public Villa(String tenDichVu, String kieuThue, double area, int maxPerson, double price, String roomStandard, double areaPool, int floor, double pricePerVilla) {
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

    public double getAreaPool() {
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

    public double getPricePerVilla() {
        return pricePerVilla;
    }

    public void setPricePerVilla(int pricePerVilla) {
        this.pricePerVilla = pricePerVilla;
    }

    @Override
    public void area(double area) {
        System.out.println("\nRent villa:"+
                "\nArea Villa = "+getArea());
    }

    @Override
    public void price(double price) {
        double totalPriceVilla = getPrice()+(pricePerVilla*floor);
        System.out.println("\nFlorr = "+floor+
                "\nPrice Room = "+getPrice()+"$"+
                "\nTotal = "+totalPriceVilla+"$");
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
