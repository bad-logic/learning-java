package fundamentals.labs.lab04.lab04_04.good;

public class Rectangle extends ClosedCurve implements Polygon{
    private final double length;
    private final double width;

    public Rectangle(double length,double width){
        this.length = length;
        this.width = width;
    }

    public double computeArea() {
        return this.length * this.width;
    }

    public int getNumberOfSides() {
        return 4;
    }

    public double computePerimeter() {
        return 2 * (this.length + this.width);
    }
}
