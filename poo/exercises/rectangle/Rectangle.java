package poo.exercises.rectangle;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return getWidth() * getHeight();
    }

    public double getPerimeter() {
        return (getWidth() + getHeight()) * 2;
    }

    public double getDiagonal() {
        return Math.sqrt(Math.pow(getWidth(), 2) + Math.pow(getHeight(), 2));
    }

    @Override
    public String toString() {
        return String.format("Area: %.2f \nPerimeter: %.2f\nDiagonal: %.2f", getArea(), getPerimeter(), getDiagonal());
    }
}
