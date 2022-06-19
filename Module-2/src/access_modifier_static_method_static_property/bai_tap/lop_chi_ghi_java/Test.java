package access_modifier_static_method_static_property.bai_tap.lop_chi_ghi_java;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setClasses("18IT3");
        student.setName("Wayne");
        System.out.printf("Họ và tên: %s\nLớp: %s", student.getName(), student.getClasses());
    }
}
