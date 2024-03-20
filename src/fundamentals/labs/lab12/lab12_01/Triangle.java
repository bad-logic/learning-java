package fundamentals.labs.lab12.lab12_01;

public class Triangle extends ClosedCurve {
	
		double base;
		double height;
		double side1;
		double side2;
		double side3;
		
		//easy way of doing it
		public Triangle(double base, double height){
			if(base < 0 || height < 0) throw new IllegalTriangleException("base or height cannot be negative value");
			this.base = base;
			this.height = height;
		}
		
		//constructor that accepts 3 sides
		public Triangle(double side1, double side2, double side3)  {
			if(side1 < 0 || side2 < 0 || side3 < 0) throw new IllegalTriangleException("sides cannot be negative values");
			double[] arr = sort(side1,side2,side3);		
			double x = arr[0];
			double y = arr[1];
			double z = arr[2];
			if(x + y < z) {
				throw new IllegalTriangleException("Illegal sizes for a triangle: "+side1+", "+side2+", "+side3);
			}
			else {	
				setSides(x,y,z);
				computeBaseAndHeight(x,y,z);
			}
		}
		public void setSides(double x, double y, double z){
			if(x < 0 || y < 0 || z < 0) throw new IllegalTriangleException("sides cannot be negative values");
			side1 = x;
			side2 = y;
			side3 = z;
		}
		//used with the side-side-side constructor
		private void computeBaseAndHeight(double x, double y, double z){
			double u = (y*y - x*x + z*z)/(2*z);
			double h = Math.sqrt(y*y - u*u);
			base = z;
			height = h;		
		}
		double computeArea() {
			return (0.5 * base * height);
		}
		private double[] sort(double a, double b, double c){
			double[] retVal = new double[3];
			double[] others = new double[2];
			double min = a;
			others = new double[]{b,c};
			if(b < min) {
				min = b;
				others = new double[]{a,c};
			}
			if(c < min) {
				min = c;
				others = new double[]{a,b};
			}
			retVal[0]= min;
			if(others[0]> others[1])
				others= new double[]{others[1],others[0]};
			
			retVal[1]=others[0];
			retVal[2]=others[1];
			//System.out.println("Sorted: "+Arrays.toString(retVal));
			return retVal;
		}
		public static void main(String[] args){
			
				Triangle t = new Triangle(1.41421, 1.41421, 2);
				//System.out.println("Area: "+t.computeArea());
				//System.out.println(""+(3560/256));
				//System.out.println(""+(3560-256*13));
				System.out.println(""+(232/16));
				System.out.println(""+(232-16*(232/16)));
				System.out.println(""+(9*256 + 14 * 16 + 2));
				System.out.println(""+(-5/2)+"  "+ (-5%2));
				System.out.println(""+(35/4));
				System.out.println(""+(35>>2));
				byte x = 2;
				byte y = 3;
				//byte sum = x+ y;
		}


		private final double DEFAULT_SIDE = 5.0;
}

