package abstract_class_interface.bai_tap.colorable;


public class Retangle extends Shape implements Colorable {
    private double width = 5.0;
    private double height = 10.0;

    public Retangle(){}

    public Retangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Retangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea(){
        return getHeight()*getWidth();
    }

    @Override
    public String toString() {
        return "Retangle{" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                " , Area = "+getArea()+
                " , color: "+getColor()+
                " , subclass of: "+super.toString()+
                '}';
    }

    @Override
    public void howToColor() {
        System.out.println("Color width and height.");
    }
}
