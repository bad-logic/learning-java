package fundamentals.labs.lab04.lab04_05;

import fundamentals.labs.lab04.lab04_05.good.*;

public class Test3 {
	
	public static void main(String[] args) {

		Polygon[] objects = {
							 new Square(3),
							 new Triangle(4,5,6),
							 new Rectangle(4,3),
							 };
		//compute areas
		for(Polygon cc : objects) {
			// using java reflection api to get the class name values
			String className = cc.getClass().getSimpleName();
			System.out.println("For this " + className + "\n Perimeter = " + cc.computePerimeter());
		}
    
	}

}