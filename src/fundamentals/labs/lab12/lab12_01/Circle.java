package fundamentals.labs.lab12.lab12_01;

public class Circle extends ClosedCurve {
	double radius;
	public Circle(Double radius){
		this(radius.doubleValue());
	}
	public Circle(double radius) {
		if(radius < 0) throw new IllegalClosedCurveException("radius of circle cannot be negative value");
		this.radius = radius;
	}
	double computeArea() {
		return (Math.PI * radius * radius);
	}
}
