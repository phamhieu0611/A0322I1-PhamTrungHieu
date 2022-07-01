package case_sudy.controllers.task2.theHouse;

import java.util.Scanner;

public class House extends Facility {
    private String roomStandard;
    private int pricePerHouse = 500;
    private int floor;

    public House(String tenDichVu, String kieuThue, int area, int maxPerson, int price, String roomStandard, int pricePerHouse, int floor) {
        super(tenDichVu, kieuThue, area, maxPerson, price);
        this.roomStandard = roomStandard;
        this.pricePerHouse = pricePerHouse;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getPricePerHouse() {
        return pricePerHouse;
    }

    public void setPricePerHouse(int pricePerHouse) {
        this.pricePerHouse = pricePerHouse;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public void area(int area) {
        System.out.println("\nRent house:"+
                "\nArea House = "+getArea());
    }


    @Override
    public void price(int price) {
        int totalPriceHouse = getPrice()+(pricePerHouse*floor);
        System.out.println("\nFlorr = "+floor+
                "\nPrice Room = "+getPrice()+"$"+
                "\nTotal = "+totalPriceHouse+"$");
    }
}
