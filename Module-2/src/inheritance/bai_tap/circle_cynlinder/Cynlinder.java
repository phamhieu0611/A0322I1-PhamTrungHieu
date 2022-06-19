package inheritance.bai_tap.circle_cynlinder;

public class Cynlinder extends Circle {
    private double height = 5.0;

    public Cynlinder(){}

    public Cynlinder(double height) {
        this.height = height;
    }

    public Cynlinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return getArea()*getHeight();
    }

    @Override
    public String toString() {
        return "Cynlinder{" +
                "height=" + getHeight() +
                " , volume"+getVolume()+
                " which is subclass of: "+super.toString()+
                '}';
    }
}
