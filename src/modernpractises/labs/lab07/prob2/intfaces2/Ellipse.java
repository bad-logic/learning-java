package modernpractises.labs.lab07.prob2.intfaces2;

public class Ellipse implements ClosedCurve {
	private double ellipticIntegral;
	private double semiMajorAxis;
	
	public Ellipse(double ellipticIntegral, double semiMajorAxis) {
		this.ellipticIntegral = ellipticIntegral;
		this.semiMajorAxis = semiMajorAxis;
	}
	
	@Override
	public double computePerimeter() {
		return 4 * ellipticIntegral * semiMajorAxis;
	}
}
