package inheritance.bai_tap.point2d_point3d;

import java.util.Arrays;

public class Point2D {
    private float x;
    private float y;

    public Point2D(){}

    public Point2D(float x, float y){
        this.x =x;
        this.y =y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float X, float Y){
        this.x = X;
        this.y = Y;
    }
    public float[] getXY(){
        float[] arr = {getX(),getY()};
        return arr;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + getX() +
                ", y=" + getY() +
                " , array = "+ Arrays.toString(getXY())+
                '}';
    }
}
