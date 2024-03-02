package fundamentals.labs.lab03_04;

public class Main {

	public static void main(String[] args) {
		Rectangle rec = new Rectangle(5.5, 6.0);
		Triangle trig = new Triangle(4,8);
		Circle circ = new Circle(3.3);
		
		System.out.println("Area of Triangle is "+ trig.computeArea());
		System.out.println("Area of Rectange is "+ rec.computeArea());
		System.out.println("Area of Circle is "+ circ.computeArea());
	}
}
