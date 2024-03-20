package fundamentals.labs.lab12.lab12_01;

public class Rectangle extends ClosedCurve {

	private double width;
	private double length;

	public Rectangle(double width, double length){
		if(width < 0 || length < 0) throw new IllegalClosedCurveException("width or height of rectangle cannot be negative value");
		this.length = length;
		this.width = width;
	}
	double computeArea() {
		return width*length;
	}
	


}
