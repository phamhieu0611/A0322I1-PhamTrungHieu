package abstract_class_interface.bai_tap.resizeable;


public class Circle extends Shape implements Resizeable{
    private double radius = 2.0;

    public Circle(){}

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return (Math.pow(getRadius(),2)*Math.PI);
    }

    @Override
    public void resize(double percent){
        setRadius(getRadius()+(getRadius()*percent/100));
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + getRadius() +
                 " , Area = "+getArea()+
                " , color: "+getColor()+
                " , subclass of: "+super.toString()+
                '}';
    }
}
