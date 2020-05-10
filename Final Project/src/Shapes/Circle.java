package Shapes;

public class Circle {
    private double radius;
    //Default constructor
    public Circle(){
        radius = 0;
    }
    //Constructor with value
    public Circle(double r){
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
