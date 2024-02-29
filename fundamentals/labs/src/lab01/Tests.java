package lab01;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class Tests {
	
	@Test
	public void testFirstElement() {
		int expected = 0;
		int[] arr = new int[] {1,2,3,4,5,6};
	
		assertTrue(expected == ArraySearch.search(arr, 1));
	}
	
	@Test
	public void testLastElement() {
		int expected = 5;
		int[] arr = new int[] {1,2,3,4,5,6};
	
		assertTrue(expected == ArraySearch.search(arr, 6));
	}
	
	@Test
	public void testMiddleElement() {
		int expected = 3;
		int[] arr = new int[] {1,2,3,4,5,6};
	
		assertTrue(expected == ArraySearch.search(arr, 4));
	}
	
	@Test
	public void unknown() {
		int expected = -1;
		int[] arr = new int[] {1,2,3,4,5,6};
	
		assertTrue(expected == ArraySearch.search(arr, 34));
	}
	
	@Test
	public void moreOccurence() {
		int expected = 1;
		int[] arr = new int[] {1,4,2,3,4,5,4,6};
	
		assertTrue(expected == ArraySearch.search(arr, 4));
	}

	@Test
	public void oneElementAndNoTarget() {
		int expected = -1;
		int[] arr = new int[] {1};
	
		assertTrue(expected == ArraySearch.search(arr, 4));
	}
	
	@Test
	public void oneElementAndTarget() {
		int expected = 0;
		int[] arr = new int[] {4};
	
		assertTrue(expected == ArraySearch.search(arr, 4));
	}

	@Test
	public void emptyArray() {
		int expected = -1;
		int[] arr = new int[] {};
	
		assertTrue(expected == ArraySearch.search(arr, 4));
	}
}
