package euler.problem.p00;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler009 extends AbstractEuler {

	private long n;

	public Euler009(long n) {
		this.n = n;
	}

	/**
	 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
	 * which, a^(2) + b^(2) = c^(2)
	 * 
	 * For example, 3^(2) + 4^(2) = 9 + 16 = 25 = 5^(2).
	 * 
	 * There exists exactly one Pythagorean triplet for which a + b + c = n.
	 * Find the product abc.
	 */
	@Override
	public void compute() {
		for (long i = 1; i < n - 2; i++) {
			for (long j = i + 1; j < n - i; j++) {
				long k = n - i - j;
				if (MathUtils.isPythagoreanTriplet(i, j, k)) {
					result = BigInteger.valueOf(i * j * k);
					return;
				}
			}
		}
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler009(1000));
	}

}
