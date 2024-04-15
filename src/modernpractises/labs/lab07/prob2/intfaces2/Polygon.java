package modernpractises.labs.lab07.prob2.intfaces2;

public interface Polygon extends ClosedCurve {
    @Override
    default double computePerimeter() {
    	double sum = 0;
        for(double length: getLengths()) {
        	sum += length;
        }
        return sum;
    }

    double[] getLengths();
}
