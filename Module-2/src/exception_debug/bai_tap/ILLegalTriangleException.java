package exception_debug.bai_tap;

import java.util.Scanner;

public class ILLegalTriangleException extends Throwable{

    public ILLegalTriangleException(String mess) {
        super(mess);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
                System.out.println("Input 3 side triangle!");
                System.out.println("Input side A: ");
                int sideA = scanner.nextInt();
                System.out.println("Input side B: ");
                int sideB = scanner.nextInt();
                System.out.println("Input side C: ");
                int sideC = scanner.nextInt();
                SideTriangle sideTriangle = new SideTriangle(sideA, sideB, sideC);
                SideTriangleTwo sideTriangleTwo = new SideTriangleTwo(sideA, sideB, sideC);
        }catch (Exception e){
            System.err.println("Exception "+e.getMessage());
        } catch (ILLegalTriangleException e) {
            System.err.println("Exception "+e.getMessage());
        }finally {
            System.out.println("Done!");
        }
    }
}
