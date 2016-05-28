package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Circle extends Shape {

    public Circle(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        getGc().setFill(Color.GREENYELLOW);
        getGc().fillOval(getX(), getY(), Const.SIZE, Const.SIZE);
    }

    @Override
    public void changeColor(Color color) {
        getGc().setFill(color);
        getGc().fillOval(getX(), getY(), Const.SIZE, Const.SIZE);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= getX() + Const.SIZE) && (clickX >= getX()) && (clickY <= getY() + Const.SIZE) && (clickY >= getY())) {
            System.out.println("x: " + getX());
            System.out.println("y: " + getY());
            return true;
        }
        return false;
    }
}
