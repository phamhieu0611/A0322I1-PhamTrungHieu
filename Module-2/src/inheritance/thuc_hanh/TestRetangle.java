package inheritance.thuc_hanh;

public class TestRetangle {
    public static void main(String[] args) {
        Retangle retangle = new Retangle();
        System.out.println(retangle);
        retangle = new Retangle(2.3,5.8);
        System.out.println(retangle);
        retangle = new Retangle(2.3,5.8, "orange", true);
        System.out.println(retangle);
    }
}
