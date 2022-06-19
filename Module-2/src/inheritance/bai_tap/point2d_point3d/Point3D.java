package inheritance.bai_tap.point2d_point3d;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z;

    public Point3D(){}

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float X, float Y, float Z){
        setXY(X,Y);
        this.z = Z;
    }
    public float[] getXYZ(){
        float [] arr = {getX(),getY(),getZ()};
        return arr;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "z=" + getZ() +
                " , array = "+ Arrays.toString(getXYZ()) +
                " which is subclass of: "+super.toString()+
                '}';
    }
}
