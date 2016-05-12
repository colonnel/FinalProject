package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;


public abstract class Shape {
    private GraphicsContext gc;
    Random random = new Random();
    private static int size = 50;
    private double x;
    private double y;
    private int step = 5;

    public Shape(GraphicsContext gc) {
        this.gc = gc;
        x = random.nextInt((int) (getGc().getCanvas().getWidth()));
        y = random.nextInt((int) getGc().getCanvas().getHeight());

    }


    public GraphicsContext getGc() {
        return gc;
    }


    public void moveUp() {
        if (y > 0) {
            y -= step;
        }
    }


    public void moveDown() {
        if (y < gc.getCanvas().getHeight() - size) {
            y += step;
        }
    }

    public void moveRight() {
        if (x < gc.getCanvas().getWidth() - size) {
            x += step;
        }
    }

    public void moveLeft() {
        if (x > 0) {
            x -= step;
        }
    }


    public void clear() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    public abstract void draw();

    public double getX() {
        if (x <= 0) {
            return (size / 2);
        }
        if (x >= getGc().getCanvas().getWidth()) {
            return (getGc().getCanvas().getWidth() - size * 2);
        }
        return x;
    }

    public double getY() {
        if (y <= 0) {
            return (size / 2);
        }
        if (y >= getGc().getCanvas().getHeight()) {
            return (getGc().getCanvas().getHeight() - size * 2);
        }
        return y;
    }

    public abstract void changeColor(Color color);

    public abstract boolean isTouched(double clickX, double clickY);


}
