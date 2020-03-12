import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Fraction {
    private final long num;
    private final long den;

    public Fraction(long num, long den) {
        this.num = num;
        this.den = den;
        if (den == 0)
            throw new IllegalArgumentException("denominator cannot be 0");
    }

    public Fraction add(Fraction f) {
        long lcm = lcm(this.den, f.den);
        long sum = this.num * (lcm/this.den) + f.num * (lcm/f.den);
        return new Fraction(sum, lcm);
    }

    public Fraction simplify() {
        long gcd = gcd(num, den);
        return new Fraction(num/gcd, den/gcd);
    }

    public static long lcm(long u, long v) {
        return u*v/gcd(u,v);
    }

    public static long gcd(long u, long v) {
        if(v == 0) return u;
        return gcd(v, u%v);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return num == fraction.num &&
                den == fraction.den;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, den);
    }

    @Override
    public String toString() {
        return "Fraction{" +
                "num=" + num +
                ", den=" + den +
                '}';
    }

    public Fraction multiply(Fraction f) {
        return new Fraction(num*f.num, den*f.den);
    }

    public Fraction divide(Fraction f) {
        return new Fraction(num* f.den, den* f.num);
    }

    public Fraction subtract(Fraction f) {
         return add(new Fraction(-1* f.num,  f.den));
    }
}
