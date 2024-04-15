package modernpractises.labs.lab07.prob2.intfaces2;

public class EquilateralTriangle implements Polygon {
	private double side;
	
	public EquilateralTriangle(double side) {
		this.side = side;
	}
	
	public double[] getLengths() {
		return new double[] {side, side, side};
	}
}
