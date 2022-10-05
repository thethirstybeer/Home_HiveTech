package Buoi2.BT11;

public class Rectangle implements GeometricObject{

    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public String toString(){
        return String.format("Rectangle[width=%.2f, length=%.2f]", width, length);
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return (width + length)/2;
    }
}
