package abstract_class_interface.bai_tap.colorable;

public class Shape implements Colorable {
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

    @Override
    public void howToColor() {

    }
}
