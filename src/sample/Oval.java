package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Admin on 16.04.16.
 */
public class Oval extends Shape {
    private int width=30;
    private int high=50;

    public Oval(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        getGc().setFill(Color.DARKBLUE);
        getGc().fillOval(getX(),getY(),width,high);
    }
}
