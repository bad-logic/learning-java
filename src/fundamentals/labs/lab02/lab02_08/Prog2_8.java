package fundamentals.labs.lab02.lab02_08;

public class Prog2_8 {
	
	static int min(int[] arrOfInts) {
		int min = Integer.MAX_VALUE;
        for (int arrOfInt : arrOfInts) {
            if (arrOfInt < min) {
                min = arrOfInt;
            }
        }
		return min;
	}
	
	public static void main(String[] args) {

		int result = Prog2_8.min(new int[] {2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22});
		System.out.println(result);
		
	}

}
