package clean_code_refactoring.thuc_hanh.method;

public class Cylinder {
    private static double getP(int radius){
        return 2*Math.PI*radius;
    }
    private static double getBaseArea(int radius){
        return Math.PI*radius*radius;
    }
    public static double getVolume(int radius, int height){
        double baseArea = getBaseArea(radius);
        double perimeter = getP(radius);
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }
}
