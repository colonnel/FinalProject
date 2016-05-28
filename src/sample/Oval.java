package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Oval extends Shape {

    public Oval(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        getGc().setFill(Color.DARKBLUE);
        getGc().fillOval(getX(), getY(), Const.WIDTH, Const.HIGH);
    }

    @Override
    public void changeColor(Color color) {
        getGc().setFill(color);
        getGc().fillOval(getX(), getY(), Const.WIDTH, Const.HIGH);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= getX() + Const.WIDTH) && (clickX >= getX()) && (clickY <= getY() + Const.HIGH) && (clickY >= getY())) {
            System.out.println("x: " + getX());
            System.out.println("y: " + getY());
            return true;
        }
        return false;
    }
}
