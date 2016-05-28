package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Triangle extends Shape {

    public Triangle(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        getGc().setFill(Color.CYAN);
        getGc().fillPolygon(new double[]{getX(), getX() + Const.SIZE, getX() + Const.SIZE / 2},
                new double[]{getY() + Const.SIZE, getY() + Const.SIZE, getY()}, Const.QUANTITY_POINTS_TRIANGLE);
    }

    @Override
    public void changeColor(Color color) {
        getGc().setFill(color);
        getGc().fillPolygon(new double[]{getX(), getX() + Const.SIZE, getX() + Const.SIZE / 2},
                new double[]{getY() + Const.SIZE, getY() + Const.SIZE, getY()}, Const.QUANTITY_POINTS_TRIANGLE);
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
