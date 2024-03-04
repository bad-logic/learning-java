package fundamentals.labs.lab02.lab02_06;

import java.util.Arrays;

public class Prog6 {

	public static String[] removeDups(String[] arg) {
		String[] unique = new String[arg.length];
		int counter = 0;
		
		for(int i=0;i<arg.length;i++) {
			
			boolean exists = false;
			
			for(int j=0;j<unique.length;j++) {
				if(unique[j] == null) break;
				if(unique[j] == arg[i]) {
					exists = true;
					break;
				}
			}
			
			if(!exists) {
				unique[counter] = arg[i];
				counter++;
			}
		}
		
		String[] result = new String[counter];
		for(int i=0;i<counter;i++) {
			result[i] = unique[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(
				Arrays.toString(removeDups(new String[]{"horse", "dog", "cat", "horse","dog"} )));
	}
}
