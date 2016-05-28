package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class Main extends Application {
    //    private static int CANVAS_X = 1000;
//    private static int CANVAS_Y = 600;
    GraphicsContext gc;
    Scene scene;
    ArrayList<Shape> list = new ArrayList<>();
    private int counter = -1;

    private EventHandler<KeyEvent> keyboardListener = event -> {

        switch (event.getCode()) {
            case DIGIT1: //Add circle
                list.add(new Circle(gc));
                drawAllShapesAfterAnyAction();
                counter++;
                break;
            case DIGIT2: //Add square
                list.add(new Square(gc));
                drawAllShapesAfterAnyAction();
                counter++;
                break;
            case DIGIT3: //Add Triangle
                list.add(new Triangle(gc));
                drawAllShapesAfterAnyAction();
                counter++;
                break;
            case DIGIT4: //Add oval
                list.add(new Oval(gc));
                drawAllShapesAfterAnyAction();
                counter++;
                break;
            case DIGIT5: //Add rectangle
                list.add(new Rectangle(gc));
                drawAllShapesAfterAnyAction();
                counter++;
                break;
            case A: //Switch forward between shapes and shapes group
                counter--;
                if (counter < 0) {
                    counter = 0;
                }
                break;
            case D: //Switch backward between shapes and shapes group
                counter++;
                if (counter > list.size() - 1) {
                    counter = list.size() - 1;
                }
                break;
            //Add random add shapes
            case R:
                addRandomShape();
                break;
            //Move active shapes and group
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
            //Clean canvas from all shapes and groups
            case C:
                clearCanvasAndList();
                break;
        }
        cleanCanvas();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).draw();
        }
    };

    /**
     * Method adds new random shape on canvas
     */
    private void addRandomShape() {
        int randShape = new Random().nextInt(Const.QUANTITY_SHAPES) + 1;
        switch (randShape) {
            case 1:
                list.add(new Circle(gc));
                drawAllShapesAfterAnyAction();
                counter++;
                break;
            case 2:
                list.add(new Square(gc));
                drawAllShapesAfterAnyAction();
                counter++;
                break;
            case 3:
                list.add(new Triangle(gc));
                drawAllShapesAfterAnyAction();
                counter++;
                break;
            case 4:
                list.add(new Oval(gc));
                drawAllShapesAfterAnyAction();
                counter++;
                break;
            case 5:
                list.add(new Rectangle(gc));
                drawAllShapesAfterAnyAction();
                counter++;
                break;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(Const.TITLE_WINDOW);
        BorderPane group = new BorderPane();
        Canvas canvas = new Canvas(Const.CANVAS_X, Const.CANVAS_Y);
        GridPane grid = createGrid();
        addButton(grid);
        grid.add(group, 1, 1);
        scene = new Scene(grid);
        gc = canvas.getGraphicsContext2D();
        primaryStage.setScene(scene);
        group.setCenter(canvas);
        primaryStage.show();
        setOnKeyPressed();
        setOnMousePressed();
        setOnKeyPressed();
    }

    private void addButton(GridPane grid) {
        Button buttonClearCanvas = new Button(Const.BUTTON_CLEAR);
        Button buttonHelp = new Button(Const.BUTTON_HELP);
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(buttonClearCanvas);
        hbBtn.getChildren().add(buttonHelp);
        grid.add(hbBtn, 1, 4);

        buttonClearCanvas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Event -->" + event.toString());
                clearCanvasAndList();
            }
        });

        buttonHelp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Event -->" + event.toString());
                new HelpFrame();
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

                        if (group1.isExist(selected)) {
                            return;
                        } else if (list.size() > 1) {
                            Shape penultimateShape = list.get(list.size() - 2);
                            if (penultimateShape.equals(selected)) {
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
    private void clearCanvasAndList() {
        list.clear();
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        counter = -1;
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
