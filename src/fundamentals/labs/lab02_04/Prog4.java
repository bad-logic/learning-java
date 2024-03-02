package fundamentals.labs.lab02_04;

//import java.util.Arrays;

public class Prog4 {

	public static void main(String[] args) {
		String myString = Data.records;
		String[] records = myString.split(":");
//		System.out.println( Arrays.toString(records));
//		System.out.println( records[0]);
		
		for(String str: records) {
			System.out.println(str.split(",")[0]);
		}
		
	}
}
