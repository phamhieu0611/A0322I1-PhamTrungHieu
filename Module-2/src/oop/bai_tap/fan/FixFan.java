package oop.bai_tap.fan;

public class FixFan {
    public static void main(String[] args) {
        Fan fan1 = new Fan(3,true, 10, "Yellow");
        Fan fan2 = new Fan(2, false, 5, "red");

        System.out.println("Tình trạng quạt 1: "+fan1);
        System.out.println("Tình trạng quạt 2: "+fan2);
    }
}
