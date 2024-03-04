package fundamentals.labs.lab02.lab02_08;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Prog2_8Test {
	
	@Test
	public void isMinimumValueReturned(){
		int[] testData = new int[] {2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22};
		int expected = -22;
		
		int result = Prog2_8.min(testData);
		
		assertTrue(expected==result);
		
	}

}
