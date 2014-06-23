package assignment4;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import assignment4.TripToReno;


public class TripToRenoTest {

	@Test
	public void testStops() {
		int[] tankstellen = {34,37,19};
		int[] ret = TripToReno.getStops(50,100,tankstellen);
		assertArrayEquals(new int[] {0,1}, ret);

	}
	@Test
	public void testBattle1() {
		int[] tankstellen = {1,1,1,20,21,34,1,2,45,1,44,7,5,10};
		int ret = TripToReno.timeCompare(50,40,45,200,tankstellen);
		assertEquals(0, ret);
	}
	@Test
	public void testBattle2() {
		int[] tankstellen = {1,1,1,20,21,34,1,2,45,1,44,7,5,10};
		int ret = TripToReno.timeCompare(50,39,45,200,tankstellen);
		assertEquals(1, ret);
	}
	@Test
	public void testBattle3() {
		int[] tankstellen = {1,1,1,20,21,34,1,2,45,1,44,7,5,10};
		int ret = TripToReno.timeCompare(49,40,45,200,tankstellen);
		assertEquals(-1, ret);
	}
}
