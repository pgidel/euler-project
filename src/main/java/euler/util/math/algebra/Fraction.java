package euler.util.math.algebra;

public class Fraction implements Comparable<Fraction> {

	public long numerator;
	public long denominator;

	public Fraction(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Fraction reduce() {
		long n = numerator;
		long d = denominator;

		while (d != 0) {
			long t = d;
			d = n % d;
			n = t;
		}

		return new Fraction(numerator / n, denominator / n);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (denominator ^ (denominator >>> 32));
		result = prime * result + (int) (numerator ^ (numerator >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (denominator != other.denominator)
			return false;
		if (numerator != other.numerator)
			return false;
		return true;
	}

	@Override
	public int compareTo(Fraction o) {
		long n1 = this.numerator * o.denominator;
		long n2 = o.numerator * this.denominator;
		if (n1 > n2) {
			return 1;
		}
		if (n1 < n2) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return numerator + " / " + denominator;
	}

}
