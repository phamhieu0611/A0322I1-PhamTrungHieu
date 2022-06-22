package inheritance.bai_tap.triangle;

public class Shape {
    private String color;

     public Shape(){
         this.color = "no color";
     }

     public Shape(String color){
         this.color = color;
     }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + getColor() + '\'' +
                '}';
    }
}
