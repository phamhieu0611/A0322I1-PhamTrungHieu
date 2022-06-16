package oop.bai_tap.quadraticEquation;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(){

    }
    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant(){
        return (Math.pow(this.b, 2) - 4 * this.a * this.c);
    }
    public double getRoot(){
        return -this.c / this.b;
    }
    public double getRoot1(){
        return (-this.b+Math.sqrt(getDiscriminant())) / (2*this.a);
    }
    public double getRoot2(){
        return (-this.b - Math.sqrt(getDiscriminant())) / (2*this.a);
    }
    public double getRooot3(){
        return - this.b / (2*this.a);
    }

}
