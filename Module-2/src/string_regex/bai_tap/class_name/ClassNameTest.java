package string_regex.bai_tap.class_name;

public class ClassNameTest {
    public static ClassName className;
    public static final String[] validClassName = new String[] { "C0318G", "A0318G", "P0323M"};
    public static final String[] invalidClassName = new String[] { "C0318A", "M0318G", "P0323A"};

    public static void main(String[] args) {
        className = new ClassName();
        for (String nameClass : validClassName){
            boolean isvalid = className.validate(nameClass);
            System.out.println("Class name is "+nameClass+" is valid: "+isvalid);
        }
        for (String nameClass : invalidClassName){
            boolean isvalid = className.validate(nameClass);
            System.out.println("Class name is "+nameClass+" is valid: "+isvalid);
        }
    }
}
