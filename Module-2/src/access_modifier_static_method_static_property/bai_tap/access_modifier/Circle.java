package access_modifier_static_method_static_property.bai_tap.access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    Circle(){}

    Circle(double r){
        this.radius = r;
    }

    Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }
    public double getRadius() {
        return this.radius;
    }
    public double getArea(){
        return Math.pow(this.radius,2)*Math.PI;
    }
    public String getColor() {
        return color;
    }
}
