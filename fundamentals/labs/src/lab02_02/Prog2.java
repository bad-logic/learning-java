package lab02_02;

public class Prog2 {
	
	public static void main(String[] args) {
		int x = RandomNumbers.getRandomInt(1,9);
		
		int y = RandomNumbers.getRandomInt(3,14);
		
        System.out.println("(PI)^x: " + Math.pow(Math.PI, x));
        
        System.out.println("y^(PI): " + Math.pow(y, Math.PI));
	}

}
