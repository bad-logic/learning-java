package modernpractises.labs.lab07.prob2.intfaces2;

public interface Polygon extends ClosedCurve {

    default public double computePerimeter(){
        double perimeter = 0;
        for(double side: this.getLengths()){
            perimeter += side;
        }
        return perimeter;
    }

    double[] getLengths();
}
