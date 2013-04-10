package euler.problem.p05;

import java.math.BigInteger;

import euler.problem.AbstractEuler;
import euler.util.EulerUtils;

public class Euler056 extends AbstractEuler {

	private long a;
	private long b;

	public Euler056(long a, long b) {
		this.a = a;
		this.b = b;
	}

	/**
	 * A googol (10^(100)) is a massive number: one followed by one-hundred
	 * zeros; 100^(100) is almost unimaginably large: one followed by
	 * two-hundred zeros. Despite their size, the sum of the digits in each
	 * number is only 1.
	 * 
	 * Considering natural numbers of the form, a^(b), where a, b < 100, what is
	 * the maximum digital sum?
	 */
	@Override
	public void compute() {
		long max = 0;
		for (long i = 1; i < a; i++) {
			for (int j = 1; j < b; j++) {
				long sum = EulerUtils.sumDigits(BigInteger.valueOf(i).pow(j));
				if (sum > max) {
					max = sum;
				}
			}
		}
		result = BigInteger.valueOf(max);
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		compute(new Euler056(100, 100));
	}

}
