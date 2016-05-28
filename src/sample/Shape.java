package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;


public abstract class Shape {
    private GraphicsContext gc;
    Random random = new Random();
    private double x;
    private double y;

    public Shape(GraphicsContext gc) {
        this.gc = gc;
        x = random.nextInt((int) (getGc().getCanvas().getWidth()));
        y = random.nextInt((int) getGc().getCanvas().getHeight());
    }


    public GraphicsContext getGc() {
        return gc;
    }

    /**
     * Method moves shape up
     */
    public void moveUp() {
        if (y > 0) {
            y -= Const.STEP;
        }
    }

    /**
     * Method moves shape down
     */
    public void moveDown() {
        if (y < gc.getCanvas().getHeight() - Const.SIZE) {
            y += Const.STEP;
        }
    }

    /**
     * Method moves shape right
     */
    public void moveRight() {
        if (x < gc.getCanvas().getWidth() - Const.SIZE) {
            x += Const.STEP;
        }
    }

    /**
     * Method moves shape left
     */
    public void moveLeft() {
        if (x > 0) {
            x -= Const.STEP;
        }
    }

    /**
     * Method gets coordinates for x
     */
    public double getX() {
        return x;
    }

    /**
     * Method gets coordinates for y
     */
    public double getY() {
        return y;
    }

    public abstract void changeColor(Color color);

    public abstract boolean isTouched(double clickX, double clickY);

    public abstract void draw();

}
