package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    private static int CANVAS_X = 1000;
    private static int CANVAS_Y = 600;
    GraphicsContext gc;
    Scene scene;
    private int size = 50;
    private double x = 5;
    private double y = 5;


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello world");
        BorderPane group = new BorderPane();
        Canvas canvas = new Canvas(CANVAS_X, CANVAS_Y);
        scene = new Scene(group);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setScene(scene);
        group.setCenter(canvas);
        primaryStage.show();

        Circle circle = new Circle(gc);
        circle.draw();

        EventHandler<KeyEvent> keybordListener = event -> {

            switch (event.getCode()) {
                case UP:
                    circle.moveUp();
                    break;
                case DOWN:
                    circle.moveDown();
                    break;
                case RIGHT:
                    circle.moveRight();
                    break;
                case LEFT:
                    circle.moveLeft();
                    break;
            }
        };


    }
private void setOnKeyPressed(Key)




    public static void main(String[] args) {
        launch(args);
    }
}
