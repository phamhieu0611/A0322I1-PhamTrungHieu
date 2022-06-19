package inheritance.bai_tap.point_moveablepoint;

public class Test {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        point = new Point(10, 20);
        System.out.println(point);

        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(25,35, 45, 55);
        System.out.println(moveablePoint);
        moveablePoint.move();
        System.out.println(moveablePoint);
    }
}
