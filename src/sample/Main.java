package sample;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {
    private static int CANVAS_X = 1000;
    private static int CANVAS_Y = 600;
    GraphicsContext gc;
    Scene scene;
    ArrayList<Shape> list = new ArrayList<>();
    private int counter = 0;


    private EventHandler<KeyEvent> keyboardListener = event -> {

        //Add circle
        if (event.getCode() == KeyCode.DIGIT1) {
            list.add(new Circle(gc));
            list.get(list.size() - 1).clear();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).draw();
            }
            counter++;
        }

        //Add square
        if (event.getCode() == KeyCode.DIGIT2) {
            list.add(new Square(gc));
            list.get(list.size() - 1).clear();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).draw();
            }
            counter++;
        }

        //Add Triangle
        if (event.getCode() == KeyCode.DIGIT3) {
            list.add(new Triangle(gc));
            list.get(list.size() - 1).clear();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).draw();
            }
            counter++;
        }

        //Switch forward between shapes and shapes group
        if (event.getCode() == KeyCode.A) {
            counter--;
            if (counter < 0) {
                counter = 0;
            }

        }
        //Switch backward between shapes and shapes group
        if (event.getCode() == KeyCode.D) {
            counter++;
            if (counter > list.size() - 1) {
                counter = list.size() - 1;
            }
        }


        switch (event.getCode()) {
            case UP:
                list.get(counter).moveUp();
                break;
            case DOWN:
                list.get(counter).moveDown();
                break;
            case RIGHT:
                list.get(counter).moveRight();
                break;
            case LEFT:
                list.get(counter).moveLeft();
                break;
        }
        list.get(list.size() - 1).clear();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).draw();
        }
    };


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("-=Shapes=-");
        BorderPane group = new BorderPane();
        Canvas canvas = new Canvas(CANVAS_X, CANVAS_Y);
        scene = new Scene(group);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setScene(scene);
        group.setCenter(canvas);
        primaryStage.show();
        setOnKeyPressed();


    }

    public void setOnKeyPressed() {
        scene.setOnKeyPressed(keyboardListener);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
