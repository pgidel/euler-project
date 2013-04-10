package euler.problem.p00;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler003 extends AbstractEuler {

	private long n;

	public Euler003(long n) {
		this.n = n;
	}

	/**
	 * The prime factors of 13195 are 5, 7, 13 and 29.
	 * 
	 * What is the largest prime factor of the number n ?
	 */
	@Override
	public void compute() {
		// XXX reduce the field search thanks to a square root
		long sqrt = MathUtils.sqrt(n);
		long roundedSqrt = sqrt % 2 == 0 ? sqrt - 1 : sqrt;
		for (long factor = roundedSqrt; factor > 1; factor -= 2) {
			if (MathUtils.isDivider(n, factor) && MathUtils.isPrime(factor)) {
				result = BigInteger.valueOf(factor);
				return;
			}
		}
		result = BigInteger.valueOf(n);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler003(65));
	}

}
