package generics.exercises.shapes;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();

        addShape(shapes, new Circle(5));
        addShape(shapes, new Rectangle(10, 5));
        System.out.println();

        drawShapes(shapes);
    }

    // 1.
    private static <T extends Shape> void addShape(List<T> shapes, T shape) {
        System.out.println("Adding shape...");
        shapes.add(shape);
    }

    // 2.
    private static void addShapeWithSuper(List<? super Shape> shapes, Shape shape) {
        System.out.println("Adding shape...");
        shapes.add(shape);
    }

    private static void drawShapes(List<? extends Shape> shapes) {
        for (Shape shape : shapes) {
            shape.drawShape();
        }
    }
}

interface Shape {
    void drawShape();
}

class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void drawShape() {
        System.out.println("Drawing circle");
    }
}

class Rectangle implements Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawShape() {
        System.out.println("Drawing rectangle");
    }
}
