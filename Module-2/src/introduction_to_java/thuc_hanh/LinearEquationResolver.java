package introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter the contants: ");
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Nhập a: ");
        double a = scanner.nextDouble();
        System.out.printf("Nhập b: ");
        double b = scanner.nextDouble();
        System.out.printf("Nhập c: ");
        double c = scanner.nextDouble();
        if (a != 0){
            double answer = (c - b)/a;
            System.out.printf("Equation pass with x = %f! \n", answer);
        }else {
            if (b == c){
                System.out.print("The soluton is all x!");
            }else {
                System.out.print("No solution!");
            }
        }
    }
}
