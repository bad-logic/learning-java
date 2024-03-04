package fundamentals.labs.lab04.lab04_02;

public class Test {
	
	public static void main(String[] args) {

		ClosedCurve[] objects = {new Triangle(4,5,6),
								 new Square(3),
				                 new Rectangle(7,3),
								 new Circle(3)};
		//compute areas
		for(ClosedCurve cc : objects) {
			String className = cc.getClass().getSimpleName();
			System.out.println("The area of this " + className + " is " + cc.computeArea());
		}
    
	}

}