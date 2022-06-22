package inheritance.bai_tap.triangle;

public class Test {
    public static void main(String[] args) {
        Triagle triagle = new Triagle();
        System.out.println(triagle);
        triagle = new Triagle(5.0, 6.0, 7.0);
        System.out.println(triagle);
        triagle = new Triagle("black", 10.0, 15.0, 20.0);
        System.out.println(triagle);
    }
}
