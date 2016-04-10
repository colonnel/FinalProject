package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Inna on 10.04.2016.
 */
public abstract class Shape {
    private GraphicsContext gc;
    private int x;
    private int y;
    private int step = 5;

    public Shape(GraphicsContext gc) {
        this.gc = gc;

    }


    public GraphicsContext getGc() {
        return gc;
    }


    public void moveUp() {
        y -= step;
    }

    public void moveDown() {
        y += step;
    }

    public void moveRight() {
        x += step;
    }

    public void moveLeft() {
        x -= step;
    }


    public void clear() {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
    }
}
