package assignment1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LadderStepsTest {
    @Test
    public void test() {
        assertEquals(1L, LadderSteps.combinationCount(1));
        assertEquals(89L, LadderSteps.combinationCount(10));
        assertEquals(4660046610375530309L, LadderSteps.combinationCount(90));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDomainMin() {
        Fibonacci.iterative(-1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDomainMax() {
        Fibonacci.iterative(100);
    }
}