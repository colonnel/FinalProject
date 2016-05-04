package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Inna on 10.04.2016.
 */
public class Circle extends Shape {
    private int size = 50;

    public Circle(GraphicsContext gc) {
        super(gc);
    }
@Override
public void draw() {
        getGc().setFill(Color.GREENYELLOW);
        getGc().fillOval(getX(), getY(), size, size);
    }

    @Override
    public void changeColor(Color color) {

    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        return false;
    }
}
