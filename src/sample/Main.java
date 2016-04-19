package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

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

        //Add oval
        if (event.getCode() == KeyCode.DIGIT4) {
            list.add(new Oval(gc));
            list.get(list.size() - 1).clear();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).draw();
            }
            counter++;
        }

        //Add rectangle
        if (event.getCode() == KeyCode.DIGIT5) {
            list.add(new Rectangle(gc));
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
        //Random add shapes
        if (event.getCode() == KeyCode.R) {
            int randShape = new Random().nextInt(5) + 1;
            switch (randShape) {
                case 1:
                    list.add(new Circle(gc));
                    list.get(list.size() - 1).clear();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    counter++;
                    break;
                case 2:
                    list.add(new Square(gc));
                    list.get(list.size() - 1).clear();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    counter++;
                    break;
                case 3:
                    list.add(new Triangle(gc));
                    list.get(list.size() - 1).clear();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    counter++;
                    break;
                case 4:
                    list.add(new Oval(gc));
                    list.get(list.size() - 1).clear();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    counter++;
                    break;
                case 5:
                    list.add(new Rectangle(gc));
                    list.get(list.size() - 1).clear();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    counter++;
                    break;
            }

        }


        switch (event.getCode()) {
            case UP:
                list.get(counter - 1).moveUp();
                break;
            case DOWN:
                list.get(counter - 1).moveDown();
                break;
            case RIGHT:
                list.get(counter - 1).moveRight();
                break;
            case LEFT:
                list.get(counter - 1).moveLeft();
                break;
        }
        list.get(list.size() - 1).clear();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).draw();
        }

        //Help
        if (event.getCode() == KeyCode.H) {

        }

        //Clear canvas
        if (event.getCode() == KeyCode.C) {
            list.clear();
            gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

        }
    };


    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("-=Shapes=-");
        BorderPane group = new BorderPane();
        Canvas canvas = new Canvas(CANVAS_X, CANVAS_Y);
        GridPane grid = createGrid();
        addButton(grid);
        grid.add(group, 1, 1);
        scene = new Scene(grid);
        //scene = new Scene(group);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setScene(scene);
        group.setCenter(canvas);
        primaryStage.show();
        setOnKeyPressed();

    }

    private void addButton(GridPane grid) {
        Button buttonClearCanvas = new Button("Clear canvas");
        Button buttonHelp = new Button("Help");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(buttonClearCanvas);
        hbBtn.getChildren().add(buttonHelp);
        grid.add(hbBtn, 1, 4);

        buttonClearCanvas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Event -->" + event.toString());
                list.clear();
                gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
            }
        });

        buttonHelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Event -->" + event.toString());
                HelpFrame help =new HelpFrame();
            }
        });


    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(15, 15, 15, 15));
        return grid;
    }

    public void setOnKeyPressed() {
        scene.setOnKeyPressed(keyboardListener);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
