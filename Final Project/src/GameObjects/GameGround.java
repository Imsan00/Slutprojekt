package GameObjects;

import Shapes.Rectangle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;



public class GameGround extends Rectangle {
    private Color bgColor;
    private Canvas canvas;
    private GraphicsContext gc;

    public GameGround(){
        super();
        bgColor = javafx.scene.paint.Color.BLACK;
    }

    public GameGround(Color c, int l, int w){
        bgColor = c;
        setLength(l);
        setWidth(w);
        canvas = new Canvas(getWidth(), getLength());
        gc = canvas.getGraphicsContext2D();
    }

    public void draw(){
        gc.setFill(bgColor);
        gc.fillRect(0, 0, getWidth(), getLength());
        gc.setStroke(Color.WHITE);
        //gc.setTextAlign(TextAlignment.CENTER);
        //gc.strokeText("Click", getWidth() / 2, getLength() / 2);
    }
    public GraphicsContext getGc(){
        return gc;
    }
    public Canvas getCanvas(){
        return canvas;
    }
}
