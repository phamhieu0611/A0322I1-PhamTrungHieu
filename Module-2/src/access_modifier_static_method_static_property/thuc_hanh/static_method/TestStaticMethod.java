package access_modifier_static_method_static_property.thuc_hanh.static_method;

public class TestStaticMethod {
    public static void main(String[] args) {
        StaticMethod.change();

        StaticMethod s1 = new StaticMethod(111, "HOANG");
        StaticMethod s2 = new StaticMethod(222, "THUY");
        StaticMethod s3 = new StaticMethod(333, "LINH");

        s1.display();
        s2.display();
        s3.display();
    }
}
