package inheritance.bai_tap.circle_cynlinder;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(5.0, "black");
        System.out.println(circle);

        Cynlinder cynlinder = new Cynlinder();
        System.out.println(cynlinder);
        cynlinder = new Cynlinder(10.0);
        System.out.println(cynlinder);
        cynlinder = new Cynlinder(5.0, "green", 15.0);
        System.out.println(cynlinder);
    }
}
