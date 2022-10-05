package Buoi2.BT11;

import static java.lang.Math.*;

public class Circle implements GeometricObject{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return PI*pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
//        return "Circle{" +
//                "radius=" + radius +
//                '}';
        return String.format("Circle[radius=%.2f]", radius);
    }

    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println(circle);
        System.out.println(circle.getArea());
    }
}
