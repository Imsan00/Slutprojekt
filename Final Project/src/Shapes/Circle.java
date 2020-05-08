package Shapes;

public class Circle {
    private double radius;
    Circle(){
        radius = 0.0;
    }
    Circle(double r){
        radius = r;
    }
    public double Area(){
        return Math.PI * radius * radius;
    }
    public void setRadius(double r){
        radius = r;
    }
    public double getRadius(){
        return radius;
    }
}
