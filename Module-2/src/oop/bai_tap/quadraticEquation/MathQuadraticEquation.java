package oop.bai_tap.quadraticEquation;

import java.util.Scanner;

public class MathQuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        QuadraticEquation quadraticEquation = new QuadraticEquation();
//        System.out.print("Nhập vào giá trị a: ");
//        quadraticEquation. a = scanner.nextDouble();
//        System.out.print("Nhập vào giá trị b: ");
//        quadraticEquation.b = scanner.nextDouble();
//        System.out.print("Nhập vào giá trị c: ");
//        quadraticEquation.c = scanner.nextDouble();

        System.out.print("Nhập vào giá trị a: ");
        double a = scanner.nextDouble();
        System.out.print("Nhập vào giá trị b: ");
        double b = scanner.nextDouble();
        System.out.print("Nhập vào giá trị c: ");
        double c = scanner.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (a == 0){
            if (b == 0){
                System.out.println("Phương trình vô nghiệm!");
            }else {
                System.out.println("Phương trình có 1 nghiệm duy nhất: "+quadraticEquation.getRoot());
            }
        }else {
            if (quadraticEquation.getDiscriminant() < 0){
                System.out.println("Phương trình vô nghiệm!");
            }else {
                if (quadraticEquation.getDiscriminant() != 0){
                    System.out.printf("Phương trình có 2 nghiệm:\n Nghiệm 1: %f\n Nghiệm 2: %f",quadraticEquation.getRoot1(),quadraticEquation.getRoot2());
                }else{
                    System.out.println("Phương trình có nghiệm kép: "+quadraticEquation.getRooot3());
                }
            }
        }
    }
}
