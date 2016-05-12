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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
            drawAllShapesAfterAnyAction();
            counter++;
        }

        //Add square
        if (event.getCode() == KeyCode.DIGIT2) {
            list.add(new Square(gc));
            drawAllShapesAfterAnyAction();
            counter++;
        }

        //Add Triangle
        if (event.getCode() == KeyCode.DIGIT3) {
            list.add(new Triangle(gc));
            drawAllShapesAfterAnyAction();
            counter++;
        }

        //Add oval
        if (event.getCode() == KeyCode.DIGIT4) {
            list.add(new Oval(gc));
            drawAllShapesAfterAnyAction();
            counter++;
        }

        //Add rectangle
        if (event.getCode() == KeyCode.DIGIT5) {
            list.add(new Rectangle(gc));
            drawAllShapesAfterAnyAction();
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
                    list.get(counter).clear();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    counter++;
                    break;
                case 2:
                    list.add(new Square(gc));
                    list.get(counter).clear();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    counter++;
                    break;
                case 3:
                    list.add(new Triangle(gc));
                    list.get(counter).clear();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    counter++;
                    break;
                case 4:
                    list.add(new Oval(gc));
                    list.get(counter).clear();
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).draw();
                    }
                    counter++;
                    break;
                case 5:
                    list.add(new Rectangle(gc));
                    list.get(counter).clear();
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
        if (event.getCode() == KeyCode.F1) {
            Help help = new Help();
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
        setOnMousePressed();
        setOnKeyPressed();
    }

    private void addButton(GridPane grid) {
        Button buttonClearCanvas = new Button("Clear canvas (C)");
        Button buttonHelp = new Button("Help (F1)");
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
//                Help help = new Help();
                HelpFrame helpFrame = new HelpFrame();

            }
        });


    }

    private GridPane createGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(0);
        grid.setVgap(0);
        grid.setPadding(new Insets(0, 0, 0, 0));
        return grid;
    }

    private void setOnMousePressed() {
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Group group1 = new Group(gc);
                double clickX = event.getSceneX();
                double clickY = event.getSceneY();
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).isTouched(clickX, clickY)) {
                        Shape selected = list.get(i);

                        if (group1.isExsist(selected)) {
                            return;
                        } else if (list.size() > 1) {
                            Shape penultimateShape = list.get(list.size() - 2);
                            if (penultimateShape.equals(selected)){
                                return;
                            } else {
                                group1.addToGroup(selected);
                                group1.addToGroup(penultimateShape);
                                list.remove(selected);
                                list.remove(penultimateShape);
                            }
                        }
                        list.add(group1);
                        counter = list.size() - 1;
                        drawAllShapesAfterAnyAction();
                    }
                }


            }
        });
    }

    /**
     * Method clean Canvas
     */

    public void cleanCanvas() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    /**
     * Method clean canvas and list
     */
    private void actionCanvas() {
        list.clear();
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }


    /**
     * Method draws all shapes after any action
     */
    private void drawAllShapesAfterAnyAction() {
        cleanCanvas();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).draw();
        }
    }


    public void setOnKeyPressed() {
        scene.setOnKeyPressed(keyboardListener);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
