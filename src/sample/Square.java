package sample;


import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Square extends Shape {
    private int size = 50;

    public Square(GraphicsContext gc) {
        super(gc);
    }

    @Override
    public void draw() {
        getGc().setFill(Color.BLUE);
        getGc().fillRect(getX(), getY(), size, size);

    }

    @Override
    public void changeColor(Color color) {
        getGc().setFill(color);
        getGc().fillRect(getX(), getY(), size, size);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        if ((clickX <= getX() + size) && (clickX >= getX()) && (clickY <= getX() + size) && (clickY >= getY())) {
            System.out.println("x: " + getX());
            System.out.println("y: " + getY());
            return true;
        }
        return false;
    }
}
