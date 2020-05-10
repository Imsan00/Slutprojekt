package Shapes;

public class Rectangle {
    private int width;
    private int length;
    //Default constructor
    public Rectangle(){
        width = 0;
        length = 0;
    }
    //Constructor with value
    public Rectangle(int w, int l){
        width = w;
        length = l;
    }
    public void setWidth(int w){
        width = w;
    }
    public void setLength(int l){
        length = l;
    }
    public int getWidth(){
        return width;
    }
    public int getLength(){
        return length;
    }
    public int Area(){
        return width * length;
    }
    public int Primeter(){
        return (width + length) * 2;
    }
}

