package assignment5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
	private BinarySearchTree<Integer> tree;
	@Before
	public void init() {
		tree = new BinarySearchTree<>();
		tree.add(1);
		tree.add(3);
		tree.add(2);
	}
	@Test
	public void testAdd() {
		tree.add(2);
		assertEquals(3, tree.size());
		tree.add(0);
		assertEquals(4, tree.size());
	}
	@Test
	public void testRemove() {
		tree.remove(0);
		assertEquals(3, tree.size());
		tree.remove(3);
		assertEquals(2, tree.size());
	}
	@Test
	public void testContains() {
		assertTrue(tree.contains(1));
		assertTrue(tree.contains(2));
		assertTrue(tree.contains(3));
		assertFalse(tree.contains(0));
	}
	@Test
	public void testSize() {
		assertEquals(3, tree.size());
	}
}
