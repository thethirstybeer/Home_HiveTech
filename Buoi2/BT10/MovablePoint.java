package Buoi2.BT10;

public class MovablePoint implements Movable{

    // ~ Default or Package
    int x;
    int y;
    int xSpeed;
    int ySpeed;

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d) speed = (%d, %d)", x, y, xSpeed, ySpeed);
    }

    @Override
    public void moveUp() {
        y -= ySpeed;
    }

    @Override
    public void moveDown() {
        y += ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }

    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(10, 10, 1, 2);
        System.out.println(movablePoint);
        movablePoint.moveRight();
        System.out.println(movablePoint);
    }
}
