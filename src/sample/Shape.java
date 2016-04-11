package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Inna on 10.04.2016.
 */
public abstract class Shape {
    private GraphicsContext gc;
    private static int size = 50;
    protected int x;
    protected int y;
    protected int step = 5;

    public Shape(GraphicsContext gc) {
        this.gc = gc;
        x = (int) (getGc().getCanvas().getWidth() / 2 - size / 2);
        y = (int) getGc().getCanvas().getHeight() / 2 - size / 2;

    }


    public GraphicsContext getGc() {
        return gc;
    }


    public void moveUp() {
        clear();
        y -= step;
        draw();
    }


    public void moveDown() {
        clear();
        y += step;
        draw();
    }

    public void moveRight() {
        clear();
        x += step;
        draw();
    }

    public void moveLeft() {
        clear();
        x -= step;
        draw();
    }


    public void clear() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }

    public abstract void draw();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}
