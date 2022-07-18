package exception_debug.thuc_hanh;

import java.util.Scanner;

public class CaculationEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input X: ");
        int x = scanner.nextInt();
        System.out.println("Input Y: ");
        int y = scanner.nextInt();
        CaculationEx calc = new CaculationEx();
        calc.caculate(x, y);
    }

    public void caculate(int x, int y){
        try {
            int a = x+y;
            System.out.println("x + y = "+a);
            int b = x*y;
            System.out.println("x * y = "+b);
            int c = x-y;
            System.out.println("x - y = "+c);
            int d = x/y;
            System.out.println("x / y = "+d);
        }catch (Exception e){
            System.err.println("Excrption: "+e.getMessage());
        }finally {
            System.out.println("Ignore!");
        }
    }
}
