package GameObjects;
import Shapes.*;
import javafx.scene.canvas.GraphicsContext;
import java.awt.*;
import javafx.scene.paint.Color;
public class Ball extends Circle{
    GraphicsContext gc;
    Color color;
    double position_x;
    double position_y;
    double speed;
    //Default constructor
    public Ball(){
        super();
        color = Color.RED;
        position_x = 0;
        position_y = 0;
        speed = 0.0;
    }
    //Constructor with value
    public Ball(GraphicsContext g, double r, Color c, double p_x, double p_y){
        setRadius(r);
        gc = g;
        color = c;
        position_x = p_x;
        position_y = p_y;
        speed = 0;
    }
    public void setColor(Color c){
        color = c;
    }
    public void setPosition_x(double x){
        position_x = x;
    }
    public void setPosition_y(double y){
        position_y = y;
    }
    public void setSpeed(double s){
        speed = s;
    }
    public Color getColor(){
        return color;
    }
    public double getPosition_x(){
        return position_x;
    }
    public double getPosition_y(){
        return position_y;
    }
    public double getSpeed(){
        return speed;
    }

    public void draw(){
        double radius = getRadius();
        gc.setFill(color);
        gc.fillOval(position_x, position_y, radius, radius);
        //gc.drawOval(position_x - radius, position_y - radius, 2 * radius, 2 * radius);
    }

    public void move(int x, int y){
        position_x = x;
        position_y = y;
        draw();
    }
}
