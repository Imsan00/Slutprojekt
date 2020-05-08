package Shapes;

public class Rectangle {
    private double side1;
    private double side2;
    //Default constructor
    Rectangle(){
        side1 = 0.0;
        side2 = 0.0;
    }
    //Constructor with value
    Rectangle(double s1, double s2){
        side1 = s1;
        side2 = s2;
    }
    public void setSide1(double s){
        side1 = s;
    }
    public void setSide2(double s){
        side2 = s;
    }
    public double getSide1(){
        return side1;
    }
    public double getSide2(){
        return side2;
    }
    public double Area(){
        return side1 * side2;
    }
    public double Primeter(){
        return (side1 + side2) * 2;
    }
}

