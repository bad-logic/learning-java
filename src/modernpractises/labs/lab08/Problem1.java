package modernpractises.labs.lab08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Problem1 {

	public static void main(String[] args) {
		// To understand functions as First class citizen
		 List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		 // Task 1: Identify the suitable interface to read the input and print doubled

		 changeDouble(numbers , (x)-> System.out.println(2 * x +" "));// Output: 2 4 6 8 10
	
		 List<String> data = Arrays.asList("apple", "banana", "cherry");

	     //Task 2: Take input of String and transform into Upper case   
		 transformStrings(data , (x)-> x.toUpperCase());
		 
		 // Task 3: Check the inputs of given value is divisible by 5.
		 List<Integer> inputs = Arrays.asList(10, 21, 12, 25, 33);
	        printIf(inputs , (x) -> x % 5 == 0);
	}

	public static void changeDouble(List<Integer> numbers , Consumer<Integer> consumer) {
        for (Integer number : numbers) {
            consumer.accept(number);
        }
	}
	public static void transformStrings(List<String> list, Function<String,String> consumer) {
        for (String s : list) {
            System.out.println(consumer.apply(s));
        }
    }
	public static void printIf(List<Integer> numbers, IntPredicate consumer) {
		for (Integer number : numbers) {
			if (consumer.test(number)) {
				System.out.println(number);
			}
		}
	}
}

