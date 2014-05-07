package assignment1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SweetsEqualizerTest {
    @Test
    public void test() {
        assertEquals(3, SweetsEqualizer.minOperationCount(new int[] {101, 102, 103}));
        assertEquals(0, SweetsEqualizer.minOperationCount(new int[] {15, 15}));
        assertEquals(1505, SweetsEqualizer.minOperationCount(new int[] {500, 301, 792, 45, 92}));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testMinN() {
        SweetsEqualizer.minOperationCount(new int[0]);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testMaxN() {
        SweetsEqualizer.minOperationCount(new int[201]);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDomainMin() {
        SweetsEqualizer.minOperationCount(new int[]{-1});
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDomainMax() {
        SweetsEqualizer.minOperationCount(new int[]{50001});
    }
}
