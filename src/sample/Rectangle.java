package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


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
        getGc().setFill(color);
        getGc().fillRect(getX(), getY(), width, high);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= getX() + width) && (clickX >= getX()) && (clickY <= getY() + high) && (clickY >= getY())){
            System.out.println("x: " + getX());
            System.out.println("y: " + getY());
            return true;
        }
        return false;
    }
}
