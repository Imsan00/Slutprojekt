package GameObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Display {
    Font font;
    Color color;
    String playerName1;
    String playerName2;
    int posx;
    int scorep1;
    int scorep2;
    GraphicsContext gc;

    public Display(int f, Color c, GraphicsContext g, String n1, String n2, int x){
        font = Font.font(f);
        color = c;
        playerName1 = n1;
        playerName2 = n2;
        gc = g;
        posx = x;
        scorep1 = 0;
        scorep2 = 0;
        gc.setFill(color);
        gc.setFont(font);
    }
    public void show(){
        gc.setFill(color);
        gc.fillText(playerName1 + ": " +
                    scorep1 + "\t\t\t\t\t\t" + playerName2 + ": " +
                    scorep2, (int)posx / 2, 20);
    }
    public void setScore(int s1, int s2){
        scorep1 = s1;
        scorep2 = s2;
    }
}
