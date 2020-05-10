import GameObjects.Ball;

import java.util.Random;
import java.util.Scanner;

import GameObjects.Display;
import GameObjects.GameGround;
import GameObjects.PlayerRacket;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.TextAlignment;

public class PongGame extends Application{
    private static final int width = 800;
    private static final int height = 600;
    private static final int PLAYER_HEIGHT = 100;
    private static final int PLAYER_WIDTH = 15;
    private static final double BALL_R = 20;
    private int ballYSpeed = 1;
    private int ballXSpeed = 1;
    private double playerOneYPos = height / 2;
    private double playerTwoYPos = height / 2;
    private double ballXPos = width / 2;
    private double ballYPos = height / 2;
    private int scoreP1 = 0;
    private int scoreP2 = 0;

    private boolean gameStarted;

    private int playerOneXPos = 0;
    private double playerTwoXPos = width - PLAYER_WIDTH;
    private Canvas canvas;
    private GameGround gg;
    private Ball ball;
    private PlayerRacket playerRacket1;
    private PlayerRacket playerRacket2;
    private Display d;

    String playername;
    public void start(Stage stage) throws Exception {
        stage.setTitle("Pong Game");

        // Get player name from terminal
        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        playername = scanner.nextLine();

        // Create game ground
        gg = new GameGround(Color.BLACK, height , width);
        GraphicsContext gc = gg.getGc();
        canvas = gg.getCanvas();

        // Create ball
        ball = new Ball(gc, BALL_R, Color.RED, width/2, height/2);

        // Create player racket 1 that uses by a human
        playerRacket1 = new PlayerRacket(gc, Color.WHITE, PLAYER_WIDTH, PLAYER_HEIGHT, playerOneXPos, playerOneYPos);

        // Create player racket 2 that uses by the computer
        playerRacket2 = new PlayerRacket(gc, Color.WHITE, PLAYER_WIDTH, PLAYER_HEIGHT, playerTwoXPos, playerTwoYPos);


        //JavaFX Timeline = free form animation defined by KeyFrames and their duration
        Timeline tl = new Timeline(new KeyFrame(Duration.millis(10), e -> run(gc)));

        //number of cycles in animation INDEFINITE = repeat indefinitely
        tl.setCycleCount(Timeline.INDEFINITE);

        //mouse control (move and click)
        canvas.setOnMouseMoved(e ->  playerRacket1.setPosition_y(e.getY()));
        canvas.setOnMouseClicked(e ->  gameStarted = true);
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        tl.play();
    }

    private void run(GraphicsContext gc) {

        //draw game ground
        gg.draw();
        //set text
        d = new Display(25, Color.WHITE, gc, playername, "Pc", width / 2);

        if(gameStarted) {
            //set ball movement
            ball.setPosition_x(ball.getPosition_x() + ballXSpeed);
            ball.setPosition_y(ball.getPosition_y() + ballYSpeed);

            if(ball.getPosition_x() < width - width  / 4) {
                    playerRacket2.setPosition_y(ball.getPosition_y() - PLAYER_HEIGHT / 2);
            }
            else {
                if(ball.getPosition_y() > (playerRacket2.getPosition_y() + PLAYER_HEIGHT / 2) ){
                    playerRacket2.setPosition_y(playerRacket2.getPosition_y() + 1);
                }
                else{
                    playerRacket2.setPosition_y(playerRacket2.getPosition_y() - 1);
                }
            }

            //draw the ball
            ball.draw();

        } else {

            //reset the ball start position
            ball.setPosition_x(width/2);
            ball.setPosition_y(height/2);

            //reset the ball speed and the direction
            ballXSpeed = new Random().nextInt(2) == 0 ? 1: -1;
            ballYSpeed = new Random().nextInt(2) == 0 ? 1: -1;
        }

        //makes sure the ball stays in the canvas
        if(ball.getPosition_y() > height || ball.getPosition_y() < 0) ballYSpeed *=-1;

        //if you miss the ball, computer gets a point
        if(ball.getPosition_x() < playerRacket1.getPosition_x() - PLAYER_WIDTH) {
            scoreP2++;
            gameStarted = false;
        }

        //if the computer misses the ball, you get a point
        if(ball.getPosition_x() > playerRacket2.getPosition_x() + PLAYER_WIDTH) {
            scoreP1++;
            gameStarted = false;
        }

        //increase the speed after the ball hits the player
        if( ((ball.getPosition_x() + BALL_R > playerRacket2.getPosition_x()) && ball.getPosition_y() >=
                playerRacket2.getPosition_y() && ball.getPosition_y() <= playerRacket2.getPosition_y() + PLAYER_HEIGHT) ||
                ((ball.getPosition_x() < playerRacket1.getPosition_x() + PLAYER_WIDTH) && ball.getPosition_y() >=
                        playerRacket1.getPosition_y() && ball.getPosition_y() <= playerRacket1.getPosition_y() + PLAYER_HEIGHT)) {

            ballYSpeed += 1 * Math.signum(ballYSpeed);
            ballXSpeed += 1 * Math.signum(ballXSpeed);
            ballXSpeed *= -1;
            ballYSpeed *= -1;
        }


        // draw score
        d.setScore(scoreP1, scoreP2);
        d.show();

        // draw player 1 & 2
        playerRacket1.draw();
        playerRacket2.draw();

        if(scoreP1 == 5|| scoreP2 == 5){
            gc.setTextAlign(TextAlignment.CENTER);
            gc.strokeText("Game Over", canvas.getWidth() / 2, canvas.getHeight() / 2);
            d.show();
        }
    }

    // start the application
    public static void main(String[] args) {
        launch(args);
    }
}
