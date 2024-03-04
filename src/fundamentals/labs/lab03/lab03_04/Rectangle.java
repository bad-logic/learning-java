package fundamentals.labs.lab03.lab03_04;

public final class Rectangle {
	
	private final double length;
	private final double width;
	
	public Rectangle(double width, double length) {
		this.length = length;
		this.width = width;
	}
	
	public double getLength() {
		return this.length;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public double computeArea() {
		return this.length * this.width;
	}

}
