package oop.thuc_hanh.retangle;

import java.util.Scanner;

public class RetangleMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the width: ");
        double width = scanner.nextDouble();
        System.out.print("Enter the height: ");
        double height = scanner.nextDouble();

        Retangle retangle = new Retangle(width, height);

        System.out.println("Your Retangle \n"+retangle.display());
        System.out.println("Perimeter of the Retangle: "+retangle.getPerimeter());
        System.out.println("Area of the Retangle: "+retangle.getArea());
    }
}
