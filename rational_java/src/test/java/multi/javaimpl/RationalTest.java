package multi.javaimpl;


import org.junit.Test;
import static org.junit.Assert.*;

public class RationalTest {

    @Test
    public void testConstructor() {
        Rational r = new Rational(2, 4);
        assertEquals(1, r.getNumerator());
        assertEquals(2, r.getDenominator());

        Rational r2 = new Rational(3, -6);
        assertEquals(-1, r2.getNumerator());
        assertEquals(2, r2.getDenominator());

        Rational r3 = new Rational(3);
        assertEquals(3, r3.getNumerator());
        assertEquals(1, r3.getDenominator());

        Rational r4 = new Rational();
        assertEquals(0, r4.getNumerator());
        assertEquals(1, r4.getDenominator());
    }

    @Test(expected = RuntimeException.class)
    public void testConstructorWithZeroDenominator() {
        new Rational(1, 0);
    }

    @Test
    public void testAdd() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 3);
        Rational expected = new Rational(5, 6);
        Rational actual = r1.add(r2);
        assertEquals(expected, actual);
    }

    @Test
    public void testSubtract() {
        Rational r1 = new Rational(3, 4);
        Rational r2 = new Rational(1, 2);
        Rational expected = new Rational(1, 4);
        Rational actual = r1.subtract(r2);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultiply() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(2, 3);
        Rational expected = new Rational(1, 3);
        Rational actual = r1.multiply(r2);
        assertEquals(expected, actual);
    }

    @Test
    public void testDivide() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(3, 4);
        Rational expected = new Rational(2, 3);
        Rational actual = r1.divide(r2);
        assertEquals(expected, actual);
    }

    @Test
    public void testReciprocal() {
        Rational r = new Rational(2, 3);
        Rational expected = new Rational(3, 2);
        Rational actual = r.reciprocal();
        assertEquals(expected, actual);
    }

    @Test
    public void testCompareTo() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(2, 3);
        assertTrue(r1.compareTo(r2) < 0);
        assertTrue(r2.compareTo(r1) > 0);
    }

    @Test
    public void testEquals() {
        Rational r1 = new Rational(2, 3);
        Rational r2 = new Rational(2, 3);
        assertTrue(r1.equals(r2));

        Rational r3 = new Rational(1, 3);
        assertFalse(r1.equals(r3));
    }

    @Test
    public void testHashCode() {
        Rational r1 = new Rational(1, 2);
        Rational r2 = new Rational(1, 2);
        assertEquals(r1.hashCode(), r2.hashCode());
    }
}