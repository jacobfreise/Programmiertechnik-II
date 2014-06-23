package assignment5;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class SortTest {

	@Test
	public void testHeapsort() {
		String[] a = new String[] {"b", "a", "c"};
		Sort.heapsort(a);
		assertArrayEquals(new String[] {"a", "b", "c"}, a);
	}
	
	@Test
	public void testHeapsortEmpty() {
		String[] a = new String[0];
		Sort.heapsort(a);
		assertArrayEquals(new String[0], a);
	}
}
