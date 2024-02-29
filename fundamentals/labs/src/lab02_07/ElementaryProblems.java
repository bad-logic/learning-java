package lab02_07;

public class ElementaryProblems {
	
	public static int getRandom() {
		return RandomNumbers.getRandomInt(1,99);
	}
	
	
	public static void print(int[] operand1,int[] operand2) {
		for(int i =0; i<operand1.length; i=i+4) {
			String output = "";
			output += String.format("%16d %12d %12d %12d %n %n", operand1[i],operand1[i+1],operand1[i+2],operand1[i+3]);
			output += String.format("%13s %2d %9s %2d %9s %2d %9s %2d %n", "+",operand2[i],"+",operand2[i+1],"+",operand2[i+2],"+",operand2[i+3]);
			output += String.format("%18s %12s %12s %12s %n %n %n","_______", "_______", "_______", "_______");
			System.out.println(output);
		}
	}
	
	
	public static String getSpaces(int numberOfSpaces, String filler) {
		return String.format("%" + numberOfSpaces + "s", filler);
	}
	
	public static String getIntSpaces(int numberOfSpaces, int value) {
		return String.format("%" + numberOfSpaces + "d", value);
	}
	
	
	public static void print(int[] operand1,int[] operand2,int itemsPerRow) {
		if(operand1.length != operand2.length) return;
		

		for(int i =0; i<operand1.length; i=i+itemsPerRow) {
		
			String firstRowFormatString = getSpaces(14," ") + getIntSpaces(2,operand1[i]) ;
			String secondRowFormatString = getSpaces(11," ") + "+" + getSpaces(2," ") + getIntSpaces(2,operand2[i]) ;
			String thirdRowFormatString = getSpaces(11," ") + "_______";
			
			for(int j=1;j<itemsPerRow;j++) {
				if(i+j > operand1.length - 1) break;
				firstRowFormatString += getSpaces(11," ") + getIntSpaces(2,operand1[i+j]);
				secondRowFormatString += getSpaces(8," ") + "+" + getSpaces(2," ") + getIntSpaces(2,operand2[i+j]) ;
				thirdRowFormatString += getSpaces(6," ") + "_______";
			}
			
			String output = String.format(firstRowFormatString+"%n %n") + 
					String.format(secondRowFormatString+"%n") +
					String.format(thirdRowFormatString + "%n %n %n");
			
			System.out.println(output);
		}
			
			
	}

	public static void main(String[] args){
		int[] operand1 = new int[8];
		int[] operand2 = new int[8];
		
		for(int i=0;i<8;i++) {
			operand1[i] = getRandom();
			operand2[i] = getRandom();
		}

		print(operand1,operand2);
		
		
		System.out.println("DYNAMIC IMPLEMENTATION");
		System.out.println();
		
		// DYNAMIC IMPLETATION		
		int length = 8; // change this value to see the effect
		int[] operand3 = new int[length];
		int[] operand4 = new int[length];
		
		for(int i=0;i<length;i++) {
			operand3[i] = getRandom();
			operand4[i] = getRandom();
		}
		print(operand1,operand2,4); //  change last argument to see the items per column change
		
	}
}

