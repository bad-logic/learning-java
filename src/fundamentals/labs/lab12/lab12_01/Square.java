package fundamentals.labs.lab12.lab12_01;

public class Square extends ClosedCurve {
	double side;
	public Square(Double side){
		this(side.doubleValue());
	}
	public Square(double side) {
		if(side < 0) throw new IllegalClosedCurveException("side of a square cannot be negative value");
		this.side = side;
	}
	double computeArea() {
		return(side*side);
	}

}
