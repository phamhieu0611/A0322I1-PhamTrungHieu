package oop.bai_tap.fan;

public class Fan {
    private final int slow = 1;
    private final int medium = 2;
    private final int fast = 3;
    private int speed;
    private boolean status;
    private double radius;
    private String color;

    public Fan(int speed, boolean status, double radius, String color) {
        this.speed = speed;
        this.status = status;
        this.radius = radius;
        this.color = color;
    }
     public Fan(){
         this.speed = slow;
         this.status = false;
         this.radius = 5;
         this.color = "blue";
     }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public String toString(){
        String powerFan = null;
        switch (getSpeed()){
            case 1:
                powerFan = "Low";
                break;
            case 2:
                powerFan = "Medium";
                break;
            case 3:
                powerFan = "Fast";
                break;
        }if (isStatus()){
            return "Quạt đang bật."+ "\nQuạt đang ở mức "+powerFan+" tầm : "+getRadius()+" Màu: "+getColor();
        }else {
            return "Quạt tắt.\n"+"Tầm quạt: "+getRadius()+" Màu: "+getColor();
        }
    }
}
