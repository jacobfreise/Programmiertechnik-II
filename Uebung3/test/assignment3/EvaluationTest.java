package assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

public class EvaluationTest {

	@Test
	public void testMinSum() {
		assertArrayEquals(new long[] {7, 9, 5}, Evaluation.minSum(new int[]{4, 9, 1}, new long[]{1, 2, 3}, new long[]{4, 5, 6}));
	}
}
