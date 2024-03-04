package fundamentals.labs.lab04_02;

public class Rectangle extends ClosedCurve{
    private final double length;
    private final double width;

    public Rectangle(double length,double width){
        this.length = length;
        this.width = width;
    }
    double computeArea() {
        return this.length * this.width;
    }
}
