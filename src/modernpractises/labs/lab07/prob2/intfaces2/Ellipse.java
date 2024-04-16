package modernpractises.labs.lab07.prob2.intfaces2;

public class Ellipse implements ClosedCurve{
    double semiaxis,elateral;

    Ellipse(double a, double e){
        this.semiaxis = a;
        this.elateral =e;
    }

    /**
     * @return perimeter of ellipse
     */
    @Override
    public double computePerimeter() {
        return 4 * this.semiaxis * this.elateral;
    }
}
