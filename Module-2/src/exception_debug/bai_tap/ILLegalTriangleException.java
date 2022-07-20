package exception_debug.bai_tap;

import java.util.Scanner;

public class ILLegalTriangleException extends Throwable{

    public ILLegalTriangleException(String mess) {
        super(mess);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("Input 3 side triangle!");
                System.out.print("Input side A: ");
                int sideA = Integer.parseInt(scanner.nextLine());
                System.out.print("Input side B: ");
                int sideB = Integer.parseInt(scanner.nextLine());
                System.out.print("Input side C: ");
                int sideC = Integer.parseInt(scanner.nextLine());
                SideTriangle sideTriangle = new SideTriangle(sideA, sideB, sideC);
            }catch (ILLegalTriangleException e2) {
                System.err.println("Exception "+e2.getMessage()+" try again!");
            }catch (Exception e){
                System.err.println("Exception "+e.getMessage()+" try again!");
            } finally {
                System.out.println("Done!");
            }
        }while (true);
    }
}
