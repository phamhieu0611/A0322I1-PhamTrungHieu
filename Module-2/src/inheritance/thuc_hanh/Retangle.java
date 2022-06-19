package inheritance.thuc_hanh;

public class Retangle extends Shape{
    private double width = 1.0;
    private double height = 1.0;
    public Retangle(){}
    public Retangle(double width, double height){
        this.height = height;
        this.width = width;
    }
    public Retangle(double width, double height, String color, boolean filled){
        super(color, filled);
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
        return width*this.height;
    }
    public double getPerimeter(){
        return 2*(width+this.height);
    }

    @Override
    public String toString() {
        return "Retangle{" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                ", Which is subclass of: "+
                super.toString()+
                '}';
    }
}
