package euler.problem.p02;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.MathUtils;

public class Euler027 extends AbstractEuler {

	private long a;
	private long b;

	public Euler027(long a, long b) {
		this.a = a;
		this.b = b;
	}

	/**
	 * Euler published the remarkable quadratic formula:
	 * 
	 * n^2 + n + 41
	 * 
	 * It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39. However, when n =
	 * 40, 40^(2) + 40 + 41 = 40(40 + 1) + 41 is divisible by 41, and certainly when n = 41, 41^2 + 41 + 41 is clearly
	 * divisible by 41.
	 * 
	 * Using computers, the incredible formula n² - 79n + 1601 was discovered, which produces 80 primes for the
	 * consecutive values n = 0 to 79. The product of the coefficients, -79 and 1601, is -126479.
	 * 
	 * Considering quadratics of the form:
	 * 
	 * n² + an + b, where |a| < 1000 and |b| < 1000
	 * 
	 * where |n| is the modulus/absolute value of n e.g. |11| = 11 and |-4| = 4
	 * 
	 * Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of
	 * primes for consecutive values of n, starting with n = 0.
	 */
	@Override
	public void compute() {
		long r = 0;
		long max = 0;
		for (long i = -a + 1; i < a; i++) {
			for (long j = -b + 1; j < b; j++) {
				long n = 0;
				while (MathUtils.isPrime(n * n + i * n + j)) {
					if (n > max) {
						max = n;
						r = i * j;
					}
					n++;
				}
			}
		}
		result = BigInteger.valueOf(r);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler027(1000, 1000));
	}

}
