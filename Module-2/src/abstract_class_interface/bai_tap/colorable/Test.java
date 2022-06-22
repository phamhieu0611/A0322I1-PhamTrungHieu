package abstract_class_interface.bai_tap.colorable;

public class Test {
    public static void main(String[] args) {
        Shape shapes[] = new Shape[6];
        shapes[0] = new Retangle(5, 7);
        shapes[1] = new Retangle("Blue",10,12);
        shapes[2] = new Circle(6.5);
        shapes[3] = new Circle("Red",10.5);
        shapes[4] = new Square(10.5);
        shapes[5] = new Square("Black",15.25);

        Colorable colorable = new Square();

        for (Shape shape : shapes){
            System.out.println(shape.toString());
            if (shape instanceof Square){
                colorable = new Square();
                colorable.howToColor();
            }else if (shape instanceof  Circle){
                colorable = new Circle();
                colorable.howToColor();
            }else if (shape instanceof Retangle){
                colorable = new Retangle();
                colorable.howToColor();
            }
            System.out.println("\n");
        }
    }
}
