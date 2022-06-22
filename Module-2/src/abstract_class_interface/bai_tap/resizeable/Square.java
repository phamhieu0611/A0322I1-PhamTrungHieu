package abstract_class_interface.bai_tap.resizeable;

public class Square extends Shape implements Resizeable{
    private double side = 1.0;

    public Square(){}

    public Square(double side) {
        this.side = side;
    }

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea(){
        return getSide()*getSide();
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + getSide() +
                " , Area: " + getArea()+
                " , color: "+getColor()+
                " , subclass of: "+super.toString()+
                '}';
    }

    @Override
    public void resize(double percent) {
        setSide(getSide()+(getSide()*percent/100));
    }
}
