package sample;

import javafx.scene.canvas.GraphicsContext;

import java.util.Random;

/**
 * Created by Inna on 10.04.2016.
 */
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
            clear();
            y -= step;
            draw();
        }
    }


    public void moveDown() {
        if (y < gc.getCanvas().getHeight() - size) {
            clear();
            y += step;
            draw();
        }

    }

    public void moveRight() {
        if (x < gc.getCanvas().getWidth() - size) {
            clear();
            x += step;
            draw();
        }
    }

    public void moveLeft() {
        if (x > 0) {
            clear();
            x -= step;
            draw();
        }
    }


    public void clear() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    public abstract void draw();

    public double getX() {
        if (x <= 0) {
            return size / 2;
        }
        if (x >= getGc().getCanvas().getWidth()) {
            return (getGc().getCanvas().getWidth() - size*2);
        }
        return x;
    }

    public double getY() {
        if (y <= 0) {
            return size / 2;
        }
        if (y >= getGc().getCanvas().getHeight()) {
            return (getGc().getCanvas().getHeight() - size*2);
        }
        return y;
    }


}
