package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Created by bse on 15.04.16.
 */
public class Square extends Shape {
   private int size=50;

    public Square(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {

        getGc().setFill(Color.BLUE);
        getGc().fillRect(getX(),getY(),size,size);
    }

    @Override
    public void changeColor(Color color) {

    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        return false;
    }
}
