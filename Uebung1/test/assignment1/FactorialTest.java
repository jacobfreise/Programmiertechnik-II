package assignment1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FactorialTest {
    @Test
    public void test() {
        assertEquals("1", Factorial.hex(1));
        assertEquals("13b0", Factorial.hex(7));
        assertEquals("1b30964ec395dc24069528d54bbda40d16e966ef9a70eb21b5b2943a321cdf10391745570cca9420c6ecb3b72ed2ee8b02ea2735c61a000000000000000000000000", Factorial.hex(100));
    }
}
