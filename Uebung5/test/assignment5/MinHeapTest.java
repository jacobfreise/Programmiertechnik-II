package assignment5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class MinHeapTest {

	@Test
	public void testArray() {
		// init
		MinHeapArray<Integer> heap = new MinHeapArray<Integer>();
		Random random = new Random(122331284423423L);
		int n = 10000;
		int array[] = new int[n];
		int temp;
		for (int i = 0; i < n; i++) {
			temp = random.nextInt();
			array[i] = temp;
			heap.add(temp);
		}
		Arrays.sort(array);
		
		// test
		assertEquals(n, heap.size());
		for (int i = 0; i < n; i++) {
			assertTrue(array[i] == heap.extractMin().intValue());
			assertEquals(n-i-1, heap.size());
		}
	}

	@Test
	public void testTree() {
		// init
		MinHeapTree<Integer> heap = new MinHeapTree<Integer>();
		Random random = new Random(122331284423423L);
		int n = 10000;
		int array[] = new int[n];
		int temp;
		for (int i = 0; i < n; i++) {
			temp = random.nextInt();
			array[i] = temp;
			heap.add(temp);
		}
		Arrays.sort(array);
		
		// test
		assertEquals(n, heap.size());
		for (int i = 0; i < n; i++) {
			assertTrue(array[i] == heap.extractMin().intValue());
			assertEquals(n-i-1, heap.size());
		}
	}
}