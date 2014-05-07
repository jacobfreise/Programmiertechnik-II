package assignment2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DogTrainingTest {

	@Test
	public void testSecondsToWait() {
		assertEquals(2, DogTraining.secondsToWait(5, new int[] {2,4,3,2,1}));
	}

}
