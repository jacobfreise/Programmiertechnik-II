package assignment6;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class HashMultiMapTest {
	HashMultiMap<String, Integer> mmap;

	@Before
	public void testMyHashSetHashFunctionOfT() {
		mmap = new HashMultiMap<>();
		mmap.bind("a", 1);
		mmap.bind("b", 2);
		mmap.bind("b", 3);
		mmap.bind("c", 3);
	}
	
	@Test
	public void testBind() {
		mmap.bind("c", 4);
		assertEquals(5, mmap.count());
		mmap.bind("d", 4);
		assertEquals(6, mmap.count());
	}
	@Test
	public void testRemoveBindingFor() {
		mmap.removeBindingFor("d");
		assertEquals(4, mmap.count());
		mmap.removeBindingFor("c");
		assertEquals(3, mmap.count());
		mmap.removeBindingFor("b");
		assertEquals(1, mmap.count());
	}

	@Test
	public void testCountElementsFor() {
		assertEquals(1, mmap.countElementsFor("a"));
		assertEquals(2, mmap.countElementsFor("b"));
		assertEquals(1, mmap.countElementsFor("c"));
		assertEquals(0, mmap.countElementsFor("d"));
	}

	@Test
	public void testElementsFor() {
		assertArrayEquals(new Integer[]{1}, sortedElementsFor("a"));
		assertArrayEquals(new Integer[]{2,3}, sortedElementsFor("b"));
		assertArrayEquals(new Integer[]{3}, sortedElementsFor("c"));
		assertArrayEquals(new Integer[]{}, sortedElementsFor("d"));
	}
	
	private Integer[] sortedElementsFor(String key) {
		Integer[] result = new Integer[mmap.countElementsFor(key)];
		Iterator<Integer> values = mmap.elementsFor(key);
		int index = 0;
		while(values.hasNext()) {
			result[index++] = values.next();
		}
		Arrays.sort(result);
		return result;
	}

	@Test
	public void testCount() {
		assertEquals(4, mmap.count());
	}

}
