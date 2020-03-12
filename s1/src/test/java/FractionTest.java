import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void gcd() {
        assertEquals(4, Fraction.gcd(8 , 12));
        assertEquals(1, Fraction.gcd(3 , 2));
    }

    @Test
    void lcm() {
        assertEquals(6, Fraction.lcm(3 , 2));
        assertEquals(24, Fraction.lcm(8 , 12));
    }

    @Test
    void zeroDenominator() {
        assertThrows(IllegalArgumentException.class, () -> new Fraction(1,0));
    }


    @Test
    void multiply() {
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(1,2);
        assertEquals(new Fraction(1,4), f1.multiply(f2));
    }


    @Test
    void divide() {
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(1,2);
        assertEquals(new Fraction(2,2), f1.divide(f2));
    }

    @Test
    void add() {
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(1,2);
        assertEquals(new Fraction(2,2), f1.add(f2));
    }

    @Test
    void subtract() {
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(1,2);
        assertEquals(new Fraction(0,2), f1.subtract(f2));
    }

    @Test
    void testEquals() {
        Fraction f1 = new Fraction(1,2);
        Fraction f2 = new Fraction(1,2);
        assertEquals(f1, f2);
    }

    @Test
    void simplify() {
        Fraction f1 = new Fraction(1,1);
        Fraction f2 = new Fraction(2,2).simplify();
        assertEquals(f1, f2);
    }
}