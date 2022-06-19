package access_modifier_static_method_static_property.bai_tap.access_modifier;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Circle circle1 = new Circle(5.0);
        Circle circle2 = new Circle(10.0, "red");

        System.out.printf("Bán kính là: %f\n Diện tích là: %f\n",circle.getRadius(),circle.getArea());
        System.out.printf("Bán kính là: %f\n Diện tích là: %f\n",circle1.getRadius(),circle1.getArea());
        System.out.printf("Bán kính là: %f\n Diện tích là: %f\n Màu hình tròn là: %s",circle2.getRadius(),circle2.getArea(),circle2.getColor());
    }
}
