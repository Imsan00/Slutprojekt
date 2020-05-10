package GameObjects;

import Shapes.Rectangle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import java.awt.*;

public class PlayerRacket extends Rectangle {
    private GraphicsContext gc;
    private Color color;
    private double position_x;
    private double position_y;
    private double speed;

    public PlayerRacket(){
        super();
        color = Color.WHITE;
        position_x = 0;
        position_y = 0;
        speed = 0.0;
    }
    public PlayerRacket(GraphicsContext g, Color c, int w, int l, double posx, double posy){
        gc = g;
        color = c;
        setWidth(w);
        setLength(l);
        position_x = posx;
        position_y = posy;
        speed = 0.0;
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
        int width = getWidth();
        int length = getLength();
        gc.setFill(color);
        gc.fillRect(position_x, position_y, width, length);
    }
    public void move(int x, int y){
        position_x = x;
        position_y = y;
        draw();
    }
}
