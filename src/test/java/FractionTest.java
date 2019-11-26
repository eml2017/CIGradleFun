import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest {
    @Test
    public void testConstructor() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(fraction.getNumerator(), 1);
    }
}