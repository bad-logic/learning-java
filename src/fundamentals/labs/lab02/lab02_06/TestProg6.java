package fundamentals.labs.lab02.lab02_06;

import java.util.Arrays;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestProg6 {

	@Test
	public void testRemoveDups() {
		String[] testData = new String[]{"horse", "dog", "cat", "horse","dog"};
		
		String[] expectation = new String[]{"horse", "dog", "cat"};
		String[] result = Prog6.removeDups(testData);
	
		assertTrue(Arrays.equals(expectation, result));
	}
	
	@Test
	public void isAnOriginalElement() {
		String[] testData = new String[]{"horse", "dog", "cat", "horse","dog"};
		
		String[] result = Prog6.removeDups(testData);
		
		for(String item: result) {
			boolean isOriginalElement = false;
			for(String orig: testData) {
				if(item.equals(orig)) {
					isOriginalElement = true;
					break;
				}
			}
			assertTrue(isOriginalElement);
		}
	}
	
}
