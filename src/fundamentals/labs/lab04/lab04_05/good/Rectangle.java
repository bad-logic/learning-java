package fundamentals.labs.lab04.lab04_05.good;

import java.util.Arrays;

public class Rectangle extends ClosedCurve implements Polygon {
    private final double length;
    private final double width;

    public Rectangle(double length,double width){
        this.length = length;
        this.width = width;
    }

    public double computeArea() {
        return this.length * this.width;
    }

    public double[] getArrayOfSides(){
        return new double[]{ width, width, length, length };
    }
}
