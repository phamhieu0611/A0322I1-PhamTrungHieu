package abstract_class_interface.bai_tap.resizeable;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Shape shapes[] = new Shape[6];
        shapes[0] = new Retangle(5, 7);
        shapes[1] = new Retangle("Blue",10,12);
        shapes[2] = new Circle(6.5);
        shapes[3] = new Circle("Red",10.5);
        shapes[4] = new Square(10.5);
        shapes[5] = new Square("Black",15.25);

        Random random = new Random();

        for (Shape shape : shapes){
            System.out.println(shape.toString());
            double randomNumber = random.nextDouble()*100.0+1;
            System.out.println("Persent : "+randomNumber);
            shape.resize(randomNumber);
            System.out.println("Ater resize "+randomNumber+"%");
            System.out.println(shape.toString());
            System.out.println("\n");
        }
    }
}
