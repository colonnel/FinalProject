package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;




public class Triangle extends Shape {
    private int size=50;
    public Triangle(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        getGc().setFill(Color.CYAN);
        getGc().fillPolygon(new double[]{getX(), getX()+size, getX()+size/2},
        new double[]{getY()+size, getY()+size, getY()},3);
    }

    @Override
    public void changeColor(Color color) {
        getGc().setFill(color);
        getGc().fillPolygon(new double[]{getX(), getX()+size, getX()+size/2},
                new double[]{getY()+size, getY()+size, getY()},3);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= getX() + size) && (clickX >= getX()) && (clickY <= getY() + size) && (clickY >= getY())){
            System.out.println("x: " + getX());
            System.out.println("y: " + getY());
            return true;
        }
        return false;
    }
}
