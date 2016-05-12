package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Group extends Shape {
    List<Shape> list = new ArrayList<>();
    private Color colorForGroup;

    public Group(GraphicsContext gc) {
        super(gc);
        colorForGroup = generateColorForGroup();
    }

    @Override
    public void draw() {
        for (Shape s : list) {
            s.changeColor(colorForGroup);
        }
    }

    @Override
    public void changeColor(Color color) {
        //not need
    }

    public void moveUp() {
        for (Shape s : list) {
            s.moveUp();
        }
    }

    public void moveDown() {
        for (Shape s : list) {
            s.moveDown();
        }
    }

    public void moveLeft() {
        for (Shape s : list) {
            s.moveLeft();
        }
    }

    public void moveRight() {
        for (Shape s : list) {
            s.moveRight();
        }
    }

    public void addToGroup(Shape shape) {
        list.add(shape);
    }

    @Override
    public boolean isTouched(double clickX, double clickY) {
        return false;
    }

    public Color generateColorForGroup() {
        // Java 'Color' class takes 3 floats, from 0 to 1.
        Random random = new Random();
        float r = random.nextFloat();
        float g = random.nextFloat();
        float b = random.nextFloat();
        Color randomColorForGroup = new Color(r, g, b, 1);
        return randomColorForGroup;

    }

    public boolean isExsist(Shape s) {
        return list.contains(s);
    }
}
