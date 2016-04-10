package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by Inna on 10.04.2016.
 */
public class Circle extends Shape {
    private int size = 50;

    public Circle(GraphicsContext gc) {
        super(gc);


    }

    public void draw() {
        getGc().setFill(Color.GREENYELLOW);
        getGc().fillOval(getGc().getCanvas().getWidth() / 2 - size / 2, getGc().getCanvas().getHeight() / 2 - size / 2, size, size);

    }
}
