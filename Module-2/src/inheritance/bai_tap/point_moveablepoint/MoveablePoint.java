package inheritance.bai_tap.point_moveablepoint;

import java.util.Arrays;

public class MoveablePoint extends Point {
    private float xSpeed;
    private float ySpeed;

    public MoveablePoint(){}

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        setxSpeed(xSpeed);
        setySpeed(ySpeed);
    }

    public float[] getSpeed(){
        float [] arr = {getxSpeed(),getySpeed()};
        return arr;
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "x = "+getX()+
                " y = "+getY()+
                " , xSpeed=" + getxSpeed() +
                ", ySpeed=" + getySpeed() +
                " , array = "+ Arrays.toString(getSpeed())+
                " which is subclass of: "+super.toString()+
                '}';
    }

    public void move(){
        setX(getX()+getxSpeed());
        setY(getY()+getySpeed());
    }
}
