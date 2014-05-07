package assignment1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FibonacciTest {
    @Test
    public void testIterative() {
        assertEquals(1L, Fibonacci.iterative(1));
        assertEquals(55L, Fibonacci.iterative(10));
        assertEquals(2971215073L, Fibonacci.iterative(47));
    }
    @Test
    public void testRecursive() {
        assertEquals(1L, Fibonacci.recursive(1));
        assertEquals(55L, Fibonacci.recursive(10));
        assertEquals(2971215073L, Fibonacci.recursive(47));
    }
}
