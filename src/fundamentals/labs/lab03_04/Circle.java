package lab03_04;

public final class Circle {
	
	private final double radius;
	
	public Circle(double r) {
		this.radius = r;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double computeArea() {
		return Math.PI * this.radius * this.radius;
	}

}
