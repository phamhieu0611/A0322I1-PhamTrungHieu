package inheritance.bai_tap.point2d_point3d;

public class Test {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        point2D = new Point2D(10, 20);
        System.out.println(point2D);

        Point3D point3D = new Point3D();
        System.out.println(point3D);
        point3D = new Point3D(25);
        System.out.println(point3D);
        point3D = new Point3D(25, 35, 45);
        System.out.println(point3D);
    }
}
