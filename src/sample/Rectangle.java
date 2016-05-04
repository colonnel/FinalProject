package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Admin on 16.04.16.
 */
public class Rectangle extends Shape {
    private int width = 50;
    private int high = 75;


    public Rectangle(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        getGc().setFill(Color.TOMATO);
        getGc().fillRect(getX(), getY(), width, high);
    }

    @Override
    public void changeColor(Color color) {

    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        return false;
    }
}
