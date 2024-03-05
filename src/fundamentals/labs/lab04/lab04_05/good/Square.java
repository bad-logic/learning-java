package fundamentals.labs.lab04.lab04_05.good;

public final class Square extends ClosedCurve implements Polygon {
	private final double side;
	
	public Square(double side){
		this.side = side;
		
	}
	public double computeArea() {
		return side * side;
	}

	public double[] getArrayOfSides(){
		return new double[] { this.side, this.side, this.side, this.side };
	}


}
