package fundamentals.labs.lab02.lab02_05;

import java.util.Scanner;

public class Prog5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String str = sc.nextLine();
		sc.close();
		
	
		for(int i =str.length() - 1;i>=0;i--) {
			System.out.print(str.charAt(i));
		}
		
		System.out.println("\n");
	}
}
