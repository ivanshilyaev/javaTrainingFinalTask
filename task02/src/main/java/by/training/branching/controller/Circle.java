package by.training.branching.controller;

public class Circle implements Comparable<Circle> {
    private double x;
    private double y;
    private double radius;

    public Circle(double radius) {
        x = 0;
        y = 0;
        this.radius = radius;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean belongsToCircle(int a, int b) {
        return Math.pow(a-x, 2) + Math.pow(b-y, 2) <= Math.pow(radius, 2);
    }

    public int compareTo(Circle o) {
        return Double.compare(radius, o.radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        Circle circle = (Circle) obj;
        return (x == circle.x) && (y == circle.y) && (radius == circle.radius);
    }

    @Override
    public int hashCode() {
        return (int) (x * y * radius);
    }

    @Override
    public String toString() {
        return "Circle: " + "(x=" + x + ", y=" + y + ", radius=" + radius + ")";
    }
}
